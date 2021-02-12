package Jan2021Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _0957PrisonCellsAfterNDays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(prisonAfterNDays(new int[] { 0, 1, 0, 1, 1, 0, 0, 1 }, 7)));
		System.out.println(Arrays.toString(prisonAfterNDays(new int[] { 1, 0, 0, 1, 0, 0, 1, 0 }, 1000000000)));
	}

	public static int[] prisonAfterNDays(int[] cells, int N) {
		HashMap<Integer, int[]> intStrMap = new HashMap<Integer, int[]>();
		HashMap<String, Integer> strIntMap = new HashMap<String, Integer>();
		HashSet<String> set = new HashSet<String>();
		int[] prevState = cells;
		for (int i = 0; i < N; i++) {
			String prevStr = Arrays.toString(prevState);
			if (set.contains(prevStr)) {
				int repLength = set.size();
				int extra = N % repLength;
				return intStrMap.get(extra+1);
			} else {
				set.add(prevStr);
				strIntMap.put(prevStr, i);
				intStrMap.put(i, prevState);
				int[] nextState = new int[cells.length];
				for (int j = 1; j < nextState.length - 1; j++) {
					int count = prevState[j - 1] + prevState[j + 1];
					nextState[j] = count == 1 ? 0 : 1;
				}
				prevState = nextState;
			}
		}
		return prevState;
	}
}
