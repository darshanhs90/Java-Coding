package PracticeLeetCode;

public class _221MaximalSquare {
	public static void main(String[] args) {
		System.out.println(maximalSquare(new char[][]{
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}
		}));
	}
	public static int maximalSquare(char[][] matrix) {
		if(matrix==null||matrix.length==0)
			return 0;
		int[][] newMat=new int[matrix.length][matrix[0].length];
		int max=0;
		for (int i = 0; i < newMat.length; i++) {
			if(matrix[i][0]=='1'){
				newMat[i][0]=1;
				max=1;
			}
		}
		for (int i = 0; i < newMat[0].length; i++) {
			if(matrix[0][i]=='1'){
				newMat[0][i]=1;
				max=1;
			}
		}

		for (int i = 1; i < newMat.length; i++) {
			for (int j = 1; j < newMat[0].length; j++) {
				if(matrix[i][j]=='1')
					newMat[i][j]=1+Math.min(newMat[i-1][j], 
							Math.min(newMat[i][j-1], newMat[i-1][j-1]));
				else
					newMat[i][j]=0;
				max=Math.max(newMat[i][j], max);
			}
		}
		return max*max;
	}

}