package appleInterview;

public class _05PrepDocListAllPrimesPreceding {
	public static void main(String[] args) {
		listPrimes(20);
	}

	private static void listPrimes(int i) {
		for (int j = 2; j < i; j++) {
			if(isPrime(j))
				System.out.println(j);
		}
	}

	private static boolean isPrime(int j) {
		if(j<2)return false;
		if(j==2)return true;
		if(j%2==0)return false;
		for (int i = 3; i*i <= j; i++) {
			if (j % i == 0) {
				return false;
			}
		}
		return true;
	}

}
