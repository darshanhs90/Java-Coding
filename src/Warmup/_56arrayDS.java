package Warmup;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/arrays-ds 
 */	
public class _56arrayDS {


	  public static void main(String[] args) {
	        Scanner scanner=new Scanner(new InputStreamReader(System.in));
	        int N=Integer.parseInt(scanner.nextLine());
	        String inputArray[]=scanner.nextLine().split(" ");
	        scanner.close();
	        for(int i=N-1;i>=0;i--)
	        {
	        System.out.print(inputArray[i]+" ");    
	        }
	    }

}