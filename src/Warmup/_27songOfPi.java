package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _27songOfPi {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.readLine());
		String pi="31415926535897932384626433833";
		for (int i = 0; i < noOfTestCases; i++) {
			String song=scanner.readLine();
			String songArray[]=song.split(" ");
			String outputString="";
			for (int j = 0; j < songArray.length; j++) {
				outputString+=songArray[j].length();
			}
			if(pi.startsWith(outputString)){
				System.out.println("It's a pi song.");
			}
			else{
				System.out.println("It's not a pi song.");
			}
		}
	}
}
