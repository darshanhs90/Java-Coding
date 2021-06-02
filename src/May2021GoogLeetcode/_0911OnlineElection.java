package May2021GoogLeetcode;

import java.util.HashMap;
import java.util.TreeMap;

public class _0911OnlineElection {
	public static void main(String[] args) {
		TopVotedCandidate tvc = new TopVotedCandidate(new int[] { 0, 1, 1, 0, 0, 1, 0 },
				new int[] { 0, 5, 10, 15, 20, 25, 30 });

		System.out.println(tvc.q(3));
		System.out.println(tvc.q(12));
		System.out.println(tvc.q(25));
		System.out.println(tvc.q(15));
		System.out.println(tvc.q(24));
		System.out.println(tvc.q(8));
	}

	static class TopVotedCandidate {
		HashMap<Integer, Integer> countMap;
		TreeMap<Integer, Integer> topMap;

		public TopVotedCandidate(int[] persons, int[] times) {
			countMap = new HashMap<Integer, Integer>();
			topMap = new TreeMap<Integer, Integer>();
			int maxVotesPerson = 0;
			int maxVotesValue = 0;
			for (int i = 0; i < times.length; i++) {
				countMap.compute(persons[i], (k, v) -> v == null ? 1 : v + 1);

				if (countMap.get(persons[i]) >= maxVotesValue) {
					maxVotesValue = countMap.get(persons[i]);
					maxVotesPerson = persons[i];
				}

				topMap.put(times[i], maxVotesPerson);
			}

		}

		public int q(int t) {
			return topMap.floorEntry(t).getValue();
		}
	}
}
