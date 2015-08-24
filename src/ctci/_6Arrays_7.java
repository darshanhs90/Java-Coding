package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/*Implementation of CTCI 1.8*/
public class _6Arrays_7 {
	public static void main(String args[]){
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString1=scanner.nextLine();
		String inputString2=scanner.nextLine();
		System.out.println("Is "+inputString1 +" substring of "+inputString2+" ? "+isSubstring(inputString1,inputString1+inputString2));
		
		
	}

	private static boolean isSubstring(String inputString1, String inputString2) {
		for (int i = 0; i < inputString1.length(); i++) {
			String partialInputString1=inputString1.substring(i);
			if(inputString2.indexOf(partialInputString1)>0)
				return true;
		}
		return false;
	}

	


}
