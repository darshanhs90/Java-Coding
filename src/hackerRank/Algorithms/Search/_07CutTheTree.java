package hackerRank.Algorithms.Search;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/count-luck
 */
public class _07CutTheTree {

	static boolean found=false;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String lineArray[]=scanner.nextLine().split(" ");
			int N=Integer.parseInt(lineArray[0]);
			int M=Integer.parseInt(lineArray[1]);
			char inputArray[][]=new char[N][M];
			visited=new boolean[N][M];
			int indexX=0,indexY=0;  
			String st1="*.M";
			String st2=".X.";
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
			int K=Integer.parseInt(scanner.nextLine());
			System.out.println(getCountLuck(inputArray,visited,indexX,indexY,1,0)==K?"Impressed":"Oops!");
		}
	}

	private static int getCountLuck(char[][] inputArray, boolean[][] visited, int i, int j,int count,int direction) {
		if(i<0||j<0||i>=inputArray.length||j>=inputArray[0].length)
			return count;
		if(visited[i][j]==true||inputArray[i][j]=='X'||inputArray[i][j]=='M')
			return count;
		visited[i][j]=true;
		if(inputArray[i][j]=='*')
			return count;
		int a,b,c,d;
		a=getCountLuck(inputArray, visited, i-1, j,count,-1)+direction==-1?0:1;
		b=1+getCountLuck(inputArray, visited, i+1, j,count,1)+direction==1?0:1;
		c=1+getCountLuck(inputArray, visited, i, j-1,count,-2)+direction==-2?0:1;		
		d=1+getCountLuck(inputArray, visited, i, j+1,count,2)+direction==1?0:1;
		return Math.min(Math.min(Math.min(a, b),c),d);
	}
}
