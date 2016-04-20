package yelpInterview;

import java.util.LinkedList;
import java.util.Queue;

public class _Stack05StackUsingQueues {
	static Queue<Integer> q1=new LinkedList<>();
	static Queue<Integer> q2=new LinkedList<>();

	public static void main(String a[]){
		push(10);
		push(20);
		push(30);
		push(40);
		System.out.println(pop());
		push(30);
		push(40);
		System.out.println(pop());
	}

	private static int pop() {
		for (int i = 0; i < q1.size(); i++) {
			q2.add(q1.remove());
		}
		int element=q2.remove();
		for (int i = 0; i < q2.size(); i++) {
			q1.add(q2.remove());
		}
		return element;
	}

	private static void push(int i) {
		q1.add(i);
	}



}

