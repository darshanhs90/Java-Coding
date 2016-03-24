package appleInterview;

public class _19PrepDocFibonacci {
	public static void main(String[] args) {
		System.out.println(findFibonacci(10));;
		System.out.println(findRecursiveFibonacci(10));

	}

	private static int findRecursiveFibonacci(int i) {
		if(i<2)
			return 1;
		else
			return findRecursiveFibonacci(i-1)+findRecursiveFibonacci(i-2);
	}

	private static  int findFibonacci(int i) {
		if(i<2)
			return 1;
		int fib0=1,fib1=1;
		for (int j = 2; j <=i; j++) {
			int sum=fib0+fib1;
			fib0=fib1;
			fib1=sum;
		}
		return fib1;
	}




}
