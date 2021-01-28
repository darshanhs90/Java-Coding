package Jan2021Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class _0882ReachableNodesInSubdividedGraph {

	public static void main(String[] args) {
		System.out.println(reachableNodes(
				new int[][] { new int[] { 0, 1, 10 }, new int[] { 0, 2, 1 }, new int[] { 1, 2, 2 } }, 6, 3));

		System.out.println(reachableNodes(new int[][] { new int[] { 0, 1, 4 }, new int[] { 1, 2, 6 },
				new int[] { 0, 2, 8 }, new int[] { 1, 3, 1 } }, 10, 4));
	}

	public static int reachableNodes(int[][] edges, int M, int N) {
		
	}

}
