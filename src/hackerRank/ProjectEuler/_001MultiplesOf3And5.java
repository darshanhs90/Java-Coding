package hackerRank.ProjectEuler;


import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/contests/projecteuler/challenges/euler001
*/
public class _001MultiplesOf3And5 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			Long b=Long.parseLong(scanner.nextLine());
			Long threeMultiples=(b-1)/3;
			Long fiveMultiples=(b-1)/5;
			Long difference=(b-1)/15;
			System.out.println(findAPSum(3,threeMultiples)+findAPSum(5,fiveMultiples)-findAPSum(15,difference));
		}
	}

	private static Long findAPSum(long number,Long times) {
		Long sum=((times)*(2*(number)+(times-1)*number))/2;
		return sum;
	}
}
