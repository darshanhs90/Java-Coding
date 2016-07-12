package servicenowPrep;

import java.util.LinkedList;
import java.util.Queue;

public class _005ImplementStackUsingQueues {
	public static void main(String[] args) {
		MyStack m=new MyStack();
		m.push(1);
		m.push(2);
		m.push(3);
		System.out.println(m.pop());
	}

	static class MyStack{
		Queue<Integer> queue1=new LinkedList<>();
		Queue<Integer> queue2=new LinkedList<>();
		public void push(int x)
		{
			queue1.add(x);
		}
		public int pop()
		{
			while(!queue1.isEmpty())
			{
				queue2.add(queue1.remove());
			}
			int value=queue2.remove();
			while(!queue2.isEmpty())
			{
				queue1.add(queue2.remove());
			}
			return value;
		}
	}





}
