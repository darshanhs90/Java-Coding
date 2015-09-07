package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-34/
 * Given a string, find the longest sinusoidal sequence in it.
 * If there are multiple such sequences of same maximum length,
 * return the one which comes first in lexicographic order in a dictionary..
 * Sinusoidal means increasing then decreasing then increasing and so on.
 * Example ::
 * a r u n ::
 * a u n , a r n , r u n are three such sequences of length 3.
 * But, a r n is output since it comes first in lexicographic order.
 */;
 public class _01AmazonInterview_34_04 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString=scanner.nextLine();
		 scanner.close();
		 System.out.println(findSinusoidalSequence(inputString));
	 }

	 private static String findSinusoidalSequence(String inputString) {
		 int maxLength=0;
		 String outputString="";
		 char c=inputString.charAt(0);
		 int length=1;
		 boolean upFlag=false,downFlag=false;
		 StringBuffer sb=new StringBuffer();
		 sb.append(c);
		 for (int i = 1; i < inputString.length(); i++) {
			 if(upFlag)
			 {
				 if(inputString.charAt(i)<c){
					 downFlag=true;
					 upFlag=false;
					 length++;
					 sb.append(inputString.charAt(i));
				 }
				 else{
					 if(length>maxLength){
						 outputString=sb.toString();
						 maxLength=length;
					 }
					 sb=new StringBuffer();
					 length=1;
					 upFlag=false;
					 downFlag=false;
				 }
			 }
			 else if(downFlag){
				 if(inputString.charAt(i)>c){
					 downFlag=false;
					 upFlag=true;
					 length++;
					 sb.append(inputString.charAt(i));
				 }
				 else{
					 if(length>maxLength){
						 outputString=sb.toString();
						 maxLength=length;
					 }
					 length=1;
					 sb=new StringBuffer();
					 upFlag=false;
					 downFlag=false;
				 }
			 }
			 else{
				 if(inputString.charAt(i)>c){
					 upFlag=true;
					 length++;
					 sb.append(inputString.charAt(i));
				 }
				 else{
					 downFlag=true;
					 length++;
					 sb.append(inputString.charAt(i));
				 }
			 }
			 c=inputString.charAt(i);
		 }
		 return sb.toString().length()>0?sb.toString():outputString;
	 }
 }