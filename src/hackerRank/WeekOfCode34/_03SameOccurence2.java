package hackerRank.WeekOfCode34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _03SameOccurence2 {
	static List<int[]> subsetArrayList;
	static HashMap<Integer, HashMap<Integer, Integer>> map;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] arr = new int[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		map=new HashMap<Integer,HashMap<Integer,Integer>>();
		subsetArrayList = new ArrayList<>();
		populateSubsetArray(arr);
		for(int a0 = 0; a0 < q; a0++){
			int x = in.nextInt();
			int y = in.nextInt();
			int outputCount = 0;
			// Write Your Code Here
			for (int i = 0; i < subsetArrayList.size(); i++) {
				int countA = 0,countB=0;
				HashMap<Integer, Integer> tempMap = map.get(i);
				countA = tempMap.containsKey(x)?tempMap.get(x):0;
				countB = tempMap.containsKey(y)?tempMap.get(y):0;
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
				HashMap<Integer, Integer> tempMap=new HashMap<Integer,Integer>();
				int[] newArray = new int[i];
				for (int j = 0; j < i; j++) {
					int num=arr[j];
					newArray[j]=num;
					if(tempMap.containsKey(num)){
						tempMap.put(num, tempMap.get(num)+1);
					}
					else{
						tempMap.put(num,1);
					}
				}
				map.put(subsetArrayList.size(), tempMap);
				subsetArrayList.add(newArray);
			}
			populateSubsetArray(Arrays.copyOfRange(arr, 1, arr.length));
		}
	}
}
