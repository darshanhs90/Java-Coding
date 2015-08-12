package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _45palindromeIndex {
	public static void main(String[] args) throws Exception {

		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.readLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String input=scanner.readLine();
			StringBuffer sb=new StringBuffer(input);
			String reverseString=sb.reverse().toString();
			if(input.equals(reverseString)){
				System.out.println("-1");
			}
			else{
				for (int j = 0; j < input.length(); j++) {
					if(input.charAt(j)!=reverseString.charAt(j)){
						String inputStringSubstring=input.substring(0,j)+input.substring(j+1);
						String inputStringSubstringReverse=new StringBuffer(inputStringSubstring).reverse().toString();
//						String reverseStringSubstring=reverseString.substring(0,j)+input.substring(j+1);
//						String reverseStringSubstringReverse=new StringBuffer(reverseStringSubstring).reverse().toString();
						if(inputStringSubstring.equals(inputStringSubstringReverse)){
							System.out.println(j);
						}else{
							System.out.println(input.length()-1-j);
						}
						break;
					}
					continue;
				}
			}
		}
	}
}
