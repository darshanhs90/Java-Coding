package LeetcodeTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _1192CriticalConnectionsInANetwork {
	public static void main(String[] args) {
		System.out.println(criticalConnections(4,
				new ArrayList<List<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(0, 1)),
						new ArrayList<Integer>(Arrays.asList(1, 2)), new ArrayList<Integer>(Arrays.asList(2, 0)),
						new ArrayList<Integer>(Arrays.asList(1, 3))))));
	}

	public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		
	}
	

}
