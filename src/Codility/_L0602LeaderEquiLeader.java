package Codility;

import java.util.HashMap;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/equi_leader
 */

public class _L0602LeaderEquiLeader {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{4,3,4,4,4,2}));
	}
	public static int solution(int[] A){
		HashMap<Integer, Integer> elementMap=new HashMap<>();
		elementMap.put(A[0], 1);
		int max=1,leaderElement=A[0];
		for (int i = 1; i < A.length; i++) {
			int element=A[i];
			if(elementMap.containsKey(element))
			{
				elementMap.put(element,elementMap.get(element)+1);
				if(elementMap.get(element)>max)
				{
					max=elementMap.get(element);
					leaderElement=element;
				}
			}
			else{
				elementMap.put(element,1);
			}
		}
		int totalLeaders=0;
		for (int i = 0; i < A.length; i++) {
			if(A[i]==leaderElement)
			{
				totalLeaders++;
			}
		}
		if(totalLeaders<=A.length/2)
			return 0;
		
		int finalLeaderCount=0,equiLeaders=0;
		for (int i = 0; i < A.length; i++) {
			if(A[i] == leaderElement) 
				finalLeaderCount++;
		    int leadersInRightPart = (totalLeaders - finalLeaderCount);
		    if(finalLeaderCount > (i+1)/2   &&   leadersInRightPart > (A.length-i-1)/2){
		      equiLeaders++;
		    }
		}
		return equiLeaders;
	}
}