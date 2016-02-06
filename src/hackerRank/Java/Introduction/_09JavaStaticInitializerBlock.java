package hackerRank.Java.Introduction;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-static-initializer-block
 */

public class _09JavaStaticInitializerBlock {

	static boolean flag=true;  
	static int B,H;
	static{
	    Scanner scanner=new Scanner(System.in);
	    B=Integer.parseInt(scanner.nextLine());
	    H=Integer.parseInt(scanner.nextLine());
	    if(B<=0 || H<=0)
	    {
	        System.out.println("java.lang.Exception: Breadth and height must be positive");
	        flag=false;
	    }
	}
}
