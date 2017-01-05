package PracticeLeetCode;

public class _383RansomNote {
	public static void main(String[] args) {
		System.out.println(canConstruct("a", "z"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		if(ransomNote==null||ransomNote.length()==0)
			return true;
		for (int i = 0; i < ransomNote.length(); i++) {
			char c=ransomNote.charAt(i);
			if(magazine.contains(c+""))
			{
				magazine=magazine.replaceFirst(c+"", "");
			}
			else{
				return false;
			}
		}
		return true;
	}

}
