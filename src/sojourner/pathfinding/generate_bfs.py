import sys, math

def generateBFS(moveSqRadius, visionSqRadius, enableDebug = False):
	moveRadius = int(math.sqrt(moveSqRadius))
	visionRadius = int(math.sqrt(visionSqRadius))

	numAdjacent = 9
	adjacentCells = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 0), (0, 1), (1, -1), (1, 0), (1, 1)]
	directionsList = ['NORTHWEST', 'NORTH', 'NORTHEAST', 'WEST', 'CENTER', 'EAST', 'SOUTHWEST', 'SOUTH', 'SOUTHEAST']

	def squareDis(x0, y0, x1, y1):
			return (x0 - x1) ** 2 + (y0 - y1) ** 2

	with open(f'UnrolledBFS_MR{moveSqRadius}_VR{visionSqRadius}.java', 'w+') as javaFile:
		### output header

		currentIndent = 0

		def output(s = ''):
			print(currentIndent * '\t' + s, file = javaFile)

		output('package sojourner.pathfinding;\n')
		output('import battlecode.common.*;')
		output('import sojourner.pathfinding.*;')
		output('import java.math.*;\n')
		output(f'public class UnrolledBFS_MR{moveSqRadius}_VR{visionSqRadius} {{')
		currentIndent += 1
		output('static RobotController rc;\n');
		output('public static void init(RobotController _rc) { rc = _rc; }\n')

		### assign each visible square a unique id and output declarations for each cell

		visionDim = 2 * visionRadius + 1
		cellID = [[-1 for i in range(visionDim)] for j in range(visionDim)]
		visibleCells, moveCells = [], []
		originX, originY = visionRadius, visionRadius
		enumID = 0
		for x in range(visionDim):
			for y in range(visionDim):
				dis = squareDis(x, y, originX, originY)
				if dis <= moveSqRadius:
					cellID[x][y] = str(enumID).zfill(3)
					enumID += 1
					moveCells.append((x, y))
					visibleCells.append((x, y))
					output(f'// {cellID[x][y]}: movable cell at location ({y - originY}, {originX - x}) relative to origin')
					output(f'static MapLocation maploc{cellID[x][y]};');
					output(f'static boolean isPassable{cellID[x][y]};');
					output(f'static MapInfo mapinfo{cellID[x][y]};');
					output(f'static int accessibilityFactor{cellID[x][y]};');
					output(f'static int potentialFactor{cellID[x][y]};');
					output(f'static Direction initialDirection{cellID[x][y]};');
					output()
				elif dis <= visionSqRadius:
					cellID[x][y] = str(enumID).zfill(3)
					enumID += 1
					visibleCells.append((x, y))
					output(f'// {cellID[x][y]}: visible cell at location ({y - originY}, {originX - x}) relative to origin')
					output(f'static MapLocation maploc{cellID[x][y]};');
					output(f'static boolean isPassable{cellID[x][y]};');
					output(f'static MapInfo mapinfo{cellID[x][y]};');
					output(f'static int potentialFactor{cellID[x][y]};');
					output()
		numVisible = enumID

		output()
		output('/* tries to get exactly to target in one move per turn */')
		output('public static Direction getBestDirectionOneMove(MapLocation target) throws GameActionException {')
		currentIndent += 1
		output(f'maploc{cellID[originX][originY]} = rc.getLocation();')
		output(f'mapinfo{cellID[originX][originY]} = rc.senseMapInfo(maploc{cellID[originX][originY]});')
		output(f'isPassable{cellID[originX][originY]} = true;')
		output(f'accessibilityFactor{cellID[originX][originY]} = 0;')
		output(f'potentialFactor{cellID[originX][originY]} = 256;')
		output(f'initialDirection{cellID[originX][originY]} = null;')
		output()

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
					output(f'maploc{cellID[nx][ny]} = maploc{cellID[curX][curY]}.add(Direction.{directionsList[d]});')
					output(f'accessibilityFactor{cellID[nx][ny]} = 256;')
					output(f'potentialFactor{cellID[nx][ny]} = 256;')
					output(f'initialDirection{cellID[nx][ny]} = null;')
					output(f'if (rc.onTheMap(maploc{cellID[nx][ny]})) {{')
					currentIndent += 1
					output(f'mapinfo{cellID[nx][ny]} = rc.senseMapInfo(maploc{cellID[nx][ny]});')
					output(f'isPassable{cellID[nx][ny]} = mapinfo{cellID[nx][ny]}.isPassable() && rc.senseRobotAtLocation(maploc{cellID[nx][ny]}) == null;')
					currentIndent -= 1;
					output('} else {')
					currentIndent += 1
					output(f'isPassable{cellID[nx][ny]} = false;')
					currentIndent -= 1
					output('}\n')
				elif squareDis(nx, ny, originX, originY) <= visionSqRadius and not bfsVisited[nx][ny]:
					bfsVisited[nx][ny] = True
					bfsQueue.put((nx, ny))
					output(f'maploc{cellID[nx][ny]} = maploc{cellID[curX][curY]}.add(Direction.{directionsList[d]});')
					output(f'potentialFactor{cellID[nx][ny]} = 256;')
					output(f'if (rc.onTheMap(maploc{cellID[nx][ny]})) {{')
					currentIndent += 1
					output(f'mapinfo{cellID[nx][ny]} = rc.senseMapInfo(maploc{cellID[nx][ny]});')
					output(f'isPassable{cellID[nx][ny]} = mapinfo{cellID[nx][ny]}.isPassable() && rc.senseRobotAtLocation(maploc{cellID[nx][ny]}) == null;')
					currentIndent -= 1;
					output('} else {')
					currentIndent += 1
					output(f'isPassable{cellID[nx][ny]} = false;')
					currentIndent -= 1
					output('}\n')

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
						output(f'if (accessibilityFactor{cellID[nx][ny]} > accessibilityFactor{cellID[x][y]} + 1) {{')
						currentIndent += 1
						output(f'accessibilityFactor{cellID[nx][ny]} = accessibilityFactor{cellID[x][y]} + 1;')
						output(f'initialDirection{cellID[nx][ny]} = Direction.{directionsList[d]};')
						currentIndent -= 1
						output('}')
				output()
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
					output(f'if (isPassable{cellID[x][y]}) {{')
					currentIndent += 1
					for d in range(numAdjacent):
						dx, dy = adjacentCells[d]
						nx, ny = x + dx, y + dy
						if squareDis(nx, ny, originX, originY) <= moveSqRadius and not alreadyProcessed[nx][ny]:
							output(f'if (accessibilityFactor{cellID[nx][ny]} > accessibilityFactor{cellID[x][y]} + 1) {{')
							currentIndent += 1
							output(f'accessibilityFactor{cellID[nx][ny]} = accessibilityFactor{cellID[x][y]} + 1;')
							output(f'initialDirection{cellID[nx][ny]} = initialDirection{cellID[x][y]};')
							currentIndent -= 1
							output('}')
					currentIndent -= 1
					output('}')

		### if target is visible

		output(f'int dx = target.x - maploc{cellID[originX][originY]}.x, dy = target.y - maploc{cellID[originX][originY]}.y;')
		output(f'switch (dx) {{')
		for x in range(-moveRadius, moveRadius + 1):
			output(f'case {x}:')
			currentIndent += 1
			output(f'switch (dy) {{')
			for k in moveCells:
				curX, curY = k
				if curY - originY == x:
					output(f'case {originX - curX}: return initialDirection{cellID[curX][curY]} == null ? BugPathfinder.getBestDirectionOneMove(target) : initialDirection{cellID[curX][curY]};')
			output('}')
			output('break;')
			currentIndent -= 1
		output('}')

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
					output(f'potentialFactor{cellID[x][y]} = Math.max(Math.abs(target.x - maploc{cellID[x][y]}.x), Math.abs(target.y - maploc{cellID[x][y]}.y));')
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
				output(f'if (isPassable{cellID[x][y]}) {{')
				currentIndent += 1
				for d in range(numAdjacent):
					dx, dy = adjacentCells[d]
					nx, ny = x + dx, y + dy
					if squareDis(nx, ny, originX, originY) <= moveSqRadius and not calculatedPotentials[nx][ny]:
						output(f'potentialFactor{cellID[nx][ny]} = Math.min(potentialFactor{cellID[nx][ny]}, potentialFactor{cellID[x][y]} + 1);')
				currentIndent -= 1
				output('}\n')

		output('int bestValue = 256;')
		output('Direction bestDirection = null;')
		output('Direction tempCurrentDirection = null;')
		if enableDebug:
			output('MapLocation bestLocation = null;')
		for k in moveCells:
			x, y = k

			output(f'if (isPassable{cellID[x][y]}) {{')
			currentIndent += 1
			output(f'tempCurrentDirection = mapinfo{cellID[x][y]}.getCurrentDirection();')
			output('switch (tempCurrentDirection) {')
			for d in range(numAdjacent):
				dx, dy = adjacentCells[d]
				nx, ny = x + dx, y + dy
				if squareDis(nx, ny, originX, originY) <= visionSqRadius and not (nx == originX and ny == originY):
					output(f'case {directionsList[d]}:')
					currentIndent += 1
					output(f'if (isPassable{cellID[nx][ny]} && accessibilityFactor{cellID[x][y]} + potentialFactor{cellID[nx][ny]} < bestValue) {{')
					currentIndent += 1
					output(f'bestValue = accessibilityFactor{cellID[x][y]} + potentialFactor{cellID[nx][ny]};')
					output(f'bestDirection = initialDirection{cellID[x][y]};')
					if enableDebug:
						output(f'bestLocation = maploc{cellID[x][y]};')
					currentIndent -= 1
					output('}')

					output('break;')
					currentIndent -= 1
			output('default: break;')
			output('}')
			currentIndent -= 1
			output('}')
		output()

		if enableDebug:
			output('// System.out.println("bestValue = " + bestValue + ", bestDirection = " + (bestDirection == null ? "null" : bestDirection.name()));')
			output('// System.out.println("dx = " + dx + ", dy = " + dy);')
			output('// System.out.println("bestLocation = " + bestLocation.toString());')
			output(f'if (bestDirection != null) rc.setIndicatorLine(maploc{cellID[originX][originY]}.add(bestDirection), bestLocation, 0, 255, 0);')


		output('return bestDirection;')

		currentIndent -= 1
		output('}')
		currentIndent -= 1
		output('}')

genFor = [(10, 10), (10, 20), (20, 20)]
for k in genFor:
	generateBFS(k[0], k[1], True)

### dangerous!!! (may crash computer)
# for i in range(1, 35):
# 	for j in range(1, i + 1):
# 		generateBFS(j, i)