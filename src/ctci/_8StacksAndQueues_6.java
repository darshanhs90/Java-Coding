package ctci;

import java.util.Stack;





/*Implementation of CTCI 3.6*/
public class _8StacksAndQueues_6{
	private static Stack<Integer> mainStack;
	private static Stack<Integer> tempStack;

	public static void main(String[] args) {
		mainStack=new Stack<Integer>();
		addToStack(10);
		addToStack(5);
		addToStack(11);
		addToStack(6);
		addToStack(12);
		addToStack(7);
		addToStack(13);
		addToStack(8);
		addToStack(14);
		addToStack(9);
	}

	private static void addToStack(int value) {
		System.out.println("Adding Value : "+value);
		if(mainStack.size()==0)
			mainStack.push(value);
		else{
			makeStackSorted(value);
		}
		System.out.println("******************");
		System.out.println(mainStack.toString());
		System.out.println("******************");
	}

	private static void makeStackSorted(int value) {
		int poppedValue=0;
		int lowCounter=0;
		tempStack=new Stack<Integer>();
		while(mainStack.size()!=0)
		{
			poppedValue=mainStack.pop();
			if(poppedValue<value && lowCounter==0){
				tempStack.push(value);
				lowCounter=1;
			}
			tempStack.push(poppedValue);
		}
		if(lowCounter==0)
			tempStack.push(value);
		mainStack=new Stack<Integer>();
		while(tempStack.size()!=0)
		{
			mainStack.push(tempStack.pop());
		}
	}


}
