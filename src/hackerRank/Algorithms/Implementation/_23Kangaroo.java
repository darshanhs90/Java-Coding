package hackerRank.Algorithms.Implementation;

import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/kangaroo
 */
public class _23Kangaroo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x1=scanner.nextInt();
		int v1=scanner.nextInt();
		int x2=scanner.nextInt();
		int v2=scanner.nextInt();
		if((v2>v1 && x2>x1)||(v1==v2 && (x2>x1 ||x1>x2))||
				(x1-x2)%(v2-v1)==0)
			System.out.println("NO");
		else{
			System.out.println("YES");
		}
	}


}
