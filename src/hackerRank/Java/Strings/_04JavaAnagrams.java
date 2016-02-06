package hackerRank.Java.Strings;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-anagrams
 */

public class _04JavaAnagrams {

	  static boolean isAnagram(String A, String B) {
	      char aArray[]=A.toLowerCase().toCharArray();
	      Arrays.sort(aArray);
	      char bArray[]=B.toLowerCase().toCharArray();
	      Arrays.sort(bArray);
	      if(new String(aArray).contentEquals(new String(bArray)))
	    	  return true;
	      return false;
	   }
	    public static void main(String[] args) {
	        
	        Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        String B=sc.next();
	        boolean ret=isAnagram(A,B);
	        if(ret)System.out.println("Anagrams");
	        else System.out.println("Not Anagrams");
	        
	    }
}
