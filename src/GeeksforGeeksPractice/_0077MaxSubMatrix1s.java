package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class _0077MaxSubMatrix1s {

	public static void main(String[] args) {
		int mat[][] =  {{0, 1, 1, 0, 1}, 
						{1, 1, 0, 1, 0}, 
						{0, 1, 1, 1, 0},
						{1, 1, 1, 1, 0},
						{1, 1, 1, 1, 1},
						{0, 0, 0, 0, 0}};
		printMaxSubMatrix(mat);
	}

	private static void printMaxSubMatrix(int[][] m) {
		int s[][]=new int[m.length][m[0].length];
		//copy first row
		//copy first column
		//others copy min
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				if(i==0||j==0)
				{
					s[i][j]=m[i][j];
				}
				else{
					if(m[i][j]==1)
					{
						s[i][j]=Math.min(s[i][j-1],Math.min(s[i-1][j],s[i-1][j-1]))+1;
					}
					else{
						s[i][j]=0;
					}
				}
			}
		}
		//find max element
		int max=Integer.MIN_VALUE;
		int max_i=0,max_j=0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				if(s[i][j]>max)
				{
					max=s[i][j];
					max_i=i;
					max_j=j;
				}
			}
		}
		
		System.out.println(max);System.out.println(max_i);
		System.out.println(max_j);
		
		 for(int i = max_i; i > max_i - max; i--)
		  {
		    for(int j = max_j; j > max_j - max; j--)
		    {
		      System.out.print(m[i][j]+" ");
		    }  
		   System.out.println();
		  }  
		
		
		
		
		
		//printMatrix(s);
	}

	private static void printMatrix(int[][] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}
		
	}


}
