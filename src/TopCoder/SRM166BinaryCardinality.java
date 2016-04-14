package TopCoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * SRM 166 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1519&rd=4635
 */



public class SRM166BinaryCardinality {

	public static void main(String[] args) {
		//System.out.println(Arrays.toString(arrange(new int[]{4})));
		//System.out.println(Arrays.toString(arrange(new int[]{31,15,7,3,2})));
		//System.out.println(Arrays.toString(arrange(new int[]{10,9,8,7,6,5,4,3,2,1})));
		//System.out.println(Arrays.toString(arrange(new int[]{811385,340578,980086,545001,774872,855585,13848,863414,419523,190151,784903,127461})));
		System.out.println(Arrays.toString(arrange(new int[]{2, 1, 0, 2, 1, 0, 2, 1, 0, 2, 1, 0})));

	}

	public static int[] arrange(int[] numbers){
		HashMap<Integer, Integer> onesCount=new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			onesCount.put(numbers[i], Integer.bitCount(numbers[i]));
		}
		System.out.println(onesCount);
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
		m = sortByComparator(onesCount);
		Object arr[]=m.keySet().toArray();
		for (int i = 0; i < arr.length; i++) {
			numbers[i]=(Integer)arr[i];
		}
		return numbers;
	}
	private static Map<Integer, Integer> sortByComparator(
			Map<Integer, Integer> unsortMap) {

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(
				unsortMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1,
					Map.Entry<Integer, Integer> o2) {
				int value=(o1.getValue()).compareTo(o2.getValue());
				if(value==0)
					return o1.getKey().compareTo(o2.getKey());
				else
					return value;

			}
		});
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		for (Iterator<Map.Entry<Integer, Integer>> it = list.iterator(); it
				.hasNext();) {
			Map.Entry<Integer, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
