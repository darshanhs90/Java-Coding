package hackerRank.Algorithms.Warmup;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/time-conversion
 */
public class _09CircularArrayRotation {
	public static void main(String args[])
	{
		Scanner scanner =new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int q=scanner.nextInt();
		int []arr=new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=scanner.nextInt();
		}
		arr=performRotation(arr,k);
		for (int i = 0; i < q; i++) {
			int m=scanner.nextInt();
			System.out.println(arr[m]);
		}
	}

	private static int[] performRotation(int[] arr, int k) {
		if(k>arr.length)
			k=k%arr.length;
		int newarr[]=new int[arr.length];
		int index=0;
		for (int i = arr.length-k; i < arr.length; i++) {
			newarr[index++]=arr[i];
		}
		for (int i = 0; i < arr.length-k; i++) {
			newarr[index++]=arr[i];
		}
		return newarr;
	}
	
	
	

/*	private static int[] performRotation(int[] arr, int k) {
		if(k>arr.length)
			k=k%arr.length;
		for (int i = 0; i < k; i++) {
			arr=rotateArray(arr);
		}
		return arr;
	}

	private static int[] rotateArray(int[] arr) {
		int value=arr[arr.length-1];
		for (int i = 0; i < arr.length; i++) {
			int temp=arr[i];
			arr[i]=value;
			value=temp;
		}
		return arr;
	}*/

}
