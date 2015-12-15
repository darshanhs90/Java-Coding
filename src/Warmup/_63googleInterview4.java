package Warmup;

public class _63googleInterview4 {

	public static void main(String[] args) {
		//find if 2 sequences match
		//lord->helloworld-true
		//lorde->helloworld-false
		String str1="lord";//lorde
		String str2="helloworld";	
		System.out.println(checkString(str1,str2));

	}

	private static boolean checkString(String str1, String str2) {
		int index=0;
		for (int i = 0; i < str2.length(); i++) {
			if(str2.charAt(i)==str1.charAt(index)){
				index++;
			}
			if(index==str1.length())
				return true;
		}
		return false;
	}
}
