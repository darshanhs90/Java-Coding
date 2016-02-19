package hackerRank.Algorithms.Search;

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/pairs
 */
public class _08Pairs {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		HashSet<Integer> set=new HashSet<>();
		int inputArray[]=new int[n];
		for (int i = 0; i < n; i++) {
			inputArray[i]=scanner.nextInt();
			set.add(inputArray[i]);
		}
		int count=0;
		for (int i = 0; i < inputArray.length; i++) {
			if(set.contains(inputArray[i]-k))
				count++;
			if(set.contains(inputArray[i]+k))
				count++;
		}
		System.out.println(count/2);
	}
}