package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

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

}
