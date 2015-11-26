package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/a-boolean-matrix-question/
 */
public class _0074BooleanMatrix {

	public static void main(String[] args) {
		int mat[][] = { {1, 0, 0, 1},
				{0, 0, 1, 0},
				{0, 0, 0, 0}};
		convertMatrix(mat);
		mat=new int[][]{{1,0},
			{0,0}};
			convertMatrix(mat);

			mat=new int[][]{{0,0,0},
				{0,0,1}};
				convertMatrix(mat);
	}

	private static void convertMatrix(int[][] mat) {
		boolean rows[]=new boolean[mat.length];
		boolean cols[]=new boolean[mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]==1)
				{
					rows[i]=true;
					cols[j]=true;
				}
			}
		}
		for (int i = 0; i < rows.length; i++) {
			if(rows[i]==true)
			{
				Arrays.fill(mat[i],1);
			}
		}
		for (int i = 0; i < cols.length; i++) {
			if(cols[i]==true)
			{
				for (int j = 0; j < rows.length; j++) {
					mat[j][i]=1;
				}
			}
		}
		
		for (int i = 0; i < rows.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		
		
		

	}




}
