package eBayPrep;

import java.util.LinkedList;

public class _225ImplementStackUsingQueues{

	LinkedList<Integer> q1;//,q2;
	public _225ImplementStackUsingQueues() {
		q1=new LinkedList<>();
		//q2=new LinkedList<>();
	}
	public void push(int x) {
		q1.addLast(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		q1.removeLast();
	}

	// Get the top element.
	public int top() {
		return q1.peekLast();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.size()==0;
	}

	public static void main(String[] args) {
		_225ImplementStackUsingQueues m=new _225ImplementStackUsingQueues();
		m.push(1);
		m.push(2);
		System.out.println(m.top());
	}
}

