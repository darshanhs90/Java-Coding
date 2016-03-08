package TopCoder;

/*
 * SRM 148 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1740&rd=4545
 */



public class SRM148CeyKaps {
	
	public static void main(String[] args) {
		System.out.println(decipher("AAAAA", new String[]{"A:B","B:C","A:D"}));
		System.out.println(decipher("ABCDE", new String[]{"A:B","B:C","C:D","D:E","E:A"}));
		System.out.println(decipher("IHWSIOTCHEDMYKEYCAPSARWUND", new String[]{"W:O","W:I"}));
		
	}
	public static String decipher(String typed, String[] switches){
		for (int i = 0; i < switches.length; i++) {
			String splitString[]=switches[i].split(":");
			typed=typed.replace(splitString[0], "-");
			typed=typed.replace(splitString[1],splitString[0]);
			typed=typed.replace("-",splitString[1]);
		}
		return typed;
	}
}
