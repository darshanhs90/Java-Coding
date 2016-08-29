package LeetCodePerformancePractice;

public class _074Search2DMatrix {
	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]{
			{1,   3,  5,  7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		}, 31));

	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int numRows=matrix.length;
		int numCols=matrix[0].length;
		int row=0,col=numCols-1;
		while(row>=0 && row<numRows && col>=0 &&col<numCols)
		{
			if(matrix[row][col]==target)
				return true;
			else if(matrix[row][col]>target)
				col--;
			else
				row++;
		}
		return false;
	}
}
