package Codility;

import java.util.HashMap;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/perm_check
 */

public class _L0202CountingElementsPermCheck {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{4,1,3},4));
	}

	public static int solution(int[] inputArray,int N)
	{	
		HashMap<Integer,Integer> elementMap=new HashMap<>();
		int elementCount=0;
		for (int i = 0; i < inputArray.length; i++) {
			int element=inputArray[i];
			if(element<=N){
				if(elementMap.containsKey(element))
				{
					return 0;
				}
				else{
					elementMap.put(element, 1);
					elementCount++;
				}
			}
		}
		return elementCount==N?1:0;
	}
}