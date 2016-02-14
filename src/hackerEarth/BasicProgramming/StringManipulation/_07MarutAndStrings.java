package hackerEarth.BasicProgramming.StringManipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Link:https://www.hackerearth.com/problem/algorithm/upup/
 */
public class _07MarutAndStrings {
	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line.matches("[a-zA-Z]")){
        	System.out.println("Invalid Test");
        	System.exit(0);	
        }
        int N = Integer.parseInt(line);
        if(N<1 || N>10){
        	System.out.println("Invalid Test");
        	System.exit(0);	
        }
        for (int i = 0; i < N; i++) {
            String inputString=br.readLine();
        	int noOfLowerCase=0;
        	int noOfUpperCase=0;
			for(int j=0;j<inputString.length();j++){
        			if((inputString.charAt(j)+"").matches("[a-z]"))
        				noOfLowerCase++;
        			else if((inputString.charAt(j)+"").matches("[A-Z]"))
        				noOfUpperCase++;
        		}
        		if(noOfUpperCase==0 && noOfLowerCase==0 || inputString.length()>100)
        			System.out.println("Invalid Input");
        		else
	 				System.out.println(Math.min(noOfUpperCase,noOfLowerCase));
        		
        }
    }
}
