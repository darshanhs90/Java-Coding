package Warmup;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/*
 */	
public class _54googleCoaching {


	public static void main(String args[]){
		System.out.println(findCycle(new int[]{}));

	}

	public static boolean findCycle(int[] inputArray){
		HashMap<Integer,Integer> elementMap=new HashMap<Integer,Integer>();
		int N=inputArray.length;

		int currIndex=0,count=0;
				while(true){
					if(elementMap.containsKey(currIndex))
					{
						if(currIndex==0 && count==N)
							return true;
						else
							return false;
					}
					elementMap.put(currIndex,1);
					count+=1;
					currIndex=(currIndex+inputArray[currIndex])%N;
				}	
	}
	public static boolean findCycle2(int[] inputArray){
		int N=inputArray.length;
		boolean visited[]=new boolean[N];
		int currIndex=0,count=0;
		visited[0]=true;
		while(true){
			if(visited[currIndex]==true)
			{
				if(currIndex==0 && count==N)
					return true;
				else if(currIndex!=0)
					return false;
			}
			visited[currIndex]=true;
			count+=1;
			currIndex=(currIndex+inputArray[currIndex])%N;
		}	
	}

	public static boolean findCycle3(int[] inputArray){
		Set<Integer> elementMap=new TreeSet<Integer>();
		int N=inputArray.length;
		int currIndex=0,count=0;
		while(true){
			if(elementMap.contains(currIndex))
			{
				if(currIndex==0 && count==N)
					return true;
				else
					return false;
			}
			elementMap.add(currIndex);
			count+=1;
			currIndex=(currIndex+inputArray[currIndex])%N;
		}	
	}

}
