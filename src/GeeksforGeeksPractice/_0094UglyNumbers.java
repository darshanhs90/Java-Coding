package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/ugly-numbers/
 */
public class _0094UglyNumbers {
	public static void main(String[] args) {
		System.out.println(findUglyNumberNaive(150));
		System.out.println(findUglyNumberDP(150));
		
	}

	private static int findUglyNumberDP(int N) {
		int[] ugly=new int[N];
		ugly[0]=1;
		int i2=0,i3=0,i5=0;
		int nextm2=ugly[i2]*2;
		int nextm3=ugly[i3]*3;
		int nextm5=ugly[i5]*5;
		int nextUglyNo=0;
		for (int i = 1; i < N; i++) {
			nextUglyNo=Math.min(nextm2, Math.min(nextm3, nextm5));
			ugly[i]=nextUglyNo;	
			if(nextUglyNo==nextm2)
			{
				i2++;
				nextm2=ugly[i2]*2;
			}
			if(nextUglyNo==nextm3)
			{
				i3++;
				nextm3=ugly[i3]*3;
			}
			if(nextUglyNo==nextm5)
			{
				i5++;
				nextm5=ugly[i5]*5;
			}
			
		}
		return nextUglyNo;
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
