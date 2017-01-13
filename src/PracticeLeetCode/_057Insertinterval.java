package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import PracticeLeetCode._056MergeIntervals.Interval;

public class _057Insertinterval {
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}


	public static void main(String[] args) {
		Interval newInterval=new Interval(2,7);
		Interval a=new Interval(1,5);
		List<Interval> intervals=new ArrayList<>();
		intervals.add(a);

		intervals=insert(intervals,newInterval);
		for (int i = 0; i < intervals.size(); i++) {
			System.out.println(intervals.get(i).start+"//"+intervals.get(i).end);
		}
	}
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals==null)
			return intervals;
		if(newInterval!=null)
			intervals.add(newInterval);
		return merge(intervals);
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
