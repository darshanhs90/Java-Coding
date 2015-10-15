package leetCode;


/*
 * Link : https://leetcode.com/problems/count-primes/
 */
public class _204CountPrimes {
	public static int countPrimesLong(int n) {
		int primeCount=0;
		for (int i = 2; i <=n; i++) {
			boolean divided=true;
			for (int j = 2; j < i; j++) {
				if(i%j==0)
					divided=false;
			}
			if(divided)
				primeCount++;
		}
		return primeCount;
	}
	public static int countPrimesShort(int n) {
		int primeCount=0;
		for (int i = 2; i <=n; i++) {
			boolean divided=true;
			for (int j = 2; j <=i/2; j++) {
				if(i%j==0)
					divided=false;
			}
			if(divided)
				primeCount++;
		}
		return primeCount;
	}
	public static int countPrimesShortTwo(int n) {
		int primeCount=0;
		for (int i = 2; i <=n; i++) {
			boolean divided=true;
			for (int j = 2; j <=Math.sqrt(i); j++) {
				if(i%j==0)
					divided=false;
			}
			if(divided)
				primeCount++;
		}
		return primeCount;
	}
	public static int countPrimes(int n) {
		boolean[] isPrime=new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i]=true;
		}

		for (int i = 2; i < n; i++) {
			if(!isPrime[i])
				continue;
			else
				for (int j = i+i; j < n; j+=i) {
					isPrime[j]=false;
				}
		}
		int count=0;
		for (int i = 2; i < n; i++) {
			if(isPrime[i])
				count++;
		}
		return count;
	}


	public static void main(String[] args) {
		System.out.println(countPrimesLong(499));
		System.out.println(countPrimesShort(499));
		System.out.println(countPrimesShortTwo(499));
		System.out.println(countPrimes(499));

	}
}