package hackerEarth.BasicProgramming.StringManipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Link:https://www.hackerearth.com/problem/algorithm/terrible-chandu/
*/
public class _02TerribleChandu {
	  public static void main(String args[] ) throws Exception {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) {
	            System.out.println(new StringBuilder(br.readLine()).reverse().toString());
	        }

	    }
}
