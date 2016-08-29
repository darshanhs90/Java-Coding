package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _054SpiralMatrix {
	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][]{
			{2,5,8},
			{4,0,-1}}));
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> outputList=new ArrayList<>();
		if(matrix==null||matrix.length==0)
			return outputList;
		int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
		while(outputList.size()<matrix.length*matrix[0].length)
		{
			//top row
			for (int i = left; i <=right; i++) {
				outputList.add(matrix[top][i]);
			}
			top++;

			//right col
			for (int i = top; i <=bottom; i++) {
				outputList.add(matrix[i][right]);
			}
			right--;


			//bottom row
			if(bottom<top)
				break;
			for (int i = right; i >=left; i--) {
				outputList.add(matrix[bottom][i]);
			}
			bottom--;

			//left col
			if(right<left)
				break;
			for (int i = bottom; i >=top; i--) {
				outputList.add(matrix[i][left]);
			}
			left++;
		}
		return outputList;
	}
}

