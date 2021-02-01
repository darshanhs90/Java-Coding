package Jan2021Leetcode;

import java.util.HashMap;

public class _1396DesignUndergroundSystem {
	public static void main(String[] args) {
		UndergroundSystem undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		undergroundSystem.checkOut(45, "Waterloo", 15);
		undergroundSystem.checkOut(27, "Waterloo", 20);
		undergroundSystem.checkOut(32, "Cambridge", 22);
		System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // return 14.00000. There was
																						// only one travel from
		// "Paradise" (at time 8) to "Cambridge" (at time
		// 22)
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); // return 11.00000. There were two
																					// travels from "Leyton"
		// to "Waterloo", a customer with id=45 from time=3 to
		// time=15 and a customer with id=27 from time=10 to
		// time=20. So the average time is ( (15-3) + (20-10) )
		// / 2 = 11.00000
		undergroundSystem.checkIn(10, "Leyton", 24);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); // return 11.00000
		undergroundSystem.checkOut(10, "Waterloo", 38);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); // return 12.00000

		undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(10, "Leyton", 3);
		undergroundSystem.checkOut(10, "Paradise", 8);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.00000
		undergroundSystem.checkIn(5, "Leyton", 10);
		undergroundSystem.checkOut(5, "Paradise", 16);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000
		undergroundSystem.checkIn(2, "Leyton", 21);
		undergroundSystem.checkOut(2, "Paradise", 30);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667
	}

	static class UserJourney {
		String startStationName;
		int startTime;

		public UserJourney(String startStationName, int startTime) {
			this.startStationName = startStationName;
			this.startTime = startTime;
		}
	}

	static class UndergroundSystem {
		HashMap<String, HashMap<String, Integer>> timeMap;
		HashMap<Integer, UserJourney> userMap;
		HashMap<String, HashMap<String, Integer>> countMap;

		public UndergroundSystem() {
			timeMap = new HashMap<String, HashMap<String, Integer>>();
			userMap = new HashMap<Integer, UserJourney>();
			countMap = new HashMap<String, HashMap<String, Integer>>();
		}

		public void checkIn(int id, String stationName, int t) {
			userMap.put(id, new UserJourney(stationName, t));
		}

		public void checkOut(int id, String endStation, int t) {
			int timeElapsed = t - userMap.get(id).startTime;
			String startStation = userMap.get(id).startStationName;

			if (timeMap.containsKey(startStation)) {
				HashMap<String, Integer> innerTotalMap = timeMap.get(startStation);
				HashMap<String, Integer> innerCountMap = countMap.get(startStation);
				if (innerTotalMap.containsKey(endStation)) {
					innerTotalMap.put(endStation, innerTotalMap.get(endStation) + timeElapsed);
					innerCountMap.put(endStation, innerCountMap.get(endStation) + 1);
				} else {
					innerTotalMap.put(endStation, timeElapsed);
					innerCountMap.put(endStation, 1);
				}
			} else {
				HashMap<String, Integer> innerTotalMap = new HashMap<String, Integer>();
				HashMap<String, Integer> innerCountMap = new HashMap<String, Integer>();
				innerTotalMap.put(endStation, timeElapsed);
				innerCountMap.put(endStation, 1);
				timeMap.put(startStation, innerTotalMap);
				countMap.put(startStation, innerCountMap);
			}
		}

		public double getAverageTime(String startStation, String endStation) {
			return timeMap.get(startStation).get(endStation) / (double) countMap.get(startStation).get(endStation);
		}
	}

}
