package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/
 */
public class _0089FindSubSquareSum {

	public static void main(String[] args) {
		int mat[][] = {{1, 1, 1, 1, 1},
				{2, 2, 2, 2, 2},
				{3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4},
				{5, 5, 5, 5, 5},
		};
		int k = 3;
		printMatrix(mat);
		printSumSimple(mat, k);
	}



	private static void printSumSimple(int[][] mat, int k) {
		int noOfRows=mat.length;
		int noOfCols=mat[0].length;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(noOfRows-i>=k && noOfCols-j>=k){
					int sum=0;
					for (int m = i; m <i+k; m++) {
						for (int n = j; n <j+k; n++) {
							sum+=mat[m][n];
						}
					}
					System.out.print(sum+"/");
				}




			}
		}




	}



	private static void printMatrix(int[][] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}

	}


}
