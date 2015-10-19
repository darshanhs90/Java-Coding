package leetCode;

/*
 * Link : https://leetcode.com/problems/search-a-2d-matrix-ii/
 */

public class _240Search2DMatrix2 {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int rowNumber=0,colNumber=matrix[0].length-1;
		int noOfRows=matrix.length-1;
		while(rowNumber<=noOfRows && colNumber>=0){
			if(matrix[rowNumber][colNumber]==target){
				return true;
			}	
			else if(matrix[rowNumber][colNumber]>target)
			{
				colNumber--;
			}
			else{
				rowNumber++;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]{
			{1,4,7,11,15},
			{2,5,8,12,19},
			{3,6,9,16,22},
			{10,13,14,17,24},
			{18,21,23,26,30}	
		}, 5));


	}
}