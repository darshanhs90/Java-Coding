package hackerRank.WorldCodeSprint;


import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/worldcodesprint/challenges/bear-and-cryptography
 */
public class _08BearAndCryptography {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String splitStringArray[]=scanner.nextLine().split(" ");
			int N=Integer.parseInt(splitStringArray[0]);
			int K=Integer.parseInt(splitStringArray[1]);
			int noOfDivisors=0;
			boolean found=false;
			int number=-1;
			for (int j = 1;j<N; j++) {
				noOfDivisors=1;
				for (int k = 1; k <=j/2; k++) {
					if(j%k==0)
						noOfDivisors++;
				}
				if(noOfDivisors==K){
					number=j;
				}
			}
				System.out.println(number);
		}
	}
}
