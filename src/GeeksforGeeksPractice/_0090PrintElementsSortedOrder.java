package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/
 */
public class _0090PrintElementsSortedOrder {

	public static void main(String[] args) {
		int mat[][] = { {10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50},
		};
		printMatrix(mat);
		for (int i = 0; i <mat.length*mat.length; i++) {
			System.out.print(printSortedElements(mat)+"//");
		}
	}






	private static int printSortedElements(int[][] mat) {
		int ret=mat[0][0];
		mat[0][0]=Integer.MAX_VALUE;
		youngify(mat,0,0);
		return ret;
	}






	private static void youngify(int[][] mat, int i, int j) {
		int rows=mat.length,cols=mat[0].length;
		int downVal=(i<rows-1)?mat[i+1][j]:Integer.MAX_VALUE;
		int rightVal=(j<cols-1)?mat[i][j+1]:Integer.MAX_VALUE;
		if(downVal==Integer.MAX_VALUE && rightVal==Integer.MAX_VALUE)
			return;

		if(downVal<rightVal)
		{
			mat[i][j]=downVal;
			mat[i+1][j]=Integer.MAX_VALUE;
			youngify(mat, i+1, j);
		}
		else{
			mat[i][j]=rightVal;
			mat[i][j+1]=Integer.MAX_VALUE;
			youngify(mat, i, j+1);
		}
	}






	private static void printMatrix(int[][] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}

	}


}
