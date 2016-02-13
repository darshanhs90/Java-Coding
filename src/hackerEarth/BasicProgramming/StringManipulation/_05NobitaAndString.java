package hackerEarth.BasicProgramming.StringManipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * Link:https://www.hackerearth.com/problem/algorithm/nobita-and-string-4/
 */
public class _05NobitaAndString {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
		*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	String str[]=br.readLine().split(" ");
            for(int j=str.length-1;j>=0;j--){
            	System.out.print(str[j]+" ");
            }
            System.out.println("");
        }
       
    }
}
