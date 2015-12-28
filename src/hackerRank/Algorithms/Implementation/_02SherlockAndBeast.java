package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/sherlock-and-the-beast
 */
public class _02SherlockAndBeast {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<noOfTestCases;i++)
		{
			int N=Integer.parseInt(scanner.nextLine());
			int noOfThrees=0,noOfFives=N;
			boolean breaker=false;
			while(true){
				if(noOfFives%3==0 && noOfThrees%5==0)
				{
					break;
				}
				else{
					noOfFives--;
					noOfThrees++;
				}
				if(noOfThrees>N || noOfFives<0){
					breaker=true;
					break;
				}
			}
			if(breaker)
				System.out.println("-1");
			else{
				StringBuilder sb=new StringBuilder("");
				for (int j = 0; j < noOfFives; j++) {
					sb.append("5");
				}
				for (int j = 0; j < noOfThrees; j++) {
					sb.append("3");
				}
				System.out.println(sb.toString());
			}

		}
	}
}
