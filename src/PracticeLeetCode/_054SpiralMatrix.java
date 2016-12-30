package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _054SpiralMatrix {
	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][]{
			{2,5,8},
			{4,0,-1}}));
		System.out.println(spiralOrder(new int[][]{
			{2,5},
			{4,0}}));
		System.out.println(spiralOrder(new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}}));
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> outputList=new ArrayList<Integer>();
		if(matrix==null||matrix.length==0)
			return outputList;
		int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
		while(top<=bottom && left<=right)
		{
			//toprow
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
			if(top>bottom){
				continue;
			}
			for (int i = right; i >=left; i--) {
				outputList.add(matrix[bottom][i]);
			}
			bottom--;

			//left col
			if(left>right){
				continue;
			}
			for (int i = bottom; i >=top; i--) {
				outputList.add(matrix[i][left]);
			}
			left++;
		}
		return outputList;
	}
}

