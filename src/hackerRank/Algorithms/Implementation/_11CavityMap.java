package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/cavity-map
 */
public class _11CavityMap {

	   public static void main(String ards[])
		{
			Scanner scanner=new Scanner(new InputStreamReader(System.in));
			int n=Integer.parseInt(scanner.nextLine());
			int[][] inputArray=new int[n][n];
			for (int i = 0; i < n; i++) {
				String line=scanner.nextLine();
				for (int j = 0; j < line.length(); j++) {
					inputArray[i][j]=Integer.parseInt(line.charAt(j)+"");
				}
			}
			for (int i = 0; i < inputArray.length; i++) {
				StringBuilder sb=new StringBuilder("");
				for (int j = 0; j < inputArray.length; j++) {
					if(i==0||i==n-1||j==0||j==n-1)
					{
						sb.append(inputArray[i][j]);
					}
					else{
						if(inputArray[i][j]>inputArray[i-1][j]
								&& inputArray[i][j]>inputArray[i+1][j]
									&& inputArray[i][j]>inputArray[i][j-1]
										&& inputArray[i][j]>inputArray[i][j+1])
						{
							sb.append("X");
						}
						else{
							sb.append(inputArray[i][j]);
						}
					}
				}
				System.out.println(sb.toString());
			}
		}
}
