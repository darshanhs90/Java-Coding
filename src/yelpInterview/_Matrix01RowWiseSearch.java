package yelpInterview;

public class _Matrix01RowWiseSearch {
	public static void main(String a[]){
		int mat[][] = { {10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50},
		};
		System.out.println(search(mat, 29));
	}

	private static boolean search(int[][] mat, int value) {
		int row=0,col=mat[0].length-1;
		while(row<mat.length && col>=0)
		{
			if(mat[row][col]==value)
			{
				return true;
			}else if(mat[row][col]>value)
			{
				col--;
			}else{
				row++;
			}
		}
		return false;
	}



}