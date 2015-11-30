package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link: http://www.geeksforgeeks.org/ugly-numbers/
 */
public class _0129UglyNosAlgoDP {
	public static void main(String[] args) {
		System.out.println(findUglyNumber(150));
	}

	private static int findUglyNumber(int number)
	{
		int[] ugly=new int[number];
		ugly[0]=1;
		int i2=0,i3=0,i5=0;
		int next_multiple2=ugly[i2]*2,next_multiple3=ugly[i3]*3,next_multiple5=ugly[i5]*5;
		
		for (int i = 1; i < number; i++) {
			int nextUglyNumber=Math.min(next_multiple2, Math.min(next_multiple3, next_multiple5));
			ugly[i]=nextUglyNumber;
			if(nextUglyNumber==next_multiple2)
			{
				i2++;
				next_multiple2=ugly[i2]*2;
			}
			if(nextUglyNumber==next_multiple3)
			{
				i3++;
				next_multiple3=ugly[i3]*3;
			}
			if(nextUglyNumber==next_multiple5)
			{
				i5++;
				next_multiple5=ugly[i5]*5;
			}	
		}
		System.out.println(Arrays.toString(ugly));
		
		return ugly[number-1];
	}



}
