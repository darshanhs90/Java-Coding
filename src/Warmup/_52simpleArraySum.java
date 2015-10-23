package Warmup;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link: https://www.hackerrank.com/challenges/simple-array-sum
*/	
public class _52simpleArraySum {


	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner scanner=new Scanner(new InputStreamReader(System.in));
	        int N=Integer.parseInt(scanner.nextLine());
	        String inputArray[]=(scanner.nextLine().split(" "));
	        int sum=0;
	        for(int i=0;i<inputArray.length;i++)
	        {
	            sum+=Integer.parseInt(inputArray[i]);
	        }
	        System.out.println(sum);
	    }
	
	
	
}
