package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * Link:https://www.hackerrank.com/challenges/manasa-and-stones
 */
public class _12ManasaAndStones {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			int n=Integer.parseInt(scanner.nextLine());
			int a=Integer.parseInt(scanner.nextLine());
			int b=Integer.parseInt(scanner.nextLine());
			if(b>a)
			{
				a=a^b;b=a^b;a=a^b;
			}
			int sum=(n-1)*a;
			TreeSet<Integer> sumset=new TreeSet<>();
			sumset.add(sum);
			for (int j = 0; j < n-1; j++) {
				sum=sum-a+b;
				sumset.add(sum);
			}
			System.out.println(Arrays.toString(sumset.toArray()).replaceAll(", ", " ").replace("[","").replace("]",""));
		}
	}
}
