package appleInterview;

import java.util.LinkedList;
import java.util.Queue;

public class _DS_Stack_8StackUsingQueues {
	static Queue<Integer> q1=new LinkedList<>();
	static Queue<Integer> q2=new LinkedList<>();
	public static void main(String[] args) {
		q1=new LinkedList<>();
		q2=new LinkedList<>();
		addtoStack(10);
		addtoStack(20);
		addtoStack(30);
		System.out.println(removefromStack());
		addtoStack(50);
		addtoStack(60);
		System.out.println(removefromStack());
	}
	static void addtoStack(int element){
		q1.add(element);
	}
	static int removefromStack(){
		while(q1.size()>1)
		{
			q2.add(q1.remove());
		}
		while(q2.size()>0)
		{
			q1.add(q2.remove());
		}
		return 	q1.remove();
	}
}
