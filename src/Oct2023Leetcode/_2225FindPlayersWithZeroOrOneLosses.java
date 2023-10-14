package Oct2023Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class _2225FindPlayersWithZeroOrOneLosses {
	public static void main(String[] args) {
		System.out.println(findWinners(new int[][] { new int[] { 1, 3 }, new int[] { 2, 3 }, new int[] { 3, 6 },
				new int[] { 5, 6 }, new int[] { 5, 7 }, new int[] { 4, 5 }, new int[] { 4, 8 }, new int[] { 4, 9 },
				new int[] { 10, 4 }, new int[] { 10, 9 } }));
		System.out.println(findWinners(
				new int[][] { new int[] { 2, 3 }, new int[] { 1, 3 }, new int[] { 5, 4 }, new int[] { 6, 4 } }));
	}

	public static List<List<Integer>> findWinners(int[][] matches) {
		HashMap<Integer, Integer> loseMap = new HashMap<Integer, Integer>();
		TreeSet<Integer> players = new TreeSet<Integer>();
		for (int i = 0; i < matches.length; i++) {
			int winner = matches[i][0];
			int loser = matches[i][1];
			loseMap.compute(loser, (k, v) -> v == null ? 1 : v + 1);
			players.add(winner);
			players.add(loser);
		}
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		List<Integer> winnersOnlyList = new ArrayList<Integer>();
		List<Integer> singleMatchLosersList = new ArrayList<Integer>();
		for (Integer player : players) {
			if (!loseMap.containsKey(player)) {
				winnersOnlyList.add(player);
			} else if (loseMap.get(player) == 1) {
				singleMatchLosersList.add(player);
			}
		}
		output.add(winnersOnlyList);
		output.add(singleMatchLosersList);
		return output;
	}
}
