package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/find-sum-of-all-elements-in-a-matrix-except-the-elements-in-given-row-andor-column-2/
 */
public class _0081FindSumElementsExceptRowColumn {

	public static void main(String[] args) {
		int mat[][] = {{1, 1, 2}, {3, 4, 6}, {5, 3, 2}};
		String arr[] = {"0->0", "1->1", "0->1"};
		findSum(mat,arr);
	}
	static int sum;
	static int[] rowSum,colSum; 
	

	private static void findSum(int[][] mat,String[] arr) {
		rowSum=new int[mat.length];
		colSum=new int[mat[0].length];
		sum=0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				sum+=mat[i][j];
				rowSum[i]+=mat[i][j];
				colSum[j]+=mat[i][j];
			}
		}
		printMatrix(mat);
		System.out.println(sum);
		System.out.println(Arrays.toString(rowSum));
		System.out.println(Arrays.toString(colSum));
		for (int k = 0; k < arr.length; k++) {
			String str[]=arr[k].split("->");
			int i=Integer.parseInt(str[0]),j=Integer.parseInt(str[1]);
			int indexSum=sum-rowSum[i]-colSum[j]+mat[i][j];
			System.out.println(indexSum);
		}
		
	}



	private static void printMatrix(int[][] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(s[i]));
		}

	}


}
