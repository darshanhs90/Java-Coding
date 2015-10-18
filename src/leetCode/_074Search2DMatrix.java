package leetCode;

/*
 * Link : https://leetcode.com/problems/search-a-2d-matrix/
 */

public class _074Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		for (int i = 0; i < rows; i++) {
			if(matrix[i][cols-1]<target){
				continue;	
			}
			for (int j = cols-1; j >=0; j--) {
				if(matrix[i][j]==target)
					return true;
			}
			break;
		}
		return false;
	}

	public static void main(String[] args) {
		int [][]matrix=new int[][]
				{{1,3,5,7},
					{10,11,16,20},
					{23,30,34,50}};
	System.out.println(searchMatrix(matrix, 3));
	}
}