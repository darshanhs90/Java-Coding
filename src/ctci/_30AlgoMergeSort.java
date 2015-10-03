package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*Implementation of Merge Sort*/
public class _30AlgoMergeSort{

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputStringArray[]=scanner.nextLine().split(",");
		scanner.close();
		int inputArray[]=new int[inputStringArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=Integer.parseInt(inputStringArray[i]);
		}
		System.out.println(Arrays.toString(inputArray));
		int outputArray[]=mergeSort(inputArray);
		System.out.println(Arrays.toString(outputArray));
	}

	private static int[] mergeSort(int[] inputArray) {



		return null;
	}
}