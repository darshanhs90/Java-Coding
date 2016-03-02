package hackerRank.Algorithms.BitManipulation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/xoring-ninja
 */
public class _06XoringNinja {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=scanner.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			int length=scanner.nextInt();
			int inputArray[]=new int[length];
			for (int j = 0; j < length; j++) {
				inputArray[j]=scanner.nextInt();
			}
			int output=inputArray[0];
			for (int j = 1; j < length; j++) {
				output=output|inputArray[j];
			}
			output=((output%(1000000000+7)));
			for (int j = 0; j < inputArray.length-1; j++) {
				output*=2;
			}
			System.out.println(output);
			//Power set code
			/*for(int k=1;k<Math.pow(2, length);k++){
				String str=Integer.toBinaryString(k);
				int tempOutput=0;
				while(str.length()<3){
					str="0"+str;
				}
				for (int j = 0; j < str.length(); j++) {
					if(str.charAt(j)=='1')
						tempOutput=tempOutput^inputArray[j];
				}
				output+=tempOutput;
			}*/
		}
	}
}
