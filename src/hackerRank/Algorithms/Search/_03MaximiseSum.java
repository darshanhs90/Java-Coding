package hackerRank.Algorithms.Search;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * Link:https://www.hackerrank.com/challenges/maximise-sum
 */
public class _03MaximiseSum {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int m=Integer.parseInt(scanner.nextLine());
		String mArray[]=scanner.nextLine().split(" ");
		int n=Integer.parseInt(scanner.nextLine());
		String nArray[]=scanner.nextLine().split(" ");
		Arrays.sort(mArray);
		Arrays.sort(nArray);
		int countArray[]=new int[10001];
		for (int i = 0; i < mArray.length; i++) {
			countArray[Integer.parseInt(mArray[i])]--;
		}
		Set<Integer> elementsSet=new TreeSet<>();
		for (int i = 0; i < nArray.length; i++) {
			countArray[Integer.parseInt(nArray[i])]++;
			elementsSet.add(Integer.parseInt(nArray[i]));
		}
		Object elementsArray[]=elementsSet.toArray();
		for (int i = 0; i < elementsArray.length; i++) {
			if(countArray[(int) elementsArray[i]]!=0)
				System.out.print(elementsArray[i]+" ");
		}
	}
}
