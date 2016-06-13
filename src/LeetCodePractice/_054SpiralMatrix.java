package LeetCodePractice;

import java.util.ArrayList;
import java.util.List;

public class _054SpiralMatrix {

	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][]{ {1,  2,  3,  4,  5,  6},
			{7,  8,  9,  10, 11, 12},
			{13, 14, 15, 16, 17, 18}
		}));
		System.out.println(spiralOrder(new int[][]{ {2,5,8}//,{4,0,-1}
		}));
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
		if(matrix==null ||matrix.length==0)
			return new ArrayList<>();
		List<Integer> aList=new ArrayList<>();
		int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
		while(left<=right && top<=bottom)
		{

			for (int i = left; i <=right; i++) {
				aList.add(matrix[top][i]);
			}
			top++;

			//right column
			for (int i = top; i <=bottom; i++) {
				aList.add(matrix[i][right]);
			}
			right--;

			//bottom row
			if(top<=bottom){
				for (int i = right; i >=left; i--) {
					aList.add(matrix[bottom][i]);
				}
				bottom--;
			}

			//left column
			if(left<=right){
				for (int i = bottom; i >=top; i--) {
					aList.add(matrix[i][left]);
				}
				left++;
			}
		}

		return aList;

	}
}

