package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13taumAndBday {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(scanner.readLine());
		for (int noOfTestCases = 0; noOfTestCases < T; noOfTestCases++) {
			String flArray[]=scanner.readLine().split(" ");
			int noOfBlackGifts=Integer.parseInt(flArray[0]);
			int noOfWhiteGifts=Integer.parseInt(flArray[1]);
			String slArray[]=scanner.readLine().split(" ");
			int costOfBlackGift=Integer.parseInt(slArray[0]);
			int costOfWhiteGift=Integer.parseInt(slArray[1]);
			int costOfConversion=Integer.parseInt(slArray[2]);
			if(costOfBlackGift>(costOfWhiteGift+costOfConversion))
			{
				//convert white to black and buy black directly
			}
			else if(costOfWhiteGift>(costOfBlackGift+costOfConversion))
			{
				//convert black to white and buy white directly
			}
			else{
				//but directly
			}
			
		}
	}
}
