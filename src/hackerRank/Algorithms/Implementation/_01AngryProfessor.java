package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/angry-professor
 */
public class _01AngryProfessor {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			String inputLine=scanner.nextLine();
			String students[]=scanner.nextLine().split(" ");
			int noOfStudents=Integer.parseInt(inputLine.split(" ")[0]);
			int minNoOfStudents=Integer.parseInt(inputLine.split(" ")[1]);
			int count=0;
			for(int j=0;j<noOfStudents;j++)
			{
				if(Integer.parseInt(students[j])<=0)
				{
					count++;
				}
			}
			if(count<minNoOfStudents)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
