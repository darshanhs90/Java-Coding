package yelpInterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _Array10UnionIntersection {
	public static void main(String a[]){
		int arr1[] = new int[]{1, 3, 4, 5, 7};
		int arr2[] = new int[]{2, 3, 5, 6};
		System.out.println(Arrays.toString(union(arr1,arr2)));
		System.out.println(Arrays.toString(intersection(arr1,arr2)));	
	}

	private static int[] intersection(int[] arr1, int[] arr2) {
		Set<Integer> set=new HashSet<>();
		int length=arr1.length>arr2.length?arr1.length:arr2.length;
		for (int i = 0; i < length; i++) {
			if(i<arr1.length)
				set.add(arr1[i]);
			if(i<arr2.length)
				set.add(arr2[i]);
		}
		Iterator<Integer> itr=set.iterator();
		arr1=new int[set.size()];
		int counter=0;
		while(itr.hasNext())
		{
			arr1[counter]=itr.next();
			counter++;
		}
		return arr1;
	}

	private static int[] union(int[] arr1, int[] arr2) {
		Set<Integer> set=new HashSet<>();
		Set<Integer> outputSet=new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			if(set.contains(arr2[i]))
				outputSet.add(arr2[i]);
		}
		Iterator<Integer> itr=outputSet.iterator();
		arr1=new int[outputSet.size()];
		int counter=0;
		while(itr.hasNext())
		{
			arr1[counter]=itr.next();
			counter++;
		}
		return arr1;
	}




}