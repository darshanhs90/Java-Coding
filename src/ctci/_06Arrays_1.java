package ctci;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


/*Implementation of CTCI 1.1*/
public class _06Arrays_1 {
	public static void main(String args[]){
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=scanner.nextLine();
		scanner.close();
		System.out.println("Has Unique Characters Short : "+hasUniqueShort(inputString));
		System.out.println("Has Unique Characters Long : "+hasUniqueLong(inputString));

	}
	public static boolean hasUniqueShort(String inputString){
		HashMap<Character, Character> uniqueHashMap=new HashMap<Character, Character>();
		inputString= inputString.toLowerCase();
		for (int i = 0; i < inputString.length(); i++) {
			if(uniqueHashMap.put(inputString.charAt(i), inputString.charAt(i))!=null){
				return false;
			}
		}
		return true;
	}
	public static boolean hasUniqueLong(String inputString){
		inputString= inputString.toLowerCase();
		for (int i = 0; i < inputString.length(); i++) {
			for (int j = i+1; j < inputString.length(); j++) {
				if(inputString.charAt(i)==inputString.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
}
