package hackerRank.WeekOfCode26;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Link:https://www.hackerrank.com/contests/w26/challenges/pairs-again
 */
public class _05SatisfactoryPairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count=0;
		//a*x+b*y=n
		Set<String> set=new HashSet<String>();
		int b=0;
		for (int x = 1; x < n; x++) {
			for (int y = 1; y < n; y++) {
				for (int a = 1; a < n; a++) {
					b=(int)((n-(a*x))/(float)y);
					if(b>a && !set.contains(a+","+b) && a*x+b*y==n){
						count++;
						set.add(a+","+b);
						//System.out.println(a+","+b);
					}
				}	
			}	
		}
		System.out.println(count);
	}
}

