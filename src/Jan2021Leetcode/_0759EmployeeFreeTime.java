package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _0759EmployeeFreeTime {

	public static void main(String[] args) {
		List<List<Interval>> intervals = new ArrayList<List<Interval>>();
		List<Interval> interval1 = new ArrayList<Interval>();
		interval1.add(new Interval(1, 2));
		interval1.add(new Interval(5, 6));

		List<Interval> interval2 = new ArrayList<Interval>();
		interval1.add(new Interval(1, 3));

		List<Interval> interval3 = new ArrayList<Interval>();
		interval3.add(new Interval(4, 10));

		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);

		System.out.println(employeeFreeTime(intervals));

		intervals = new ArrayList<List<Interval>>();
		interval1 = new ArrayList<Interval>();
		interval1.add(new Interval(1, 3));
		interval1.add(new Interval(6, 7));

		interval2 = new ArrayList<Interval>();
		interval1.add(new Interval(2, 4));

		interval3 = new ArrayList<Interval>();
		interval3.add(new Interval(2, 5));
		interval3.add(new Interval(9, 12));

		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);

		System.out.println(employeeFreeTime(intervals));

	}

	static class Interval {
		public int start;
		public int end;

		public Interval() {
		}

		public Interval(int _start, int _end) {
			start = _start;
			end = _end;
		}
	};

	public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> output = new ArrayList<Interval>();
		if (schedule == null || schedule.size() == 0)
			return output;
		List<Interval> allIntervals = schedule.get(0);
		for (int i = 1; i < schedule.size(); i++) {
			List<Interval> subIntervals = schedule.get(i);
			allIntervals.addAll(subIntervals);
		}

		Collections.sort(allIntervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start == o2.start)
					return o1.end - o2.end;
				return o1.start - o2.start;
			}
		});

		List<Interval> mergedIntervals = new ArrayList<Interval>();

		int prevStart = allIntervals.get(0).start;
		int prevEnd = allIntervals.get(0).end;
		for (int i = 1; i < allIntervals.size(); i++) {
			Interval currInterval = allIntervals.get(i);

			if (currInterval.start >= prevStart && currInterval.start <= prevEnd) {
				prevEnd = Math.max(prevEnd, currInterval.end);
			} else {
				mergedIntervals.add(new Interval(prevStart, prevEnd));
				prevStart = currInterval.start;
				prevEnd = currInterval.end;
			}
		}
		mergedIntervals.add(new Interval(prevStart, prevEnd));

		prevEnd = mergedIntervals.get(0).end;
		for (int i = 1; i < mergedIntervals.size(); i++) {
			Interval currInterval = mergedIntervals.get(i);
			output.add(new Interval(prevEnd, currInterval.start));
			prevEnd = currInterval.end;
		}

		for (Interval inter : output) {
			System.out.println(inter.start + "/" + inter.end);
		}

		return output;
	}

}
