package hackerRank.Algorithms.Sorting;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/insertionsort1
 */
public class _02InsertionSortPart1 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int size=Integer.parseInt(scanner.nextLine());
		String inputArray[]=scanner.nextLine().split(" ");
		int value=Integer.parseInt(inputArray[inputArray.length-1]);
		for (int i = inputArray.length-2; i >=0; i--) {
			int arrayValue=Integer.parseInt(inputArray[i]);
			if(arrayValue>value)
			{
				inputArray[i+1]=String.valueOf(arrayValue);
			}
			else if(arrayValue<value)
			{
				inputArray[i+1]=String.valueOf(value);
				System.out.println(Arrays.toString(inputArray).replaceAll(",", "").replace("[", "").replace("]", ""));
				break;
			}
			System.out.println(Arrays.toString(inputArray).replaceAll(",", "").replace("[", "").replace("]", ""));
		}
		if(Integer.parseInt(inputArray[0])>value){
			inputArray[0]=String.valueOf(value);
			System.out.println(Arrays.toString(inputArray).replaceAll(",", "").replace("[", "").replace("]", ""));
		}
	}
}
