package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _38anagram {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.readLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String input=scanner.readLine();
			if(input.length()%2!=0)
			{
				System.out.println("-1");
			}
			else{
				String firstLine=input.substring(0, input.length()/2);
				String secondLine=input.substring(input.length()/2);
				char[] chars = firstLine.toCharArray();
				Arrays.sort(chars);
				StringBuilder firstPart = new StringBuilder(new String(chars));
				chars = secondLine.toCharArray();
				Arrays.sort(chars);
				StringBuilder secondPart = new StringBuilder(new String(chars));
				int counter=0;
				while(firstPart.length()!=0){
					String second=secondPart.toString();
					if(second.indexOf(firstPart.charAt(0))!=-1){
						secondPart.deleteCharAt(second.indexOf(firstPart.charAt(0)));
						firstPart.deleteCharAt(0);
					}
					else{
						firstPart.deleteCharAt(0);
						counter++;
					}
				}
				System.out.println(counter);
			}
		}
	}
}
