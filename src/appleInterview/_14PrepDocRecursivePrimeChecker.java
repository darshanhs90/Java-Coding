package appleInterview;

public class _14PrepDocRecursivePrimeChecker {
	public static void main(String[] args) {
		System.out.println(findPrime(23));
		System.out.println(findPrime(5));
	}

	private static boolean findPrime(int i) {
		return checkPrime(i,(int)Math.ceil(i/2));
	}

	private static boolean checkPrime(int n, int i) {
		if(i<2)
			return true;
		else
		{
			return checkPrime(n, i-1) && n%i!=0;
		}
	}

}
