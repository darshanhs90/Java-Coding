package hackerRank.WeekOfCode34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _03SameOccurence {
	static List<int[]> subsetArrayList;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] arr = new int[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		subsetArrayList = new ArrayList<>();
		populateSubsetArray(arr);
		for(int a0 = 0; a0 < q; a0++){
			int x = in.nextInt();
			int y = in.nextInt();
			int outputCount = 0;
			// Write Your Code Here
			for (int i = 0; i < subsetArrayList.size(); i++) {
				int[] subArray = subsetArrayList.get(i);
				int countA = 0,countB=0;
				for (int j = 0; j < subArray.length; j++) {
					if(subArray[j]==x)
						countA += 1;
					if(subArray[j]==y)
						countB += 1;
				}
				if(countA == countB){
					outputCount+=1;
				}
			}
			System.out.println(outputCount);
		}
		in.close();
	}

	private static void populateSubsetArray(int[] arr) {
		if(arr.length>0){
			for (int i = 1; i <=arr.length; i++) {
				subsetArrayList.add(Arrays.copyOfRange(arr, 0, i));
			}
			populateSubsetArray(Arrays.copyOfRange(arr, 1, arr.length));
		}
	}
}
