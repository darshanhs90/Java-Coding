package hackerRank.WeekOfCode33;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _03TransformToPalindrome2 {
	static int maxLength=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int m=in.nextInt();
		TreeMap<Integer, TreeSet<Integer>> map=new TreeMap<>();
		for (int i = 0; i < k; i++) {
			int key=in.nextInt();
			int value=in.nextInt();
			if(map.containsKey(key)){
				TreeSet<Integer> list=map.get(key);
				list.add(value);
				map.put(key, list);
			}
			else{
				TreeSet<Integer> list=new TreeSet<>();
				list.add(value);
				map.put(key,list);
			}

			if(map.containsKey(value)){
				TreeSet<Integer> list=map.get(value);
				list.add(key);
				map.put(value, list);
			}
			else{
				TreeSet<Integer> list=new TreeSet<>();
				list.add(key);
				map.put(value,list);
			}
		}
		System.out.println(map);
		for(Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
			Integer key = entry.getKey();
			TreeSet<Integer> value = entry.getValue();
			value.addAll(getValues(new TreeSet<Integer>(),key,map));
		}

		System.out.println(map);
		int[] inputArray=new int[m];
		for (int i = 0; i < m; i++) {
			inputArray[i]=in.nextInt();
		}
		System.out.println(dfs(0,inputArray,map));
	}

	private static int dfs(int index, int[] inputArray, TreeMap<Integer, TreeSet<Integer>> map) {
		maxLength=Math.max(maxLength, longestPalindromicSubsequence(inputArray));
		if(maxLength==inputArray.length){
			System.out.println(maxLength);
			System.exit(0);
		}

		for (int i = index; i < inputArray.length; i++) {
			int key=inputArray[i];
			if(map.containsKey(key)){
				for (int j : map.get(key)) {
					inputArray[i]=j;
					maxLength=Math.max(maxLength, dfs(i+1, inputArray, map));
					inputArray[i]=key;
				}
			}
		}
		return maxLength;

	}

	private static TreeSet<Integer> getValues(TreeSet<Integer> visitedKeys, Integer key, TreeMap<Integer, TreeSet<Integer>> map) {
		TreeSet<Integer> set=new TreeSet<>();
		TreeSet<Integer> values=map.get(key);
		for (Integer integer : values) {
			if(integer!=key && !visitedKeys.contains(integer)){
				visitedKeys.add(key);
				set.addAll(map.get(key));
				set.addAll(getValues(visitedKeys,integer, map));
				visitedKeys.remove(key);
			}
		}
		set.remove(key);
		map.get(key).addAll(set);
		return set;
	}


	public static int longestPalindromicSubsequence(int[] inputArr)
	{
		int dp[][] = new int[inputArr.length][inputArr.length];

		for (int i = 0; i < inputArr.length; i++){
			dp[i][i] = 1;
		}

		for (int cl=2; cl<=inputArr.length; cl++)
		{
			for (int i=0; i<inputArr.length-cl+1; i++)
			{
				int j = i+cl-1;
				if (inputArr[i] == inputArr[j] && cl == 2)
					dp[i][j] = 2;
				else if (inputArr[i] == inputArr[j])
					dp[i][j] = dp[i+1][j-1] + 2;
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
			}
		}
		return dp[0][inputArr.length-1];
	}
}
