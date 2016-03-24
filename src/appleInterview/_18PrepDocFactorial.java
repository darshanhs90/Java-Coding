package appleInterview;

public class _18PrepDocFactorial {
	public static void main(String[] args) {
		System.out.println(findFactorial(10));;
		System.out.println(findRecursiveFactorial(10));

	}

	private static int findRecursiveFactorial(int i) {
		int output=1;
		for (int j = 1; j <=i; j++) {
			output*=j;
		}
		return output;
	}

	private static int findFactorial(int i) {
		if(i<=1)
			return 1;
		else
			return i*findFactorial(i-1);
	}


}
