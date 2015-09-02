package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-13/
 * You will be given the number of pairs of parenthesis.
 * Find out the total possible valid unique combinations and there should not be any duplicity.
 */;
 public class _01AmazonInterview_13_03 {
	 static int counter=0;
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int noOfPairs=Integer.parseInt(scanner.nextLine());
         printParenthesis(noOfPairs);
         System.out.println(counter);
    }
    static void printParenthesis(int n){
       printParenthesis("",n,n);       
    }

    static void printParenthesis(String s,int open,int close){
        if(open>close)
           return;
        if(open == 0 && close == 0){
        	counter++;
            System.out.println(s);
            return;
        }
        if(open < 0 || close<0)
            return;

        printParenthesis(s + '(',open-1,close);
        printParenthesis(s + ')',open,close-1);
    }

 }