package appleInterview;

public class _DS_Stack_4ImplementTwoStacksArray {
	static int[] arr=new int[10];
	static int stackPointer1=-1;
	static int stackPointer2=arr.length;

	public static void main(String[] args) {
		push1(20);
		push1(21);
		push1(22);
		push1(23);
		push1(24);
		push1(25);
		push2(10);
		push2(11);
		push2(12);
		push2(13);
		System.out.println(pop2());
		push1(40);
		System.out.println(pop1());
	}
	private static int pop1() {
		if(stackPointer1>=0)
		{
			stackPointer1--;
		}
		return arr[stackPointer1+1];
	}
	private static int pop2() {
		if(stackPointer2<arr.length)
		{
			stackPointer2++;
		}
		return arr[stackPointer2-1];
	}
	private static void push2(int i) {
		if(stackPointer2-1>stackPointer1)
		{
			arr[stackPointer2-1]=i;
			stackPointer2--;
		}
	}
	private static void push1(int i) {
		if(stackPointer1+1<stackPointer2)
		{
			arr[stackPointer1+1]=i;
			stackPointer1++;
		}
	}





}
