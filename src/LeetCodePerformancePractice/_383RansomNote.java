package LeetCodePerformancePractice;

public class _383RansomNote {
	public static void main(String[] args) {
		System.out.println(canConstruct("a", "z"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}
	public static boolean canConstruct(String ransomNote, String magazine) {
		char c[]=new char[26];
		for (int i = 0; i < magazine.length(); i++) {
			c[magazine.charAt(i)-97]++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if(c[ransomNote.charAt(i)-97]<=0)
				return false;
			else
				c[ransomNote.charAt(i)-97]--;
		}
		return true;
	}
}
