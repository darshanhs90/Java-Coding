package hackerRank.CrackingTheCodingInterview;

import java.util.Scanner;

public class _14ConnectedCellInGrid {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(findGridSize(grid));
    }

	private static int findGridSize(int[][] grid) {
		int max=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]==1)
					max=Math.max(max, getGridCount(i,j,grid));
			}
		}
		return max;
	}

	private static int getGridCount(int i,int j,int[][] grid) {
		if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]!=1)
			return 0;
		grid[i][j]=2;
		return 1+getGridCount(i-1, j-1, grid)+getGridCount(i-1, j, grid)
				+getGridCount(i-1, j+1, grid)+getGridCount(i, j-1, grid)
				+getGridCount(i, j+1, grid)+getGridCount(i+1, j-1, grid)
				+getGridCount(i+1, j, grid)+getGridCount(i+1, j+1, grid);
	}
}
