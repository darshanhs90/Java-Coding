package Feb2021Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _0323NumberOfConnectedComponentsInAnUndirectedGraph {

	public static void main(String[] args) {
		System.out.println(
				countComponents(5, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 3, 4 } }));

		System.out.println(countComponents(5,
				new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } }));

	}

	public static int countComponents(int n, int[][] edges) {
		
	}

}
