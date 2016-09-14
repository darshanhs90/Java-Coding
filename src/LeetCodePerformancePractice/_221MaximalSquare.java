package LeetCodePerformancePractice;

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
		int s[][]=new int[matrix.length][matrix[0].length];
		int max=0;
		for (int i = 0; i < s.length; i++) {
			s[i][0]=Integer.parseInt(""+matrix[i][0]);
			max=Math.max(max,s[i][0]);
		}
		for (int i = 0; i < s[0].length; i++) {
			s[0][i]=Integer.parseInt(""+matrix[0][i]);
			max=Math.max(max,s[0][i]);
		}

		for (int i = 1; i < s.length; i++) {
			for (int j = 1; j < s[0].length; j++) {
				if(matrix[i][j]=='1')
					s[i][j]=1+Math.min(s[i-1][j-1], Math.min(s[i-1][j], s[i][j-1]));
				else
					s[i][j]=0;
				max=Math.max(max,s[i][j]);
			}	
		}
		return max*max;
	}
}
