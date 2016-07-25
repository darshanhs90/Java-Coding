package eBayPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class _057InsertInterval {

	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public static void main(String[] args) {
		List<Interval> aList=new ArrayList<>();
		aList.add(new Interval(1,2));
		aList.add(new Interval(3,5));
		aList.add(new Interval(6,7));
		aList.add(new Interval(8,10));
		aList.add(new Interval(12,16));
		
		aList=insert(aList, new Interval(4,9));
		for (int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i).start+"///"+aList.get(i).end);
		}
	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		Stack<Interval> stack=new Stack<>();
		List<Interval> outputList=new ArrayList<>();
		intervals.add(newInterval);
		Collections.sort(intervals,new Comparator<Interval>() {

			@Override
			public int compare(Interval a, Interval b) {
				if(a.start!=b.start)
					return a.start-b.start;
				else
					return a.end-b.end;
			}
		});


		for (int i = 0; i < intervals.size(); i++) {
			Interval currInterval=intervals.get(i);
			if(stack.isEmpty())
			{
				stack.push(currInterval);
			}
			else{
				if(currInterval.start>stack.peek().end)
				{
					stack.push(currInterval);
				}
				else{
					Interval poppedInterval=stack.pop();
					poppedInterval.end=Math.max(poppedInterval.end, currInterval.end);
					stack.push(poppedInterval);
				}
			}		
		}

		while(!stack.isEmpty())
		{
			outputList.add(stack.pop());
		}
		Collections.reverse(outputList);
		return outputList;	
		
	}
}

