package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/ugly-numbers/
 */
public class _0094UglyNumbers {
	public static void main(String[] args) {
		System.out.println(findUglyNumberNaive(10));
	}

	private static int findUglyNumberNaive(int i) {
		int count=1;
		int number=1;
		if(i==1)
			return 1;
		else
		{
			while(count<i)
			{
				number++;
				if(findUgly(number))
					count++;
				
			}
		}
		return number;
	}

	private static boolean findUgly(int number) {
		number=maxDivide(number,2);
		number=maxDivide(number,3);
		number=maxDivide(number,5);
		return number==1;
	}

	private static int maxDivide(int number, int i) {
		while(number%i==0)
			number=number/i;
		return number;
	}



}
