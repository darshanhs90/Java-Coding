package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class _42squareChallenge {
	public static void main(String[] args) throws Exception {

		BufferedReader scanner = new BufferedReader(new InputStreamReader(
				System.in));
		int noOfTestCases = Integer.parseInt(scanner.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < noOfTestCases; i++) {
			String item = scanner.readLine();
			if (map.containsKey(item)){
				map.put(item, map.get(item) + 1);
			}
			else
				map.put(item, 1);
		}
		TreeMap<String, Integer> t = new TreeMap<String, Integer>();

		Map<String, Integer> m = new TreeMap<String, Integer>();
		m = sortByComparator(map);
		Object a[] = m.keySet().toArray();
		Object b[] = m.values().toArray();
		TreeMap<Integer, ArrayList<String>> tm = new TreeMap<Integer, ArrayList<String>>();
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < b.length; i++) {
			if (tm.get(b[i]) != null) {
				al = tm.get(b[i]);
				al.add(a[i].toString());
				tm.put((int)b[i],al);
			} else {
				al = new ArrayList<String>();
				al.add(a[i].toString());
				tm.put((int)b[i],al);
			}
		}
		NavigableMap nmap=tm.descendingMap();
		Object values[]=nmap.values().toArray();
		Object keys[]=nmap.keySet().toArray();
		int counter=0;
		for (int i = 0; i < keys.length; i++) {
			ArrayList<String> aList=(ArrayList<String>) values[i];
			Collections.sort(aList);
			for (int j = 0; j < aList.size(); j++) {

				System.out.println(aList.get(j));
				counter=counter+1;
				if(counter==3)
					System.exit(0);
			}
		}

		


	}

	private static Map<String, Integer> sortByComparator(
			Map<String, Integer> unsortMap) {

		// Convert Map to List
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(
				unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// Convert sorted map back to a Map
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it
				.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
