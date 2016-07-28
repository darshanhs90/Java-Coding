package eBayPrep;

public class _204CountPrimes {

	public static void main(String[] args) {
		System.out.println(countPrimes(2));
	}
	static boolean multiple[];
	private static int countPrimes(int n) {
		multiple=new boolean[n];
		int count=0;
		for (int i = 2; i <multiple.length; i++) {
			if(!multiple[i])
			{
				if(isPrime(i)==true)
					count++;
			}
			appendToMatrix(i);
		}
		return count;
	}

	private static void appendToMatrix(int number) {
		int count=1;
		while(count*number<multiple.length)
		{
			multiple[count*number]=true;
			count++;
		}
	}

	public static boolean isPrime(int number)
	{
		if(number<=1)
			return false;
		for (int i = 2; i*i < number; i++) {
			if(number%i==0)
				return false;
		}
		return true;
	}
}

