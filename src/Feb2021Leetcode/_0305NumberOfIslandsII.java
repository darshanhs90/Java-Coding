package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0305NumberOfIslandsII {

	public static void main(String[] args) {
		System.out.println(numIslands2(3, 3,
				new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 1 } }));

		System.out.println(numIslands2(8, 6,
				new int[][] { new int[] { 0, 5 }, new int[] { 5, 4 }, new int[] { 5, 2 }, new int[] { 7, 3 },
						new int[] { 6, 0 }, new int[] { 5, 3 }, new int[] { 5, 1 }, new int[] { 1, 3 },
						new int[] { 4, 3 }, new int[] { 2, 3 }, new int[] { 3, 5 }, new int[] { 3, 2 },
						new int[] { 3, 0 }, new int[] { 2, 4 }, new int[] { 0, 1 } }));

	}

	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
		int islandNum = 0;
		HashMap<Integer, List<int[]>> islandToPointsMap = new HashMap<Integer, List<int[]>>();
		HashMap<String, Integer> pointToIslandMap = new HashMap<String, Integer>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < positions.length; i++) {
			int x = positions[i][0];
			int y = positions[i][1];
			String identifier = x + "/" + y;
			if (pointToIslandMap.containsKey(identifier)) {
				output.add(islandToPointsMap.size());
				continue;
			}

			HashSet<Integer> overLappingIslands = new HashSet<Integer>();
			for (int j = 0; j < dirs.length; j++) {
				int newX = x + dirs[j][0];
				int newY = y + dirs[j][1];
				if (newX >= 0 && newY >= 0 && newX < m && newY < n && pointToIslandMap.containsKey(newX + "/" + newY)) {
					overLappingIslands.add(pointToIslandMap.get(newX + "/" + newY));
				}
			}

			if (overLappingIslands.size() == 0) {
				islandToPointsMap.put(islandNum, new ArrayList<int[]>());
				islandToPointsMap.get(islandNum).add(new int[] { x, y });
				pointToIslandMap.put(x + "/" + y, islandNum);
				islandNum++;
			} else if (overLappingIslands.size() == 1) {
				Integer baseIsland = overLappingIslands.iterator().next();
				islandToPointsMap.get(baseIsland).add(new int[] { x, y });
				pointToIslandMap.put(x + "/" + y, baseIsland);
			} else {
				Iterator<Integer> iter = overLappingIslands.iterator();
				Integer baseIsland = iter.next();
				islandToPointsMap.get(baseIsland).add(new int[] { x, y });
				pointToIslandMap.put(x + "/" + y, baseIsland);
				
				
				while(iter.hasNext())
				{
					Integer currIsland = iter.next();
					List<int[]> islandPoints = islandToPointsMap.get(currIsland);
					for (int j = 0; j < islandPoints.size(); j++) {
						int[] currPoint = islandPoints.get(j);
						pointToIslandMap.put(currPoint[0]+"/"+currPoint[1], baseIsland);
					}
					
					islandToPointsMap.get(baseIsland).addAll(islandPoints);
					islandToPointsMap.remove(currIsland);
				}
			}
			output.add(islandToPointsMap.size());
		}
		return output;
	}

}
