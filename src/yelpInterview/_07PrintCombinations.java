package yelpInterview;

/*
 * Link:https://www.careercup.com/question?id=5761652767064064
 */
public class _07PrintCombinations {


	public static void main(String a[]){
		printComb("","0ab");
		printComb("","ab1cs");
	}

	public static void printComb(String prefix,String str) {
		if (str.length() == 0) {
			System.out.println(prefix);
			return;
		}
		if (Character.isAlphabetic(str.charAt(0))) {
			printComb(prefix+str.substring(0,1).toLowerCase(),str.substring(1));
			printComb(prefix+str.substring(0,1).toUpperCase(),str.substring(1));
		}
		else
			printComb(prefix+str.substring(0,1),str.substring(1));
	}
}






