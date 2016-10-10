package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _347TopFrequentKItems {
	public static void main(String[] args) {
		System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
	}

	static class Pair{
		int element,value;
		public Pair(int element,int value) {
			this.element=element;
			this.value=value;
		}
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> outputList=new ArrayList<>();
		if(nums==null||nums.length==0)
			return outputList;
		PriorityQueue<Pair> pair=new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.value-o2.value;
			}
		});
		HashMap<Integer,Integer> count=new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(count.containsKey(nums[i]))
			{
				count.put(nums[i], count.get(nums[i])+1);
			}
			else{
				count.put(nums[i],1);	
			}
		}
		for (Map.Entry<Integer, Integer> entry:count.entrySet()) {

			int key=entry.getKey();
			int value=entry.getValue();
			Pair p=new Pair(key, value);
			pair.offer(p);
			if(pair.size()>k)
				pair.poll();
		}

		while(!pair.isEmpty())
		{
			outputList.add(pair.poll().element);
		}
		Collections.reverse(outputList);
		return outputList;
	}
}
