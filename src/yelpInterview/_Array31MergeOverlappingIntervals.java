package yelpInterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class _Array31MergeOverlappingIntervals {
	static class Interval{
		int start;
		int end;
		public Interval(int s,int e) {
			this.start=s;
			this.end=e;
		}
	}
	static Stack<Interval> stack=new Stack<>();
	public static void main(String a[]){
		Interval inputArray[]={ new Interval(2,6), new Interval(1,3),new Interval(15,18),new Interval(8,10) };
		findOverLappingInterval(inputArray);
	}
	private static void findOverLappingInterval(Interval[] inputArray) {
		System.out.println(Arrays.toString(inputArray));
		Arrays.sort(inputArray,new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start>o2.start?1:-1;
			}
		});
		stack=new Stack<>();
		stack.push(inputArray[0]);
		for (int i = 1; i < inputArray.length; i++) {
			Interval top=stack.peek();
			Interval interval=inputArray[i];
			if(interval.start>=top.start && interval.end<=top.end)
			{
				//do nothing
			}
			else if(interval.start>top.end){
				stack.push(interval);
			}
			else{
				Interval st=stack.pop();
				st.end=Math.max(st.end, interval.end);
				stack.push(st);
			}
		}
		while(!stack.isEmpty())
		{
			Interval interval=stack.pop();
			System.out.println(interval.start+"/"+interval.end);
		}
	}



}