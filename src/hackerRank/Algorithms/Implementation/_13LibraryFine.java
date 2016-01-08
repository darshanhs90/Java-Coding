package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/library-fine
 */
public class _13LibraryFine {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputLine[]=scanner.nextLine().split(" ");
		int actualDay=Integer.parseInt(inputLine[0]);
		int actualMonth=Integer.parseInt(inputLine[1]);
		int actualYear=Integer.parseInt(inputLine[2]);
		inputLine=scanner.nextLine().split(" ");
		int expectedDay=Integer.parseInt(inputLine[0]);
		int expectedMonth=Integer.parseInt(inputLine[1]);
		int expectedYear=Integer.parseInt(inputLine[2]);

		if(expectedYear<actualYear)
		{
			System.out.println("10000");
		}else if(expectedYear==actualYear)
		{
			if(actualMonth>expectedMonth)
			{
				System.out.println(Math.abs(actualMonth-expectedMonth)*500);
			}else if(actualMonth==expectedMonth)
			{
				if(actualDay>expectedDay)
				{
					System.out.println(Math.abs(actualDay-expectedDay)*15);
				}else{
					System.out.println("0");
				}
			}
			else{
				System.out.println("0");
			}	
		}
		else{
			System.out.println("0");
		}
	}
}
