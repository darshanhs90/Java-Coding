package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class _15SherlockAndValidString {
		public static void main(String[] args) {
			Scanner scanner=new Scanner(new InputStreamReader(System.in));
			String inputString=scanner.nextLine().trim();
			int frequency[]=new int[26];
			int maxValue=0;
			for (int i = 0; i < inputString.length(); i++) {
				int c=(int)inputString.charAt(i)-97;
				frequency[c]++;
				if(frequency[c]>maxValue)
					maxValue=frequency[c];
			}
			int nonMaxValue=0,maxCount=0,nonMaxPosCount=0,nonMaxNegCount=0;
			boolean oneDetected=false;
			for (int i = 0; i < frequency.length; i++) {
				int value=frequency[i];
				if(value!=0)
				{
					if(value==maxValue)
						maxCount++;
					else if(value==maxValue-1)
						nonMaxNegCount++;
					else if(value==maxValue+1)
						nonMaxPosCount++;
					else if(value==1 && !oneDetected)
					{
						oneDetected=true;
					}
					else
					{
						System.out.println("NO");
						System.exit(0);
					}
					if(nonMaxPosCount>0 && nonMaxNegCount>0){
						System.out.println("NO");
						System.exit(0);
					}
				}
			}
			if(Math.abs(nonMaxPosCount-maxCount)==1)
				System.out.println("YES");
			else if(Math.abs(nonMaxNegCount-maxCount)==1)
				System.out.println("YES");
			else if(nonMaxNegCount==0 && nonMaxPosCount==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

}
