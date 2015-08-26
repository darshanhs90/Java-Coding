package ctci;

import java.io.InputStreamReader;
import java.util.Scanner;


/*Implementation of CTCI 1.5*/
public class _06Arrays_4 {
	public static void main(String args[]){
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=scanner.nextLine();
		scanner.close();
		System.out.println(compressedString(inputString));
	}
	public static String compressedString(String inputString){
		String outputString="";
		char previousChar=' ';
		int previousCharCount=0;
		for (int i = 0; i < inputString.length(); i++) {
			char currentChar=inputString.charAt(i);
			if(currentChar!=previousChar)
			{
				if(previousChar!=' ')
					outputString+=previousCharCount;
				previousChar=currentChar;
				previousCharCount=1;
				outputString+=currentChar;
			}
			else{
				previousCharCount++;
			}
		}
		outputString+=previousCharCount;
		if(outputString.length()>inputString.length())
			return inputString;
		return outputString;
	}


}
