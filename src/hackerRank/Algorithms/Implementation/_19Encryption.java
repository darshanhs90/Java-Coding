package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/encryption
 */
public class _19Encryption {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputText=scanner.nextLine();
		inputText=inputText.replaceAll(" ","");
		int L=inputText.length();
		int floorL=(int)Math.floor(Math.sqrt(L));
		int ceilL=(int)Math.ceil(Math.sqrt(L));
		int rows=0;
		int cols=0;
		int min=Integer.MAX_VALUE;
		boolean rowIncreased=false,colIncreased=false;
		for (int i = floorL; i <=ceilL; i++) {
			for (int j =floorL; j <=ceilL; j++) {
				if(i*j>=L && (i*j)<min)
				{
					rows=i;
					cols=j;
					min=i*j;
				}
			}
		}
		char inputArray[][]=new char[rows][cols];
		int counter=0;
		for (int i = 0; i < rows; i++) {
			Arrays.fill(inputArray[i],' ');
			for (int j = 0; j < cols; j++) {
				if(counter<L)
					inputArray[i][j]=inputText.charAt(counter);
				counter++;
			}
		}


		for (int i = 0; i < cols; i++) {
			StringBuilder sb=new StringBuilder("");
			for (int j = 0; j < rows; j++) {
				if(inputArray[j][i]!=' '){
					sb.append(inputArray[j][i]);
				}
			}
			System.out.print(sb.toString()+" ");
		}
	}
}
