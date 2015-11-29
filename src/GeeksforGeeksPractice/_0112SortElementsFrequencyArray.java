package GeeksforGeeksPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * http://www.geeksforgeeks.org/sort-elements-by-frequency/
 */
public class _0112SortElementsFrequencyArray {
	public static void main(String[] args) {
		int arr[] =  {2, 5, 2, 8, 5, 5, 8, 8};
		sortElementsByFrequency(arr);
	}

	private static void sortElementsByFrequency(int[] arr) {
		Arrays.sort(arr);
		Map<Integer, Integer> elementMap=new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(elementMap.containsKey(arr[i]))
				elementMap.put(arr[i],elementMap.get(arr[i])+1);
			else
				elementMap.put(arr[i], 1);
		}
		Object[] keys=elementMap.keySet().toArray();
		Map<Integer, ArrayList<Integer>> reverseElementMap=new TreeMap<>();
		for (int i = 0; i < keys.length; i++) {
			int element=elementMap.get(keys[i]);
			if(reverseElementMap.containsKey(element))
			{
				ArrayList<Integer> al=reverseElementMap.get(element);
				al.add((Integer) keys[i]);
				reverseElementMap.put(element, al);
			}
			else{
				ArrayList<Integer> al=new ArrayList<>();
				al.add((Integer) keys[i]);
				reverseElementMap.put(element, al);
			}
		}
		System.out.println(Arrays.toString(reverseElementMap.values().toArray()));
		System.out.println(Arrays.toString(reverseElementMap.keySet().toArray()));
		
		Object[] values=reverseElementMap.keySet().toArray();
		Arrays.sort(values);
		int index=0;
		for (int i = values.length-1; i >=0; i--) {
			ArrayList<Integer> al=reverseElementMap.get(values[i]);
			for (int j = 0; j < al.size(); j++) {
				Arrays.fill(arr,index,index+(Integer)values[i],al.get(j));
				index=index+(Integer)values[i];
			}
		}
		System.out.println(Arrays.toString(arr));

	}	
}
