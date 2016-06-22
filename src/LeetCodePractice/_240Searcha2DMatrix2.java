package LeetCodePractice;

public class _240Searcha2DMatrix2{
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row=0,column=matrix[0].length-1;
		while(row<matrix.length && row>=0 && column<matrix[0].length && column>=0)
		{
			if(matrix[row][column]==target)
				return true;
			else if(matrix[row][column]<target)
			{
				row++;
			}else{
				column--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]{{1,   4,  7, 11, 15},
			{2,   5,  8, 12, 19},
			{3,   6,  9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}}, 95));
	}
}

