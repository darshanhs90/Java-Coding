package hackerRank.WorldCodeSprint;


import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/worldcodesprint/challenges/save-our-ship
 */
public class _01MarsExploration {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=(scanner.nextLine());
		int alteredCount=0;
		for (int i = 0; i < inputString.length()/3; i++) {
			if(inputString.charAt(i*3)!='S')
				alteredCount++;
			if(inputString.charAt(i*3+1)!='O')
				alteredCount++;
			if(inputString.charAt(i*3+2)!='S')
				alteredCount++;
		}
		System.out.println(alteredCount);
	}
}
