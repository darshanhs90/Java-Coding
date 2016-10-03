package hackerRank.CrackingTheCodingInterview;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _08RunningMedian {
	static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> minHeap=new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
			System.out.println(findRunningMedian(a[a_i]));	
		}
	}
	private static double findRunningMedian(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if(minHeap.size()>maxHeap.size())
			maxHeap.offer(minHeap.poll());
		if(maxHeap.size()==minHeap.size())
		{
			int num1=maxHeap.peek();
			int num2=minHeap.peek();
			return ((num1+num2)/(double)2);
		}
		else{
			int num1=maxHeap.peek();
			return ((num1)/1);
		}
	}
}
