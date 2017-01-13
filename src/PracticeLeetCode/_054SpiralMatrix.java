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
		List<Integer> list=new ArrayList<>();
		if(matrix==null||matrix.length==0)
			return list;

		int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
		while(top<=bottom && left<=right)
		{
			for (int i = left; i <=right; i++) {
				list.add(matrix[top][i]);
			}
			top++;
			for (int i = top; i <=bottom; i++) {
				list.add(matrix[i][right]);
			}
			right--;
			if(top>bottom)
				continue;
			for (int i = right; i >=left; i--) {
				list.add(matrix[bottom][i]);
			}
			bottom--;
			if(left>right)
				continue;
			for (int i = bottom; i >=top; i--) {
				list.add(matrix[i][left]);
			}
			left++;
		}
		return list;
	}
}

