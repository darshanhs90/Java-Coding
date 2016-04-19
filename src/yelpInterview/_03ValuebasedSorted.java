package yelpInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class _03ValuebasedSorted {


	public static void main(String a[]){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("java", 20);
		map.put("C++", 45);
		map.put("Java2Novice", 2);
		map.put("Unix", 2);
		map.put("MAC", 26);
		map.put("Other", 93);
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
		Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
		{
			public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
			{
				return (o1.getValue()).compareTo( o2.getValue() );
			}
		} );
		for(Map.Entry<String, Integer> entry:list){
			System.out.println(entry.getKey()+" ==== "+entry.getValue());
		}

		System.out.println("############");
		System.out.println("2nd Approach");
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("a", 10);
		map1.put("b", 30);
		map1.put("c", 50);
		map1.put("d", 20);
		map1.put("e", 20);
		System.out.println(map1);

		TreeMap<String, Integer> sortedMap = sortMapByValue(map1);  
		System.out.println(sortedMap);
	}
	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
		Comparator<String> comparator = new ValueComparator(map);
		//TreeMap is a map sorted by its keys. 
		//The comparator is used to sort the TreeMap by keys. 
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}
	static class ValueComparator implements Comparator<String>{

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		public ValueComparator(HashMap<String, Integer> map){
			this.map.putAll(map);
		}

		@Override
		public int compare(String s1, String s2) {
			if(map.get(s1) >= map.get(s2)){
				return -1;
			}else{
				return 1;
			}	
		}
	}
}






