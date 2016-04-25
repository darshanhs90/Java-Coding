package yelpInterview;

public class _Array35NumberOfIslands {
	static boolean[][] visited;
	public static void main(String a[]){
		int inputArray[][]= {   {1, 1, 0, 0, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 0, 1, 0, 1}
		};

		System.out.println(findIslandsCount(inputArray));
	}
	private static int findIslandsCount(int[][] inputArray) {
		int count=0;
		visited=new boolean[inputArray.length][inputArray[0].length];
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray[0].length; j++) {
				if(!visited[i][j] && inputArray[i][j]!=0)
				{
					count+=performDfs(inputArray,i,j)>0?1:0;
				}
			}
		}
		return count;
	}

	private static int performDfs(int[][] inputArray, int i, int j) {
		if(!(i>=0 && i<=inputArray.length-1 && j>=0 && j<=inputArray[0].length-1))
			return 0;
		if(visited[i][j])
			return 0;
		visited[i][j]=true;
		if(inputArray[i][j]==0){
			return 0;
		}
		else
			return 1+performDfs(inputArray, i-1, j-1)
			+performDfs(inputArray, i-1, j)+performDfs(inputArray, i-1, j+1)
			+performDfs(inputArray, i+1, j-1)+performDfs(inputArray, i+1, j)
			+performDfs(inputArray, i+1, j+1);
	}


}