package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _019EmployeeFreeTime {

	public static void main(String[] args) {
		System.out.println(employeeFreeTime(new ArrayList<List<Interval>>(
				Arrays.asList(new ArrayList<Interval>(Arrays.asList(new Interval(1, 2), new Interval(5, 6))),
						new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))),
						new ArrayList<Interval>(Arrays.asList(new Interval(4, 10)))))));

		System.out.println(employeeFreeTime(new ArrayList<List<Interval>>(
				Arrays.asList(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(6, 7))),
						new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))),
						new ArrayList<Interval>(Arrays.asList(new Interval(2, 5), new Interval(9, 12)))))));

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
		if (schedule == null || schedule.size() == 0)
			return new ArrayList<Interval>();
		List<Interval> mergedIntervals = schedule.get(0);

		for (int i = 1; i < schedule.size(); i++) {
			List<Interval> list = schedule.get(i);
			for (Interval interval : list) {
				mergedIntervals.add(interval);
			}
		}

		Collections.sort(mergedIntervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
		mergedIntervals = mergeIntervals(mergedIntervals);
		List<Interval> freeIntervals = new ArrayList<Interval>();

		for (int i = 1; i < mergedIntervals.size(); i++) {
			freeIntervals.add(new Interval(mergedIntervals.get(i - 1).end, mergedIntervals.get(i).start));
		}

		return freeIntervals;
	}

	public static List<Interval> mergeIntervals(List<Interval> intervals) {
		List<Interval> outputIntervals = new ArrayList<Interval>();
		int prevStart = intervals.get(0).start;
		int prevEnd = intervals.get(0).end;

		for (int i = 1; i < intervals.size(); i++) {
			Interval currInterval = intervals.get(i);
			if (currInterval.start > prevEnd) {
				outputIntervals.add(new Interval(prevStart, prevEnd));
				prevStart = currInterval.start;
				prevEnd = currInterval.end;
			} else {
				prevStart = Math.min(prevStart, currInterval.start);
				prevEnd = Math.max(prevEnd, currInterval.end);
			}
		}
		outputIntervals.add(new Interval(prevStart, prevEnd));
		return outputIntervals;
	}

}
