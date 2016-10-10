package PracticeLeetCode;

public class _242ValidAnagram {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rzt", "car"));
	}
	public static boolean isAnagram(String s, String t) {
		if(s==null && t==null||(s.length()==0 && t.length()==0))
			return true;
		if(s==null||t==null||s.length()!=t.length())
			return false;
		char[] c1=new char[26];
		char[] c2=new char[26];
		for (int i = 0; i < s.length(); i++) {
			c1[s.charAt(i)-'a']++;
			c2[t.charAt(i)-'a']++;
		}
		return new String(c1).equals(new String(c2));
	}
}
