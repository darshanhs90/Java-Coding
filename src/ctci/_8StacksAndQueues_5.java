package ctci;

import java.util.EmptyStackException;
import java.util.Queue;
import java.util.Stack;




/*Implementation of CTCI 3.5*/
public class _8StacksAndQueues_5{
	public static void main(String[] args) {
		MyQueue myQueue=new MyQueue();
		myQueue.add(10);
		myQueue.add(20);
		myQueue.add(30);
		myQueue.add(40);
		myQueue.add(50);
		myQueue.add(60);
		myQueue.add(70);
		myQueue.add(80);
		myQueue.add(90);
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		myQueue.add(120);
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());		
	}
}
class MyQueue{
	Stack<Integer> stack1,stack2;
	public MyQueue() {
		stack1=new Stack<Integer>();
		stack2=new Stack<Integer>();
	}
	public void add(int value){
		stack1.push(value);
	}
	public int remove() throws EmptyStackException{
		if(stack2.size()==0)
		{
			moveBetweenStacks();
		}
		return stack2.pop();
	}
	private void moveBetweenStacks() {
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
	}
}
