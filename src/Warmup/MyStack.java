package Warmup;

public class MyStack {
	private int maxSize;
	private int[] stackArray;
	private int top;
	public MyStack(int s) {
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}
	
	
	public void push(int j) throws ArrayIndexOutOfBoundsException{
		if(top+1>=maxSize){
			throw new ArrayIndexOutOfBoundsException("Error pushing " + j);
		}

		stackArray[top+1] = j;
		top++;
	}
	public int pop() throws ArrayIndexOutOfBoundsException{
		top=top-1;
		return stackArray[top];
	}
	public int peek() {
		return stackArray[top];
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	public boolean isFull() {
		return (top == maxSize - 1);
	}
	public static void main(String[] args) {
		MyStack theStack = new MyStack(3); 
		try{

			theStack.push(10);
			theStack.push(20);
			theStack.push(30);
			theStack.push(40);
			theStack.push(50);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				while (!theStack.isEmpty()) {
					int value = theStack.pop();
					System.out.print(value);
					System.out.print(" ");
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Pop Error");
			}
		}

	}
}





