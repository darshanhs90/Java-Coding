package LeetCodePractice;

public class _204CountPrimes {

	public static void main(String[] args) {
		System.out.println(countPrimes(35));
	}
	static boolean primeMat[];
	public static int countPrimes(int n) {
		primeMat=new boolean[n];
		int count=0;
		for (int i = 2; i < primeMat.length; i++) {
			if(!primeMat[i])
			{
				if(isPrime(i))
				{
					count++;
				}
				else{
					primeMat[i]=false;
				}
				handleValues(i);
			}
		}
		return count;
	}
	private static void handleValues(int i) {
		int value=2;
		int product=i*value;
		while(product<primeMat.length)
		{
			primeMat[product]=true;
			value++;
			product=i*value;
		}
	}
	private static boolean isPrime(int num) {
		if (num <= 1) return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}

