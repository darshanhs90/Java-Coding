package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5alternatingCharacters {
	public static void main(String[] args)  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			Integer noOfTestCases=Integer.parseInt(br.readLine());
			String str="";
			for (int i = 0; i < noOfTestCases; i++) {
				str=br.readLine();
				Character c=new Character(' '); 
				int deletions=0;
				c=str.charAt(0);
				Character c1=new Character(' '); 
				for (int j = 1; j < str.length(); j++) {
					c1=str.charAt(j);
					if(c1==c){
						deletions++;
					}
					else{
						c=c1;
					}
				}
				System.out.println(deletions);
			}

		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
