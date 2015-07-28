package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _37makeItAnagram {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String firstLine=(scanner.readLine());
		String secondLine=(scanner.readLine());
        char[] chars = firstLine.toCharArray();
        Arrays.sort(chars);
        firstLine = new String(chars);
        chars = secondLine.toCharArray();
        Arrays.sort(chars);
        secondLine = new String(chars);
        
        System.out.println(firstLine);
        System.out.println(secondLine);
        //start comparison and count deletions
	}
}
