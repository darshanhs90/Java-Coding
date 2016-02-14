package hackerEarth.BasicProgramming.StringManipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Link:https://www.hackerearth.com/problem/algorithm/upup/
 */
public class _06UpUp {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineArr[] = br.readLine().split(" ");
        for(int i=0;i<lineArr.length;i++){
        	if(lineArr[i].length()>0 && (lineArr[i].charAt(0)+"").matches("[a-z]"))
        	{
        		System.out.print((lineArr[i].charAt(0)+"").toUpperCase()+""+lineArr[i].substring(1)+" ");
        	}
        	else
        		System.out.print(lineArr[i]+" ");
        }
    }
}
