package hackerRank.Algorithms.Implementation;

import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/larrys-array
 */
public class _22LarrysArray {
	static int[] inputArray;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int k=scanner.nextInt();
			inputArray=new int[k];
			for (int j = 0; j < k; j++) {
				inputArray[j]=scanner.nextInt();
			}
			System.out.println(checkSortArray(inputArray));
		}
		scanner.close();


	}

	private static String checkSortArray(int[] inputArray) {
		for (int i = 0; i <=inputArray.length-3; i++) {
			if(!sort(i))
				return "NO";
		}
		int length=inputArray.length-1;
		if(inputArray[length]!=length+1 || inputArray[length-1]!=length|| inputArray[length-2]!=length-1)
			return "NO";
		return "YES";
	}

	private static boolean sort(int i) {
		if(inputArray[i]==i+1)
			return true;
		else{
			rotateRight(i);
			if(inputArray[i]!=i+1){
				rotateLeft(i);
				return inputArray[i]==i+1;
			}
			else{
				return true;
			}
		}
	}

	private static void rotateLeft(int i) {
		inputArray[i]=inputArray[i]^inputArray[i+1];
		inputArray[i+1]=inputArray[i]^inputArray[i+1];
		inputArray[i]=inputArray[i]^inputArray[i+1];
		inputArray[i]=inputArray[i]^inputArray[i+2];
		inputArray[i+2]=inputArray[i]^inputArray[i+2];
		inputArray[i]=inputArray[i]^inputArray[i+2];
	}

	private static void rotateRight(int i) {
		inputArray[i]=inputArray[i]^inputArray[i+1];
		inputArray[i+1]=inputArray[i]^inputArray[i+1];
		inputArray[i]=inputArray[i]^inputArray[i+1];
		inputArray[i]=inputArray[i]^inputArray[i+2];
		inputArray[i+2]=inputArray[i]^inputArray[i+2];
		inputArray[i]=inputArray[i]^inputArray[i+2];
	}


}
