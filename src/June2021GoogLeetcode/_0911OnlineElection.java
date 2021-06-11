package June2021GoogLeetcode;

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
		HashMap<Integer, Integer> votesMap = new HashMap<Integer, Integer>();
		Integer currMax = 0;
		Integer currMaxPerson = null;
		TreeMap<Integer, Integer> timeMap = new TreeMap<Integer, Integer>();

		public TopVotedCandidate(int[] persons, int[] times) {
			for (int i = 0; i < persons.length; i++) {
				int currPerson = persons[i];
				int time = times[i];
				votesMap.compute(currPerson, (k, v) -> v == null ? 1 : v + 1);

				if (votesMap.get(currPerson) >= currMax) {
					currMax = votesMap.get(currPerson);
					currMaxPerson = currPerson;
				}

				timeMap.put(time, currMaxPerson);
			}
		}

		public int q(int t) {
			return timeMap.floorEntry(t).getValue();
		}
	}
}
