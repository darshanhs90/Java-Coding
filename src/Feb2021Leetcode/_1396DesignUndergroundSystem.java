package Feb2021Leetcode;

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

	static class Pair {
		String startStationName;
		int startTime;

		public Pair(String startStationName, int startTime) {
			this.startStationName = startStationName;
			this.startTime = startTime;
		}
	}

	static class UndergroundSystem {

		HashMap<String, HashMap<String, Integer>> stationTimeMap;
		HashMap<String, HashMap<String, Integer>> stationCountMap;
		HashMap<Integer, Pair> userIdMap;

		public UndergroundSystem() {
			stationTimeMap = new HashMap<String, HashMap<String, Integer>>();
			stationCountMap = new HashMap<String, HashMap<String, Integer>>();
			userIdMap = new HashMap<Integer, Pair>();
		}

		public void checkIn(int id, String stationName, int t) {
			userIdMap.put(id, new Pair(stationName, t));
		}

		public void checkOut(int id, String stationName, int t) {
			Pair pair = userIdMap.get(id);
			int time = t - pair.startTime;
			String srcStationName = pair.startStationName;
			String dstStationName = stationName;

			if (!stationTimeMap.containsKey(srcStationName)) {
				stationTimeMap.put(srcStationName, new HashMap<String, Integer>());
				stationCountMap.put(srcStationName, new HashMap<String, Integer>());

			}
			HashMap<String, Integer> map1 = stationTimeMap.get(srcStationName);
			HashMap<String, Integer> map2 = stationCountMap.get(srcStationName);

			if (map1.containsKey(dstStationName)) {
				map1.put(dstStationName, map1.get(dstStationName) + time);
				map2.put(dstStationName, map2.get(dstStationName) + 1);

			} else {
				map1.put(dstStationName, time);
				map2.put(dstStationName, 1);
			}
		}

		public double getAverageTime(String startStation, String endStation) {
			int time = stationTimeMap.get(startStation).get(endStation);
			int count = stationCountMap.get(startStation).get(endStation);
			return time / (double) count;
		}
	}

}
