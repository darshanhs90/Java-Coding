package Warmup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class _65googleAssessment2 {
	public static  ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, new IntervalComparator());
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (prev.end >= curr.start ||prev.end+1 == curr.start) {
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervalList=new ArrayList<>();
		intervalList.add(new Interval(2, 3));
		intervalList.add(new Interval(4, 5));
		intervalList.add(new Interval(8, 10));
		intervalList.add(new Interval(9, 11));
		intervalList=merge(intervalList);
		for (int i = 0; i < intervalList.size(); i++) {
			System.out.println(intervalList.get(i).start+"/"+intervalList.get(i).end);
		}
	}
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}






