package eBayPrep;

public class _074Search2DMatrix {


	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]{{1,   3,  5,  7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		},22));
	}

	private static boolean searchMatrix(int[][] matrix, int key) {
		int rowPointer=0,colPointer=matrix[0].length-1;

		while(rowPointer<matrix.length && colPointer>=0)
		{
			if(matrix[rowPointer][colPointer]==key)
				return true;
			else if(matrix[rowPointer][colPointer]>key)
				colPointer--;
			else
				rowPointer++;	
		}
		return false;
	}									



}

