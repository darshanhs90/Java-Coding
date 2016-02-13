package hackerEarth.BasicProgramming.BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Link:https://www.hackerearth.com/problem/algorithm/trailing-zeros/
*/public class _001TrailingZeros {
	public static void main(String args[] ) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int count=0;
		int value=5;
		while(N/value>=1)
		{
			count+=Math.floor(N/value);
			value*=5;
		}
		System.out.println(count);
	}
}
