package hackerRank.HourRank10;

import java.util.Scanner;

public class _02TheBombermanGame {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str[]=scanner.nextLine().split(" ");
		int noOfRows=Integer.parseInt(str[0]);
		int noOfCols=Integer.parseInt(str[1]);
		int time=Integer.parseInt(str[2]);
		char[][] bombMatrix=new char[noOfRows][noOfCols];
		for (int i = 0; i < noOfRows; i++) {
			String string=scanner.nextLine();
			for (int j = 0; j < noOfCols; j++) {
				bombMatrix[i][j]=string.charAt(j);
			}
			//System.out.println(Arrays.toString(bombMatrix[i]));
		}
		//System.out.println();
		int currTime=3;
		bombMatrix=fillBombsToEmptyCells(bombMatrix);
		bombMatrix=detonateBombs(bombMatrix);
		boolean filled=false;
		while(currTime<time)
		{
			if(!filled){
				bombMatrix=fillBombsToEmptyCells(bombMatrix);
			}
			else{
				bombMatrix=detonateBombs(bombMatrix);
			}
			filled=!filled;
			currTime+=1;
		}
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfCols; j++) {
				if(bombMatrix[i][j]!='.')
					System.out.print("O");
				else
					System.out.print(".");
			}
			System.out.println();
		}
	}

	private static char[][] detonateBombs(char[][] bombMatrix) {
		char[][] newBombMatrix=new char[bombMatrix.length][bombMatrix[0].length];
		for (int i = 0; i < bombMatrix.length; i++) {
			for (int j = 0; j < bombMatrix[0].length; j++) {
				if(newBombMatrix[i][j]=='.' && bombMatrix[i][j]!='3')
					continue;
				if(bombMatrix[i][j]!='.' && bombMatrix[i][j]!='3'){
					if(bombMatrix[i][j]=='0')
						newBombMatrix[i][j]='1';
					else if(bombMatrix[i][j]=='1')
						newBombMatrix[i][j]='2';
					else
						newBombMatrix[i][j]='3';
				}
				else if(bombMatrix[i][j]=='3')
				{
					if(i-1>=0)
					{
						newBombMatrix[i-1][j]='.';
					}
					if(i+1<bombMatrix.length)
					{
						newBombMatrix[i+1][j]='.';
					}
					if(j-1>=0)
					{
						newBombMatrix[i][j-1]='.';
					}
					if(j+1<bombMatrix[0].length)
						newBombMatrix[i][j+1]='.';
					newBombMatrix[i][j]='.';	
				}
				else if(bombMatrix[i][j]=='.')
				{
					newBombMatrix[i][j]='.';	
				}
			}
			//System.out.println(Arrays.toString(newBombMatrix[i]));
		}
		//System.out.println();
		return newBombMatrix;
	}

	private static char[][] fillBombsToEmptyCells(char[][] bombMatrix) {
		for (int i = 0; i < bombMatrix.length; i++) {
			for (int j = 0; j < bombMatrix[0].length; j++) {
				if(bombMatrix[i][j]=='.')
					bombMatrix[i][j]='0';
				else{
					if(bombMatrix[i][j]=='0')
						bombMatrix[i][j]='1';
					else if(bombMatrix[i][j]=='1')
						bombMatrix[i][j]='2';
					else
						bombMatrix[i][j]='3';
				}
			}
			//System.out.println(Arrays.toString(bombMatrix[i]));
		}
		//System.out.println("bomb filled");
		return bombMatrix;
	}
}

