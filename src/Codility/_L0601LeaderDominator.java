package Codility;

import java.util.HashMap;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/dominator
 */

public class _L0601LeaderDominator {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,4,3,2,3,-1,3,3}));
	}
	public static int solution(int[] A)
	{
		HashMap<Integer, Integer> elementMap=new HashMap<>();
		elementMap.put(A[0], 1);
		int max=1;
		for (int i = 1; i < A.length; i++) {
			int element=A[i];
			if(elementMap.containsKey(element))
			{
				elementMap.put(element,elementMap.get(element)+1);
				if(elementMap.get(element)>max)
				{
					max=elementMap.get(element);
				}
			}
			else{
				elementMap.put(element,1);
			}
		}
		return max>A.length/2?max:-1;
	}
}