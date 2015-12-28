package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/find-digits
 */
public class _04FindDigits {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			String N=(scanner.nextLine());
			int count=0;
			for (int j = 0; j < N.length(); j++) {
				int value=Integer.parseInt(N.charAt(j)+"");
				if(value!=0 && Integer.parseInt(N)%value==0)
				{
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
