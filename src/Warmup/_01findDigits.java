package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01findDigits {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int noOfTests=Integer.parseInt(bufferedReader.readLine());
		String num[]=new String[noOfTests];
		//String count[]=new String[noOfTests];
		for (int i = 0; i < num.length; i++) {   
			//test comment
			int count1=0;
			num[i]=bufferedReader.readLine();
			for (int j = 0; j < num[i].length(); j++) {
				if(num[i].charAt(j)!='0'){
					if((Integer.parseInt(num[i])%Integer.parseInt(Character.toString(num[i].charAt(j))))==0){
						count1++;
					}
				}
			}
			System.out.println(count1);
		}
	}
}
