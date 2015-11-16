package Codility;

import java.util.HashMap;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/abs_distinct
 */

public class _L1301CaterpillarMethodAbsDistinct {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{-5,-3,-1,0,3,6}));
	}
	public static int solution(int[] A)
	{
		int count=0;
		HashMap<Integer, Integer> elementMap=new HashMap<Integer,Integer>();
		for (int i = 0; i < A.length; i++) {
			int element=A[i]>=0?A[i]:-A[i];
			if(!elementMap.containsKey(element))
			{
				elementMap.put(element,1);
				count++;
			}
		}
		return count;
	}

}