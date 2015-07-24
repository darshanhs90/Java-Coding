package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _31encryption {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String messageInput=scanner.readLine();
		int messageLength=messageInput.length();
		//		System.out.println(messageLength);
		double sqrtValue=Math.sqrt(messageLength);
		int floorRootValue=(int) Math.floor(sqrtValue);
		int ceilRootValue=(int) Math.ceil(sqrtValue);
		int rows=0,cols=0;
		rows=floorRootValue;
		cols=floorRootValue;
		while(cols*rows<messageLength)
		{
			if((cols+1)<=ceilRootValue)
				cols++;
			else if((rows+1)<=ceilRootValue)
				rows++;
			else
				break;
		}
		//change code for rows and cols
		String [][]gridArray=new String[rows][cols];
		int gridFilledLength=0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				gridArray[i][j]=messageInput.charAt(gridFilledLength)+"";
				//				System.out.println(i+"///"+j+"||character here is||"+gridArray[i][j]);
				gridFilledLength++;
				if(gridFilledLength==messageLength)
					break;
			}
		}

		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if(gridArray[j][i]!=null)
					System.out.print(gridArray[j][i]);
			}
			System.out.print(" ");
		}
	}
}
