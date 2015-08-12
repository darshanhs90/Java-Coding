package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.hackerrank.com/challenges/insertionsort1
public class _47insertionSortPart1 {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int s=Integer.parseInt(scanner.readLine());
		String inputLine=scanner.readLine();
		String inputArray[]=inputLine.split(" ");
		String modifiedArray[]=inputLine.split(" ");

		int rightPositionElement=Integer.parseInt(inputArray[inputArray.length-1]);
		int positionCheck=inputArray.length-2;
		int previousElement=0,presentElement=Integer.parseInt(inputArray[positionCheck]);
		int index=-1;
		for (int i = modifiedArray.length-2; i >=0; i--) {
			presentElement=Integer.parseInt(inputArray[i]);
			if(previousElement!=presentElement){
				if(presentElement>rightPositionElement)
				{
					for (int j = 0; j < modifiedArray.length; j++) {
						if(Integer.parseInt(inputArray[j])==presentElement)
							modifiedArray[j+1]=(inputArray[j]);
					}
					for (int j = 0; j < modifiedArray.length; j++) {
						System.out.print(modifiedArray[j]+" ");
					}
					System.out.println();
				}
				else
				{
					index=i;
					break;
				}
			}
				//System.out.println(inputArray[i]);
			previousElement=presentElement;
		}
		modifiedArray[index+1]=rightPositionElement+"";
		for (int j = 0; j < modifiedArray.length; j++) {
			System.out.print(modifiedArray[j]+" ");
		}
		
	}
}
