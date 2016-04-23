package yelpInterview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _Array22SortElementsByFrequency {
	static class PositionCount{
		int index;
		int count;
	}
	public static void main(String a[]){
		int inputArray[] ={2, 5, 2, 8, 5, 6, 8, 8};
		sortByFrequency(inputArray);
	}

	private static void sortByFrequency(int[] inputArray) {
		HashMap<Integer,PositionCount> map=new HashMap<>();
		for (int i = 0; i < inputArray.length; i++) {
			if(map.containsKey(inputArray[i]))
			{
				PositionCount pc=map.get(inputArray[i]);
				pc.count++;
				map.put(inputArray[i], pc);
			}
			else{
				PositionCount pc=new PositionCount();
				pc.count=1;
				pc.index=i;
				map.put(inputArray[i], pc);
			}
		}
		Map sortedMap = sortByValue(map);
		System.out.println(sortedMap);


	}
	public static Map sortByValue(Map unsortedMap) {
		Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}

	static class ValueComparator implements Comparator {
		Map map;

		public ValueComparator(Map map) {
			this.map = map;
		}

		@Override
		public int compare(Object keyA, Object keyB) {
			PositionCount pc1=(PositionCount) map.get(keyA);
			PositionCount pc2=(PositionCount) map.get(keyB);
			if(pc1.count==pc2.count){
				return pc1.index>pc2.index?1:-1;
			}
			else{
				return pc1.count>pc2.count?-1:+1;
			}
		}
	}


}