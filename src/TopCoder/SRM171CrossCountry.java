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
import java.util.Map.Entry;

/*
 * SRM 171 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1950&rd=4660
 */



public class SRM171CrossCountry {
	static HashMap<String, Integer> sumMap=new HashMap<>();
	static HashMap<String, Integer> countMap=new HashMap<>();
	static HashMap<String, Integer> sixthMap=new HashMap<>();
	public static void main(String[] args) {
		System.out.println(scoreMeet(2,"AABBABBABBA"));
		System.out.println(scoreMeet(3,"CCCBBBBBAAACC"));
		System.out.println(scoreMeet(4,"ABDCBADBDCCDBCDBCAAAC"));
		System.out.println(scoreMeet(10,"BDHCEAJBIDBCCHGCBDJEBAAHEGAGGADHGIECJEHAEBDADJCDHG"));
		System.out.println(scoreMeet(3,"BABCAABABAB"));
	}

	public static String scoreMeet(int numTeams, String finishOrder){
		sumMap=new HashMap<>();
		countMap=new HashMap<>();
		for (int i = 0; i < finishOrder.length(); i++) {
			char c =finishOrder.charAt(i);
			if(sumMap.containsKey(c+"")){
				if(countMap.get(c+"")==5)
				{
					sixthMap.put(c+"", i+1);	
				}
				if(countMap.get(c+"")<=4)
					sumMap.put(c+"",sumMap.get(c+"")+i+1);
				countMap.put(c+"", countMap.get(c+"")+1);
			}else{
				sumMap.put(c+"",i+1);
				countMap.put(c+"",1);
			}
		}
		Map<String, Integer> m =sortByComparator();
		StringBuilder sb=new StringBuilder();
		Object []arr=m.keySet().toArray();
		for (int i = 0; i < arr.length; i++) {
			String st=(String) arr[i];
			if(countMap.get(st)>=5)
				sb.append(st);
		}
		return sb.toString();
	}
	private static Map<String, Integer> sortByComparator() {

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(
				sumMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue()>o2.getValue())
					return 1;
				else if(o1.getValue()<o2.getValue())
					return -1;
				else{
					String key1=o1.getKey();
					String key2=o2.getKey();
					if(countMap.get(key1)==6 && countMap.get(key1)==6){
						return (sixthMap.get(key1).compareTo(sixthMap.get(key2)));
					}else
						if((countMap.get(key1)==6 || countMap.get(key1)==6) && countMap.get(key1)>countMap.get(key2))
							return 1;
						else if((countMap.get(key1)==6 || countMap.get(key1)==6) && countMap.get(key1)<countMap.get(key2))
							return -1;
						else{
							return key1.compareTo(key2);
						}
				}
			}
		});
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it
				.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
