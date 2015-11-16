package Codility;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/count_non_divisible
 */

public class _L0902SieveOfEratosthenesCountNonDivisible {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(longSolution(new int[]{3,1,2,3,6})));
	}
	public static int[] longSolution(int[] A){
		int outputArr[]=new int[A.length];
		outputArr=Arrays.copyOfRange(A,0, A.length);
		Arrays.sort(outputArr);
		int []occurenceList=new int[outputArr[outputArr.length-1]+1];
		//populate occurences of each element
		for (int i = 0; i < A.length; i++) {
			occurenceList[A[i]]+=1;
		}
		for (int i = 0; i < A.length; i++) {
			int number=A[i],divCount=0;
			int j=1;
			for (j = 1; j*j<number; j++) {
				if(number%j==0)
				{
					divCount+=occurenceList[j];
					divCount+=occurenceList[number/j];	
				}
			}
			if(j*j==number)
			{
				divCount+=occurenceList[j];
			}
			outputArr[i]=A.length-divCount;
		}		
		return outputArr;
	}



}