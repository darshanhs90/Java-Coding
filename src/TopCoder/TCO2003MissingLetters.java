package TopCoder;

/*
 * TCO 2003
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1610&rd=4700
 */



public class TCO2003MissingLetters {

	public static void main(String[] args) {
		System.out.println(getMissingLetters("A quick brown fox jumps over the lazy dog"));
		System.out.println(getMissingLetters("A slow yellow fox crawls under the proactive dog"));
		System.out.println(getMissingLetters("Lions, and tigers, and bears, oh my!"));
		System.out.println(getMissingLetters(""));

	}

	public static String getMissingLetters(String sentence){
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		sentence=sentence.toUpperCase();
		for (int i = 0; i < sentence.length(); i++) {
			str=str.replace(sentence.charAt(i), '0');
		}
		return str.replaceAll("0", "");
	}
}
