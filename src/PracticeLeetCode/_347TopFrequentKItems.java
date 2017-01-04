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
		int value,count;
		public Pair(int value,int count) {
			this.value=value;
			this.count=count;
		}
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> countMap=new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(countMap.containsKey(nums[i])){
				countMap.put(nums[i], countMap.get(nums[i])+1);
			}
			else{
				countMap.put(nums[i], 1);				
			}
		}
		PriorityQueue<Pair> queue=new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return (o1.count-o2.count);
			}
		});
		for(Map.Entry<Integer,Integer> entry :countMap.entrySet()){
			queue.offer(new Pair(entry.getKey(),entry.getValue()));
			if(queue.size()>k)
				queue.poll();
		}
		List<Integer> list=new ArrayList<>();
		while(!queue.isEmpty())
		{
			list.add(queue.poll().value);
		}
		Collections.reverse(list);
		return list;
	}


}
