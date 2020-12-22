package LeetcodeTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0997FindTheTownJudge {
	public static void main(String[] args) {
		System.out.println(findJudge(2, new int[][] { new int[] { 1, 2 } }));
		System.out.println(findJudge(3, new int[][] { new int[] { 1, 3 }, new int[] { 2, 3 } }));
		System.out.println(findJudge(3, new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 1 } }));
		System.out.println(findJudge(3, new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 } }));
		System.out.println(findJudge(4, new int[][] { new int[] { 1, 3 }, new int[] { 1, 4 }, new int[] { 2, 3 },
				new int[] { 2, 4 }, new int[] { 4, 3 } }));
	}

	
}
