package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*Problem Statement

Given N integers, count the number of pairs of integers whose difference is K.

Input Format

Input Format 
The first line contains N and K. 
The second line contains N numbers of the set. All the N numbers are unique.

Output Format

Output Format 
An integer that tells the number of pairs of integers whose difference is K.

Constraints: 
N≤105 
0<K<109 
Each integer will be greater than 0 and at least K smaller than 231−1.

Sample Input

Sample Input #00:

5 2  
1 5 3 4 2  
Sample Output

Sample Output #00:

3
Explanation

There are 3 pairs of integers in the set with a difference of 2.*/

public class _41sabreChallenge {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String firstLine=(scanner.readLine());
		String firstLineArray[]=firstLine.split(" ");
		Long N=Long.parseLong(firstLineArray[0]);
		Long K=Long.parseLong(firstLineArray[1]);
		String secondLineArray[]=scanner.readLine().split(" ");
		ArrayList<Long> arrayVals=new ArrayList<Long>();
		for (int i = 0; i < secondLineArray.length; i++) {
			arrayVals.add(Long.parseLong(secondLineArray[i]));
		}
		Object arr[]=arrayVals.toArray();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
