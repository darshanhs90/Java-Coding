package GeeksforGeeksPractice;

import java.util.HashMap;

/*
 * Link : http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 */
public class _0069ArrayElementDistanceCheck {

	public static void main(String[] args) {
		int k=3;
		int arr[] = {1, 2, 3, 4, 1, 2, 3, 4};
		System.out.println(findDuplicates(arr,k));
		arr=new int[]{1, 2, 3, 1, 4, 5};
		System.out.println(findDuplicates(arr,k));
		arr=new int[]{1, 2, 3, 4, 5};
		System.out.println(findDuplicates(arr,k));
		arr=new int[]{1, 2, 3, 4, 4};
		System.out.println(findDuplicates(arr,k));
	}

	private static boolean findDuplicates(int[] arr, int k) {
		HashMap<Integer, Integer> elementMap=new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int element=arr[i];
			if(elementMap.containsKey(element))
			{
				if(i-elementMap.get(element)>(k))
				{
					elementMap.put(element, i);
				}
				else{
					return true;
				}
			}
			else{
				elementMap.put(element, i);
			}
		}
		return false;
	}



}
