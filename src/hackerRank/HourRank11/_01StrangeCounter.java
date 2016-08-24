package hackerRank.HourRank11;

import java.util.Scanner;

public class _01StrangeCounter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long t=scanner.nextLong();
		long multiple=3,count=3;
		while(count<t)
		{
			multiple=multiple*2;
			count+=multiple;
		}
		System.out.println("output is->"+(multiple-(t-(count-multiple+1))));
	}
}

