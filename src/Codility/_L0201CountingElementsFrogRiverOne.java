package Codility;

import java.util.HashMap;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/frog_river_one
 */

public class _L0201CountingElementsFrogRiverOne {

	public static void main(String[] args) {
		System.out.println(solution(5,new int[]{1,3,1,4,2,3,5,4}));
	}

	public static int solution(int X, int[] inputArray)
	{	
		HashMap<Integer,Integer> elementMap=new HashMap<Integer,Integer>();
		int elementCount=0;
		for (int i = 0; i < inputArray.length; i++) {
			int element=inputArray[i];
			if(element>=1 && element<=X)
			{
				if(!elementMap.containsKey(element)){
					elementMap.put(element, element);
					elementCount++;
				}
				
				if(elementCount==X)
					return i;
			}
		}
		return -1;
	}
}