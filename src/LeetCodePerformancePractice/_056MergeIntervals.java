package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _056MergeIntervals {
	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public static void main(String[] args) {
		Interval a=new Interval(1, 4);
		Interval b=new Interval(0,5);
		List<Interval> intervals =new ArrayList<>();
		intervals.add(a);
		intervals.add(b);
		intervals=(merge(intervals));
		for (int i = 0; i < intervals.size(); i++) {
			System.out.println(intervals.get(i).start+"///"+intervals.get(i).end);
		}
	}
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> outputList=new ArrayList<>();
		Collections.sort(intervals,new Comparator<Interval>() {
			public int compare(Interval i1,Interval i2)
			{
				if(i1.start!=i2.start)
					return i1.start-i2.start;
				else
					return i1.end-i2.end;
			}
		});
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval=intervals.get(i);
			if(outputList.isEmpty())
			{
				outputList.add(interval);
			}
			else{
				Interval poppedInterval=outputList.get(outputList.size()-1);
				if(poppedInterval.end>=interval.start)
				{
					outputList.remove(outputList.size()-1);
					poppedInterval.end=Math.max(poppedInterval.end, interval.end);
					outputList.add(poppedInterval);
				}
				else{
					outputList.add(interval);
				}
			}
		}
		return outputList;
	}
}
