package Dec2020Leetcode;

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

	static class Source {
		String srcStationName;
		int startTime;

		public Source(String srcStationName, int startTime) {
			this.srcStationName = srcStationName;
			this.startTime = startTime;
		}

	}

	static class UndergroundSystem {
		HashMap<Integer, Source> userIdTravelMap;
		HashMap<String, HashMap<String, Integer>> srcDestTimes;
		HashMap<String, HashMap<String, Integer>> srcDestCount;

		public UndergroundSystem() {
			userIdTravelMap = new HashMap<Integer, Source>();
			srcDestTimes = new HashMap<String, HashMap<String, Integer>>();
			srcDestCount = new HashMap<String, HashMap<String, Integer>>();
		}

		public void checkIn(int id, String stationName, int t) {
			userIdTravelMap.put(id, new Source(stationName, t));
		}

		public void checkOut(int id, String stationName, int t) {
			Source src = userIdTravelMap.get(id);
			String sourceStationName = src.srcStationName;
			String destStationName = stationName;
			userIdTravelMap.remove(id);
			int time = t - src.startTime;
			if (srcDestTimes.containsKey(sourceStationName)) {
				HashMap<String, Integer> destTimeMap = srcDestTimes.get(sourceStationName);
				HashMap<String, Integer> destCountMap = srcDestCount.get(sourceStationName);
				if (destTimeMap.containsKey(destStationName)) {
					Integer count = destTimeMap.get(destStationName);
					destTimeMap.put(destStationName, count + time);

					count = destCountMap.get(destStationName);
					destCountMap.put(destStationName, count + 1);
				} else {
					destTimeMap.put(destStationName, time);
					destCountMap.put(destStationName, 1);
				}
			} else {

				HashMap<String, Integer> mapTime = new HashMap<String, Integer>();
				HashMap<String, Integer> mapCount = new HashMap<String, Integer>();
				mapTime.put(destStationName, time);
				mapCount.put(destStationName, 1);
				srcDestTimes.put(sourceStationName, mapTime);
				srcDestCount.put(sourceStationName, mapCount);
			}
		}

		public double getAverageTime(String startStation, String endStation) {
			return srcDestTimes.get(startStation).get(endStation)
					/ (double) srcDestCount.get(startStation).get(endStation);
		}
	}

}
