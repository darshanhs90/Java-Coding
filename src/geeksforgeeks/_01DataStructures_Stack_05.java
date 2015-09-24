package geeksforgeeks;

import java.util.Arrays;




/*
 * http://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 * Implement two stacks in an array
 */;
 public class _01DataStructures_Stack_05 {	 
	 public static void main(String[] args) {
		 MainStack mainStack=new MainStack();
		 System.out.println(mainStack.push1(10));
		 System.out.println(mainStack.push1(20));
		 System.out.println(mainStack.push1(30));
		 System.out.println(mainStack.push1(40));
		 System.out.println(mainStack.push1(50));
		 System.out.println(mainStack.push1(60));
		 System.out.println(mainStack.stack1String());
		 System.out.println(mainStack.pop1());
		 System.out.println(mainStack.push2(10));
		 System.out.println(mainStack.push2(20));
		 System.out.println(mainStack.push2(30));
		 System.out.println(mainStack.push2(40));
		 System.out.println(mainStack.push2(50));
		 System.out.println(mainStack.push2(60));
		 System.out.println(mainStack.stack2String());
		 System.out.println(mainStack.pop2());
		 System.out.println(mainStack.pop2());
		 System.out.println(mainStack.pop2());
		 System.out.println(mainStack.pop2());
		 System.out.println(mainStack.pop2());
		 System.out.println(mainStack.pop2());

	 }


 }
 class MainStack{
	 int stackArray[]=new int[10];
	 int stack1Start=0,stack1End=4,stack2Start=5,stack2End=9;
	 int stack1Pointer=0,stack2Pointer=5;
	 public boolean push1(int value){
		 if(stack1Pointer>stack1End || stack1Pointer<stack1Start)
			 return false;
		 stackArray[stack1Pointer]=value;
		 stack1Pointer++;
		 return true;
	 }
	 public boolean push2(int value){
		 if(stack2Pointer>stack2End || stack2Pointer<stack2Start)
			 return false;
		 stackArray[stack2Pointer]=value;
		 stack2Pointer++;
		 return true;
	 }
	 public int pop1(){
		 if(stack1Pointer>stack1End)
			 stack1Pointer=stack1End;
		 if(stack1Pointer-1<stack1Start)
			 return Integer.MIN_VALUE;
		 stack1Pointer=stack1Pointer-1;
		 return stackArray[stack1Pointer+1];
	 }
	 public int pop2(){
		 if(stack2Pointer>stack2End)
			 stack2Pointer=stack2End;
		 if(stack2Pointer<stack2Start)
			 return Integer.MIN_VALUE;
		 stack2Pointer=stack2Pointer-1;
		 return stackArray[stack2Pointer+1];
	 }
	 public String stack1String(){
		 return Arrays.toString(Arrays.copyOfRange(stackArray, stack1Start,stack1End+1));
	 }
	 public String stack2String(){
		 return Arrays.toString(Arrays.copyOfRange(stackArray, stack2Start,stack2End+1));
	 }
 }
