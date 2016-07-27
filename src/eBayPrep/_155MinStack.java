package eBayPrep;

public class _155MinStack {
	int[] stack;
	int[] minStack;
	int pointer=-1;
	public void push(int x) {
		if(stack==null||pointer==-1)
		{
			pointer++;
			stack=new int[10000];
			minStack=new int[10000];
			stack[pointer]=x;
			minStack[pointer]=x;
		}
		else{
			pointer++;
			stack[pointer]=x;
			minStack[pointer]=Math.min(minStack[pointer-1],x);
		}
	}

	public void pop() {
		pointer--;
	}

	public int top() {
		return stack[pointer];
	}

	public int getMin() {
		return minStack[pointer];
	}
	public static void main(String[] args) {
		_155MinStack a=new _155MinStack();
		a.push(-2);
		System.out.println(a.getMin());
		a.push(0);
		System.out.println(a.getMin());
		a.push(-3);
		System.out.println(a.getMin());
	}
}

