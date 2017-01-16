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
		int number,count;
		public Pair(int number,int count) {
			this.number=number;
			this.count=count;
		}
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> outputList=new ArrayList<>();
		if(nums==null||nums.length==0)
			return outputList;
		HashMap<Integer, Integer> map=new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i]))
			{
				map.put(nums[i], map.get(nums[i])+1);
			}
			else{
				map.put(nums[i], 1);
			}
		}
		PriorityQueue<Pair> queue=new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1,Pair p2)
			{
				return p1.count-p2.count;
			}
		});
		for(Map.Entry<Integer, Integer> entry:map.entrySet())
		{
			queue.add(new Pair(entry.getKey(),entry.getValue()));
			if(queue.size()>k)
				queue.poll();
		}
		while(!queue.isEmpty())
		{
			outputList.add(queue.poll().number);
		}
		Collections.reverse(outputList);
		return outputList;
	}


}
