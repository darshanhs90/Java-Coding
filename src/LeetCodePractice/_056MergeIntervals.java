package LeetCodePractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class _056MergeIntervals {

	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public static void main(String[] args) {



		ArrayList<Interval> aList=new ArrayList<>();
		aList.add(new Interval(1, 4));
		aList.add(new Interval(4,5));
		//aList.add(new Interval(8, 10));
		//aList.add(new Interval(15, 18));
		aList=(ArrayList<Interval>) merge(aList);
		for (int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i).start+"///"+aList.get(i).end);
		}
	}

	public static List<Interval> merge(List<Interval> intervals) {
		Stack<Interval> stack=new Stack<>();
		List<Interval> outputList=new ArrayList<>();
		Collections.sort(intervals,new Comparator<Interval>() {

			@Override
			public int compare(Interval i1, Interval i2) {
				if(i1.start!=i2.start)
					return i1.start-i2.start;
				else
					return i1.end-i2.end;
			}
		});
		for (int i = 0; i < intervals.size(); i++) {
			if(outputList.size()==0)
			{
				outputList.add(intervals.get(i));
			}
			else{
				Interval interval=outputList.get(outputList.size()-1);
				if(interval.end>=intervals.get(i).start)
				{
					interval=outputList.remove(outputList.size()-1);
					interval.end=Math.max(intervals.get(i).end,interval.end);
					outputList.add(interval);
				}
				else{
					outputList.add(intervals.get(i));
				}
			}
		}
		return outputList;
	}
}

