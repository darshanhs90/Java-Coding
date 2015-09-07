package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-32/
 * http://www.careercup.com/question?id=12998667
 * Verify if the given password is valid/invalid; 
 * 1. must be 5-12 characters long 
 * 2. must contain atleast one number and one lowercase character 
 * 3. a sequence must not be followed by the same sequence
 * (like 123123qs is invalid, 123qs123 is valid)
 */;
 public class _01AmazonInterview_32_01 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String password=scanner.nextLine();
		 scanner.close();
		 System.out.println(verifyPassword(password));
	 }

	 private static boolean verifyPassword(String password) {
		 if(password.length()>4 && password.length()<13)
		 {
			 if(password.matches(".*\\d.*") && password.matches(".*[a-z].*")){
				 for (int i = 0; i < password.length(); i++) {
					 int counter=0;
					 for (int j = i; j < password.length(); j++) {
						 if((i+counter+1)>0 && (i+counter+1)<password.length()) 	
						 {
							 String startString=password.substring(i,i+counter+1);
							 if(((i+counter+1)>0 && (i+counter+1)<password.length())
									 &&	((i+counter+counter+2)>0 && (i+counter+counter+2)<=password.length()))
							 {	
								 String endString=password.substring(i+counter+1,i+counter+2+counter);
								 if(startString.contentEquals(endString))
									 return false;

							 }
						 }
						 counter++;
					 }
				 }
				 return true;
			 }
		 }
		 return false;
	 }
 }