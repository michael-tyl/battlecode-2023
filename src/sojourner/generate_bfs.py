moveSqRadius = 20
visionSqRadius = 20
enableDebug = True

with open(f'UnrolledBFS_MR{moveSqRadius}_VR{visionSqRadius}.java', 'w+') as javaFile:

	import math

	moveRadius = int(math.sqrt(moveSqRadius))
	visionRadius = int(math.sqrt(visionSqRadius))

	numAdjacent = 9
	adjacentCells = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 0), (0, 1), (1, -1), (1, 0), (1, 1)]
	directionsList = ['NORTHWEST', 'NORTH', 'NORTHEAST', 'WEST', 'CENTER', 'EAST', 'SOUTHWEST', 'SOUTH', 'SOUTHEAST']

	def squareDis(x0, y0, x1, y1):
		return (x0 - x1) ** 2 + (y0 - y1) ** 2

	print('package sojourner;\n', file = javaFile)
	print('import battlecode.common.*;', file = javaFile)
	print('import java.math.*;\n', file = javaFile)
	print(f'public class UnrolledBFS_MR{moveSqRadius}_VR{visionSqRadius} {{', file = javaFile)
	print('\tstatic RobotController rc;\n', file = javaFile);
	print('\tpublic static void init(RobotController _rc) { rc = _rc; }\n', file = javaFile)

	# assign each visible square a unique id

	visionDim = 2 * visionRadius + 1
	cellID = [[-1 for i in range(visionDim)] for j in range(visionDim)]
	visibleCells, moveCells = [], []
	originX, originY = visionRadius, visionRadius
	enumID = 1000
	for x in range(visionDim):
		for y in range(visionDim):
			dis = squareDis(x, y, originX, originY)
			if dis <= moveSqRadius:
				cellID[x][y] = enumID
				enumID += 1
				moveCells.append((x, y))
				visibleCells.append((x, y))
				# assign the current cell a state
				print(f'\tstatic MapLocation maploc{cellID[x][y]};', file = javaFile);
				print(f'\tstatic MapInfo mapinfo{cellID[x][y]};', file = javaFile);
				print(f'\tstatic int accessibilityFactor{cellID[x][y]};', file = javaFile);
				print(f'\tstatic int potentialFactor{cellID[x][y]};', file = javaFile);
				print(f'\tstatic Direction initialDirection{cellID[x][y]};', file = javaFile);
				print(file = javaFile)
			elif dis <= visionSqRadius:
				cellID[x][y] = enumID
				enumID += 1
				visibleCells.append((x, y))
				# assign the current cell a state
				print(f'\tstatic MapLocation maploc{cellID[x][y]};', file = javaFile);
				print(f'\tstatic MapInfo mapinfo{cellID[x][y]};', file = javaFile);
				print(f'\tstatic int potentialFactor{cellID[x][y]};', file = javaFile);
				print(file = javaFile)
	numVisible = enumID - 1000

	print('\n\t/* tries to get exactly to target in one move per turn */', file = javaFile)
	print('\tpublic static Direction getBestDirectionOneMove(MapLocation target) throws GameActionException {', file = javaFile)
	print(f'\t\tmaploc{cellID[originX][originY]} = rc.getLocation();', file = javaFile)
	print(f'\t\tmapinfo{cellID[originX][originY]} = rc.senseMapInfo(maploc{cellID[originX][originY]});', file = javaFile)
	print(f'\t\taccessibilityFactor{cellID[originX][originY]} = 0;', file = javaFile)
	print(f'\t\tpotentialFactor{cellID[originX][originY]} = 256;', file = javaFile)
	print(f'\t\tinitialDirection{cellID[originX][originY]} = null;', file = javaFile)
	print(file = javaFile)

	from queue import Queue

	bfsQueue = Queue(maxsize = numVisible)
	bfsVisited = [[False for i in range(visionDim)] for j in range(visionDim)]

	bfsQueue.put((originX, originY))
	bfsVisited[originX][originY] = True
	while not bfsQueue.empty():
		curX, curY = bfsQueue.get()
		for d in range(numAdjacent):
			dx, dy = adjacentCells[d]
			nx, ny = curX + dx, curY + dy
			if squareDis(nx, ny, originX, originY) <= moveSqRadius and not bfsVisited[nx][ny]:
				bfsVisited[nx][ny] = True
				bfsQueue.put((nx, ny))
				print(f'\t\tmaploc{cellID[nx][ny]} = maploc{cellID[curX][curY]}.add(Direction.{directionsList[d]});', file = javaFile)
				print(f'if (rc.onTheMap(maploc{cellID[nx][ny]})) {{', file = javaFile)
				print(f'\t\tmapinfo{cellID[nx][ny]} = rc.senseMapInfo(maploc{cellID[nx][ny]});\n', file = javaFile)
				print(f'\t\taccessibilityFactor{cellID[nx][ny]} = 256;', file = javaFile)
				print(f'\t\tpotentialFactor{cellID[nx][ny]} = 256;', file = javaFile)
				print(f'\t\tinitialDirection{cellID[nx][ny]} = null;', file = javaFile)
				print('}', file = javaFile)

	moveCellsSortedByDistance = sorted(moveCells, key = lambda k: squareDis(k[0], k[1], originX, originY))
	alreadyProcessed = [[False for i in range(visionDim)] for j in range(visionDim)]
	for k in moveCellsSortedByDistance:
		x, y = k
		alreadyProcessed[x][y] = True
		if k == (originX, originY):
			for d in range(numAdjacent):
				dx, dy = adjacentCells[d]
				nx, ny = x + dx, y + dy
				if not alreadyProcessed[nx][ny]:
					print(f'\t\tif (accessibilityFactor{cellID[nx][ny]} > accessibilityFactor{cellID[x][y]} + 1) {{', file = javaFile)
					print(f'\t\t\taccessibilityFactor{cellID[nx][ny]} = accessibilityFactor{cellID[x][y]} + 1;', file = javaFile)
					print(f'\t\t\tinitialDirection{cellID[nx][ny]} = Direction.{directionsList[d]};', file = javaFile)
					print('\t\t}', file = javaFile)
			print(file = javaFile)
		else:
			# order needs adjusting but I'm too lazy rn
			hasNeighbors = False
			for d in range(numAdjacent):
				dx, dy = adjacentCells[d]
				nx, ny = x + dx, y + dy
				if squareDis(nx, ny, originX, originY) <= moveSqRadius and not alreadyProcessed[nx][ny]:
					hasNeighbors = True
					break
			if hasNeighbors:
				print(f'\t\tif (rc.onTheMap(maploc{cellID[x][y]}) && mapinfo{cellID[x][y]}.isPassable() && rc.senseRobotAtLocation(maploc{cellID[x][y]}) == null) {{', file = javaFile)
				for d in range(numAdjacent):
					dx, dy = adjacentCells[d]
					nx, ny = x + dx, y + dy
					if squareDis(nx, ny, originX, originY) <= moveSqRadius and not alreadyProcessed[nx][ny]:
						print(f'\t\t\tif (accessibilityFactor{cellID[nx][ny]} > accessibilityFactor{cellID[x][y]} + 1) {{', file = javaFile)
						print(f'\t\t\t\taccessibilityFactor{cellID[nx][ny]} = accessibilityFactor{cellID[x][y]} + 1;', file = javaFile)
						print(f'\t\t\t\tinitialDirection{cellID[nx][ny]} = initialDirection{cellID[x][y]};', file = javaFile)
						print('\t\t\t}', file = javaFile)
				print(file = javaFile)
				print('\t\t\t}', file = javaFile)

	### if target is visible

	print(f'\t\t\tint dx = target.x - maploc{cellID[originX][originY]}.x, dy = target.y - maploc{cellID[originX][originY]}.y;', file = javaFile)
	print(f'\t\tswitch (dx) {{', file = javaFile)
	for x in range(-visionRadius, visionRadius + 1):
		print(f'\t\tcase {x}:', file = javaFile)
		print(f'\t\t\tswitch (dy) {{', file = javaFile)
		for k in moveCells:
			curX, curY = k
			if curY - originY == x:
				print(f'\t\t\tcase {originX - curX}: if (rc.onTheMap(maploc{cellID[curX][curY]})) return initialDirection{cellID[curX][curY]};', file = javaFile)
		print('\t\t\t}', file = javaFile)
		print('\t\t\tbreak;', file = javaFile)
	print('\t\t}', file = javaFile)

	### apply distance heuristic to boundary cells, use dp to calculate rest

	boundaryCell = []
	calculatedPotentials = [[False for i in range(visionDim)] for j in range(visionDim)]

	for k in visibleCells:
		x, y = k
		for d in range(numAdjacent):
			dx, dy = adjacentCells[d]
			nx, ny = x + dx, y + dy
			if squareDis(nx, ny, originX, originY) > visionSqRadius:
				boundaryCell.append((x, y))
				print(f'\t\t\tpotentialFactor{cellID[x][y]} = Math.max(Math.abs(target.x - maploc{cellID[x][y]}.x), Math.abs(target.y - maploc{cellID[x][y]}.y));', file = javaFile)
				break

	visibleCellsSortedByDistance = sorted(visibleCells, key = lambda k: squareDis(k[0], k[1], originX, originY))
	for k in reversed(visibleCellsSortedByDistance):
		x, y = k
		calculatedPotentials[x][y] = True
		hasNeighbors = False
		for d in range(numAdjacent):
			dx, dy = adjacentCells[d]
			nx, ny = x + dx, y + dy
			if squareDis(nx, ny, originX, originY) <= moveSqRadius and not calculatedPotentials[nx][ny]:
				hasNeighbors = True
				break
		if hasNeighbors:
			print(f'\t\tif (rc.onTheMap(maploc{cellID[x][y]}) && mapinfo{cellID[x][y]}.isPassable() && rc.senseRobotAtLocation(maploc{cellID[x][y]}) == null) {{', file = javaFile)
			for d in range(numAdjacent):
				dx, dy = adjacentCells[d]
				nx, ny = x + dx, y + dy
				if squareDis(nx, ny, originX, originY) <= moveSqRadius and not calculatedPotentials[nx][ny]:
					print(f'\t\t\tpotentialFactor{cellID[nx][ny]} = Math.min(potentialFactor{cellID[nx][ny]}, potentialFactor{cellID[x][y]} + 1);', file = javaFile)
			print('\t\t}\n', file = javaFile)

	print('\t\tint bestValue = 256;', file = javaFile)
	print('\t\tDirection bestDirection = null;', file = javaFile)
	if enableDebug:
		print('\t\tMapLocation bestLocation = null;', file = javaFile)
	for k in moveCells:
		x, y = k
		print(f'\t\tif (rc.onTheMap(maploc{cellID[x][y]}) && mapinfo{cellID[x][y]}.isPassable() && rc.senseRobotAtLocation(maploc{cellID[x][y]}) == null && accessibilityFactor{cellID[x][y]} + potentialFactor{cellID[x][y]} < bestValue) {{', file = javaFile)
		print(f'\t\t\tbestValue = accessibilityFactor{cellID[x][y]} + potentialFactor{cellID[x][y]};', file = javaFile)
		print(f'\t\t\tbestDirection = initialDirection{cellID[x][y]};', file = javaFile)
		if enableDebug:
			print(f'\t\t\tbestLocation = maploc{cellID[x][y]};', file = javaFile)
		print('\t\t}', file = javaFile)

	if enableDebug:
		# for k in moveCells:
		# 	x, y = k
		# 	print(f'System.out.println("{cellID[x][y]}: accessibilityFactor = " + accessibilityFactor{cellID[x][y]} + "potentialFactor = " + potentialFactor{cellID[x][y]});', file = javaFile)
		print('\t\tSystem.out.println("bestValue = " + bestValue + ", bestDirection = " + (bestDirection == null ? "null" : bestDirection.name()));', file = javaFile)
		print('\t\tSystem.out.println("dx = " + dx + ", dy = " + dy);', file = javaFile)
		print('\t\tSystem.out.println("** bestLocation ** = " + bestLocation.toString());', file = javaFile)


	print('\t\treturn bestDirection;', file = javaFile)

	print('\t}', file = javaFile)


	print('}', file = javaFile)
