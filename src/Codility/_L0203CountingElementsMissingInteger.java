package Codility;

import java.util.HashMap;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/missing_integer
 */

public class _L0203CountingElementsMissingInteger {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,3,6,4,1,2},6));
	}

	public static int solution(int[] inputArray,int N)
	{	
		HashMap<Integer, Integer> elementMap=new HashMap<>();
		for (int i = 0; i < inputArray.length; i++) {
			elementMap.put(inputArray[i],1);
		}
		for (int i = 1; i <=N; i++) {
			if(!elementMap.containsKey(i))
				return i;
		}
		return -1;
	}
}