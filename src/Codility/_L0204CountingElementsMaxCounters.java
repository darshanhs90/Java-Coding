package Codility;

import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/max_counters
 */

public class _L0204CountingElementsMaxCounters {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5,new int[]{3,4,4,6,1,4,4})));
	}

	public static int[] solution(int N, int[] A)
	{	
		int outputArray[][]=new int[A.length][N];
		for (int i = 0; i < A.length; i++) {
			int element=A[i];
			if(i!=0){
				if(element>=N)
				{
					Arrays.fill(outputArray[i],findMax(outputArray[i-1]));
				}
				else{
					outputArray[i]=Arrays.copyOf(outputArray[i-1],outputArray[0].length);
					outputArray[i][element-1]=outputArray[i-1][element-1]+1;
				}
			}
			else{
				outputArray[i][element-1]=1;
			}

		}
		return outputArray[outputArray.length-1];
	}

	private static int findMax(int[] is) {
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < is.length; i++) {
			if(is[i]>max)
			{
				max=is[i];
			}
		}
		System.out.println(max);
		return max;
	}
}