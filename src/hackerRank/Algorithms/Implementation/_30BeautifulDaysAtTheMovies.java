package hackerRank.Algorithms.Implementation;

import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
 */
public class _30BeautifulDaysAtTheMovies {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();
		int count=0;
		for (int k2 = i; k2 <=j; k2++) {
			int reversedNum=Integer.parseInt(new StringBuilder(k2+"").reverse().toString());
			if(Math.abs(k2-reversedNum)%k==0)
				count++;
		}
		System.out.println(count);
	}
}
