package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _37makeItAnagram {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String firstLine=(scanner.readLine());
		String secondLine=(scanner.readLine());
		char[] chars = firstLine.toCharArray();
		Arrays.sort(chars);
		firstLine = new String(chars);
		chars = secondLine.toCharArray();
		Arrays.sort(chars);
		secondLine = new String(chars);

		StringBuilder firstString=new StringBuilder(firstLine);
		StringBuilder secondString=new StringBuilder(secondLine);
		

		int deletionCount=0;

		while(true){
			if(firstString.length()==0)
			{
				deletionCount+=secondString.length();
				System.out.println(deletionCount);
				System.exit(0);
			}
			if(secondString.length()==0)
			{
				deletionCount+=firstString.length();
				System.out.println(deletionCount);
				System.exit(0);
			}
			if(firstString.charAt(0)>secondString.charAt(0))
			{
				deletionCount++;
				secondString.deleteCharAt(0);
			}
			else if(firstString.charAt(0)<secondString.charAt(0))
			{
				deletionCount++;
				firstString.deleteCharAt(0);
			}
			else{
				firstString.deleteCharAt(0);
				secondString.deleteCharAt(0);
			}
		}
	}
}
