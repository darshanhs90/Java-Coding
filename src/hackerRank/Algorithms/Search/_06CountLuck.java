package hackerRank.Algorithms.Search;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/count-luck
 */
public class _06CountLuck {

	static boolean found=false;
	static boolean[][] visited;
//	*.M
//	.X.
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=1;//Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String lineArray[]="2 3".split(" ");//scanner.nextLine().split(" ");
			int N=Integer.parseInt(lineArray[0]);
			int M=Integer.parseInt(lineArray[1]);
			char inputArray[][]=new char[N][M];
			visited=new boolean[N][M];
			int indexX=0,indexY=0;  
			for (int j = 0; j < N; j++) {
				String str=scanner.nextLine();
				inputArray[j]=str.toCharArray();
				Arrays.fill(visited[j], false);
				if(str.contains("M"))
				{
					indexX=j;
					indexY=str.indexOf('M');
					visited[indexX][indexY]=true;
				}
			}
			int K=1;//Integer.parseInt(scanner.nextLine());
			System.out.println(getCountLuck(inputArray,visited,indexX,indexY,0));
		}
	}

	private static int getCountLuck(char[][] inputArray, boolean[][] visited, int i, int j,int count) {
		if(i<0||j<0||i>inputArray.length-1||j>inputArray[0].length-1)
			return count;
		if(visited[i][j]==true||inputArray[i][j]=='X')
			return count;
		visited[i][j]=true;
		if(inputArray[i][j]=='*')
			return count;
		int a,b,c,d;
		a=getCountLuck(inputArray, visited, i-1, j,count+1);
		b=getCountLuck(inputArray, visited, i+1, j,count+1);
		c=getCountLuck(inputArray, visited, i, j-1,count+1);		
		d=getCountLuck(inputArray, visited, i, j+1,count+1);
		return Math.min(Math.min(Math.min(a, b),c),d);
	}
}
