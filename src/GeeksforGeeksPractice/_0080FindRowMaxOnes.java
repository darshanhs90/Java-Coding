package GeeksforGeeksPractice;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Link : http://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
 */
public class _0080FindRowMaxOnes {

	public static void main(String[] args) {
		int mat[][] = { {0, 0, 0, 1},
		        {0, 1, 1, 1},
		        {1, 1, 1, 1},
		        {0, 0, 0, 0}
		    };
		printMatrix(mat);
		System.out.println(findMaxRow(mat));
	}

	private static int findMaxRow(int[][] mat) {
		int maxRow=-1,max=Integer.MIN_VALUE;
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]==1 && ((mat[0].length-j)>max))
				{
					maxRow=i;
					max=mat[0].length-j;
					break;
				}
			}
		}
		return maxRow;
	}

	private static void printMatrix(int[][] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}

	}


}
