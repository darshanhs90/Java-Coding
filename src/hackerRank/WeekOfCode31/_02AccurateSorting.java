package hackerRank.WeekOfCode31;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w31/challenges/accurate-sorting
 */
public class _02AccurateSorting {

	/*
1
4
0 1000 900 1111	
	 */	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			int[] a = new int[n];
			for(int a_i=0; a_i < n; a_i++){
				a[a_i] = in.nextInt();
				if(a_i!=0)
				{
					if(((a[a_i-1])==a[a_i]+1))
					{
						int temp=a[a_i-1];
						a[a_i-1]=a[a_i];
						a[a_i]=temp;
					}
				}
			}
			// Write Your Code Here
			boolean breaker=false;
			for (int i = 1; i < a.length; i++) {
				if(a[i]<a[i-1])
				{
					System.out.println("No");
					breaker=true;
					break;
				}
			}
			if(!breaker)
				System.out.println("Yes");
		}
	}
}

