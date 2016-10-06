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
	
}
