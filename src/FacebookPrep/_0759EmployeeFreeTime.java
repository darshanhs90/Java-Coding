package FacebookPrep;

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
		List<Interval> allIntervals = new ArrayList<Interval>();
		if (schedule == null || schedule.size() == 0)
			return allIntervals;

		for (List<Interval> intervals : schedule) {
			allIntervals.addAll(intervals);
		}

		Collections.sort(allIntervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		List<Interval> mergedIntervals = new ArrayList<Interval>();
		int prevStart = allIntervals.get(0).start;
		int prevEnd = allIntervals.get(0).end;

		for (int i = 1; i < allIntervals.size(); i++) {
			Interval currInterval = allIntervals.get(i);
			int currStart = currInterval.start;
			int currEnd = currInterval.end;

			if (currStart >= prevStart && currStart <= prevEnd) {

				prevEnd = Math.max(currEnd, prevEnd);
			} else {
				mergedIntervals.add(new Interval(prevStart, prevEnd));
				prevStart = currStart;
				prevEnd = currEnd;
			}
		}
		mergedIntervals.add(new Interval(prevStart, prevEnd));

		List<Interval> freeTime = new ArrayList<Interval>();
		for (int i = 0; i < mergedIntervals.size() - 1; i++) {
			Interval currInterval = mergedIntervals.get(i);
			Interval nextInterval = mergedIntervals.get(i + 1);
			freeTime.add(new Interval(currInterval.end, nextInterval.start));
		}
		return freeTime;
	}

}
