package hackerEarth.BasicProgramming.StringManipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Link:https://www.hackerearth.com/problem/algorithm/karan-and-strings/
 */
public class _08KaranAndStrings {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
	*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
           String inputString=br.readLine();
           
           StringBuilder sb=new StringBuilder("");
           for(int j=0;j<inputString.length();j++){
           		if(sb.toString().length()==0){
           			sb.append(inputString.charAt(0)+"");
           		}
           		else{
           			if(sb.toString().charAt(sb.toString().length()-1)!=inputString.charAt(j))
           				sb.append(inputString.charAt(j)+"");
           		}
           }
           System.out.println(sb.toString());
        }

    }
}
