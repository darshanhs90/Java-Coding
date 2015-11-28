package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 */
public class _0096FibonacciDP {
	public static void main(String[] args) {
		System.out.println(fibonacci(9));
	}

	private static int fibonacci(int i) {
		int fibo[]=new int[i];
		fibo[0]=0;
		fibo[1]=1;
		for (int j = 2; j <i; j++) {
			fibo[j]=fibo[j-1]+fibo[j-2];
		}
		return fibo[i-1];
	}



}
