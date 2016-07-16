package servicenowPrep;

public class _065MaxLengthMatrix
{

	public static void main(String[] args) {
		int mat[][] = {{1, 2, 3},
					{6, 5, 4},
					{7, 8, 9}};
		System.out.println(findMaxLength(mat));
	}

	private static int findMaxLength(int[][] mat) {
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				visited=new boolean[mat.length][mat[0].length];
				max=Math.max(max, getCount(mat,i,j));
			}
		}
		return max+1;
	}
	static boolean[][] visited;
	private static int getCount(int[][] mat, int i, int j) {
		if(i<0||j<0||i>mat.length-1||j>mat[0].length-1||visited[i][j])
			return 0;
		visited[i][j]=true;
		int count1=0,count2=0,count3=0,count4=0;
		if(i-1>=0 && mat[i-1][j]==mat[i][j]+1)
		{
			count1= 1+getCount(mat, i-1, j);
		}
		if(j-1>=0 && mat[i][j-1]==mat[i][j]+1)
		{
			count2= 1+getCount(mat, i, j-1);
		}
		if(i+1<mat.length && mat[i+1][j]==mat[i][j]+1)
		{
			count3= 1+getCount(mat, i+1, j);
		}
		if(j+1<mat[0].length && mat[i][j+1]==mat[i][j]+1)
		{
			count4= 1+getCount(mat, i, j+1);
		}
		return Math.max(count1, Math.max(count2, Math.max(count3, count4)));
	}

	

}