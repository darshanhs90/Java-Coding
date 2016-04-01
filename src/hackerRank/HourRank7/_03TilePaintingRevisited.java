package hackerRank.HourRank7;

import java.util.Arrays;
import java.util.Scanner;

public class _03TilePaintingRevisited {



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int elements=in.nextInt();
			System.out.println(findNumberOfArithSequences(elements));
		}
	}

	private static int findNumberOfArithSequences(int elements) {
		if(elements%5==0||elements>5)
		{
			return elements*(elements-1)+1+elements/5;
		}
		else
			return elements*(elements-1)+1;
	}





}
