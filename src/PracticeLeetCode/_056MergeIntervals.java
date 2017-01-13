package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class _056MergeIntervals {
	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public static void main(String[] args) {
		Interval a=new Interval(1,4);
		Interval b=new Interval(0,5);
		//1,3],[2,6],[8,10],[15,18
		List<Interval> intervals =new ArrayList<>();
		//intervals.add(a);
		//intervals.add(b);
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		intervals=(merge(intervals));
		for (int i = 0; i < intervals.size(); i++) {
			System.out.println(intervals.get(i).start+"///"+intervals.get(i).end);
		}
	}
	public static List<Interval> merge(List<Interval> intervals) {
		if(intervals==null||intervals.size()==0)
			return intervals;
		Collections.sort(intervals,new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start==o2.start)
					return o1.end-o2.end;
				return o1.start-o2.start;
			}
		});
		List<Interval> outputList=new ArrayList<>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval=intervals.get(i);
			if(outputList.size()==0)
			{
				outputList.add(interval);
			}else{
				Interval poppedInterval=outputList.get(outputList.size()-1);
				if(interval.start<=poppedInterval.end)
				{
					poppedInterval.end=Math.max(poppedInterval.end, interval.end);
				}
				else{
					outputList.add(interval);
				}
			}
		}
		return outputList;
		
		
	}
}
