package GeeksforGeeksPractice;

import java.util.HashMap;

/*
 * Link : http://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
 */
public class _0066ArraySubset {

	public static void main(String[] args) {
		int arr1[] = {11, 1, 13, 21, 3, 7};
		int arr2[] = {11, 3, 7, 1};
		System.out.println(checkSubset(arr1,arr2));
		arr1 = new int[]{1, 2, 3, 4, 5, 6};
		arr2 = new int[]{1, 2, 4};
		System.out.println(checkSubset(arr1,arr2));
		arr1 = new int[]{10, 5, 2, 23, 19};
		arr2 = new int[]{19, 5, 3};
		System.out.println(checkSubset(arr1,arr2));
	}

	private static boolean checkSubset(int[] arr1, int[] arr2) {
		int count=0;
		HashMap<Integer,Integer> elementMap=new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			elementMap.put(arr1[i],1);
		}
		for (int i = 0; i < arr2.length; i++) {
			if(elementMap.containsKey(arr2[i]))
				count++;
		}
		return count==arr2.length;
	}

}
