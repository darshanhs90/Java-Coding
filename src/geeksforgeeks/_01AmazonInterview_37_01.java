package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-37/
 * Given an array of n numbers with repetition of numbers.
 * You need to find the max length of continuous sub array with at max 3 unique elements.
 * For eg
 * array: 1 2 3 1 4 3 4 1 2
 * ans: 6 (3 1 4 3 4 1)
 */;
 public class _01AmazonInterview_37_01 {
	 public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		scanner.close();
		int inputArray[]={1,2,3,1,4,3,4,1,2};
		System.out.println(findMAxLength(inputArray));
	 }

	private static int findMAxLength(int[] inputArray) {
		StringBuffer sb=new StringBuffer();
		int length=3;
		int maxLength=3;
		sb.append(inputArray[0]+""+inputArray[1]+""+inputArray[2]);
		for (int i = 3; i < inputArray.length; i++) {
			if(sb.toString().contains(inputArray[i]+"")){
				sb.deleteCharAt(sb.indexOf(inputArray[i]+""));
				length++;
				sb.append(inputArray[i]);
			}else{
				if(length>maxLength)
					maxLength=length;
				sb.deleteCharAt(0);
				length=3;
				sb.append(inputArray[i]+"");
			}
		}
		
		return maxLength;
	}
 }