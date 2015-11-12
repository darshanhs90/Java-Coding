package Codility;


/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/perm_missing_elem
 */

public class _0002TCPermMissingElem {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2,3,1,5}));
	}

	public static int solution(int inputArray[])
	{
		int sum=0;
		for (int i = 0; i < inputArray.length; i++) {
			sum+=inputArray[i];
		}
		int size=inputArray.length+1;
		return ((size*(size+1))/2)-sum;
	}
}