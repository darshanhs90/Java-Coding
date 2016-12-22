package hackerRank.WeekOfCode27;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w27/challenges/tailor-shop
 */
public class _03HackonacciMatrixRotations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		char c[][]=new char[][]{
			{'Y','X','X','X','X','Y','Y'},
			{'X','X','Y','Y','X','X','Y'},
			{'X','Y','X','X','Y','X','Y'},
			{'X','Y','X','X','Y','X','Y'},
			{'X','X','Y','Y','X','X','Y'},
			{'Y','X','X','X','X','Y','Y'},
			{'Y','Y','Y','Y','Y','Y','Y'}
		};
		char[][] charMat=generateMatrix(n,c);
		for(int a0 = 0; a0 < q; a0++){
			int angle = in.nextInt();
			System.out.println(findDiff(angle,charMat));
		}
	}

	private static int findDiff(int angle, char[][] charMat) {
		if(angle<0)
			angle=360-(-1*angle)%360;
		else
			angle=angle%360;
		int count=0;
		int n=charMat.length-1;
		if(angle==90)
		{
			//row wise check
			for (int i = 0; i < charMat.length; i++) {
				for (int j = 0; j < charMat.length; j++) {
					if(charMat[i][j]!=charMat[i][n-j])
						count++;
				}
			}
		}
		else if(angle==180){
			for (int i = 0; i < charMat.length; i++) {
				for (int j = 0; j < charMat.length; j++) {
					if(charMat[i][j]!=charMat[n-i][n-j])
						count++;
				}
			}
		}
		else if(angle==270){
			//col wise check
			for (int i = 0; i < charMat.length; i++) {
				for (int j = 0; j < charMat.length; j++) {
					if(charMat[i][j]!=charMat[n-i][j])
						count++;
				}
			}
		}
		return count;
	}

	private static char[][] generateMatrix(int n, char[][] c) {
		char charMat[][]=new char[n][n];
		if(charMat.length<=c.length)
		{
			for (int i = 0; i < charMat.length; i++) {
				for (int j = 0; j < charMat.length; j++) {
					charMat[i][j]=c[i][j];
				}	
			}
		}
		else{
			for (int i = 0; i < charMat.length; i++) {
				for (int j = 0; j < charMat.length; j++) {
					charMat[i][j]=c[i%7][j%7];
				}	
			}
		}
		return charMat;
	}

	
}

