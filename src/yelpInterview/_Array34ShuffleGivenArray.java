package yelpInterview;

import java.util.Arrays;
import java.util.Random;

public class _Array34ShuffleGivenArray {
	public static void main(String a[]){
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(Arrays.toString(arr));
		arr=shuffleArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] shuffleArray(int[] arr) {
		Random rand = new Random();
		for (int i = arr.length-1; i > 0; i--)
		{
			int j = rand.nextInt(i+1);
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		return arr;
	}
}