package yelpInterview;

public class _Stack03ImplementTwoStackedArray {
	static int pointer1=-1;
	static int pointer2=-1;
	static int arr[];
	public static void main(String a[]){
		arr=new int[10];
		pointer2=arr.length;
		push1(1);
		push1(2);
		push1(3);
		push1(4);
		push1(5);
		push1(6);
		push2(7);
		push2(8);
		push2(9);
		push2(10);
		push2(11);
		System.out.println(pop1());
		System.out.println(pop2());
		push1(12);
		push2(13);
	}

	private static int pop1() {
		if(pointer1>=0){
			pointer1--;
			return arr[pointer1+1];
		}
		return -1;
	}

	private static int pop2() {
		if(pointer2<arr.length){
			pointer2++;
			return arr[pointer2-1];
		}
		return -1;
	}

	private static void push1(int i) {
		if(pointer1+1<pointer2){
			arr[pointer1+1]=i;
			pointer1++;
		}

	}

	private static void push2(int i) {
		if(pointer1<pointer2-1){
			arr[pointer2-1]=i;
			pointer2--;
		}
	}





}

