package geeksforgeeks;

import java.util.Arrays;
import java.util.HashMap;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-13-2/
 * Find the first subarray which has a zero sum in an array
 */;
 public class _01AmazonInterview_14_07 {
	 public static void main(String[] args) {
			int inputArray[]= {4, 2, -3, 1, 6};
			System.out.println(Arrays.toString(inputArray));
			System.out.println("Zero sum array : "+findZeroSum(inputArray));
			int[] inputArray1={4, 2, 0, 1, 6};
			System.out.println(Arrays.toString(inputArray1));
			System.out.println("Zero sum array : "+findZeroSum(inputArray1));
			int[] inputArray2= {-3, 2, 3, 1, 6};
			System.out.println(Arrays.toString(inputArray2));
			System.out.println("Zero sum array : "+findZeroSum(inputArray2));
		}

	private static boolean findZeroSum(int[] inputArray) {
		HashMap<Integer,Integer> sumMap=new HashMap<Integer, Integer>();
		int sum=0;
		for (int i = 0; i < inputArray.length; i++) {
			sum+=inputArray[i];
			if(sumMap.containsKey(sum)||sum==0){
				return true;
			}
			sumMap.put(sum,sum);
		}
		return false;
	}
 }