package eBayPrep;

public class _205IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("add", "egg"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("ab", "ba"));
		System.out.println(isIsomorphic("13", "42"));

	}
	public static boolean isIsomorphic(String s, String t) {
		int[] str1Array=new int[127];
		int[] str2Array=new int[127];
		if(s.length()!=t.length())
			return false;
		for (int i = 0; i < s.length(); i++) {
			str1Array[s.charAt(i)]++;
			str2Array[t.charAt(i)]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if(str1Array[s.charAt(i)]!=str2Array[t.charAt(i)])
				return false;
			else{
				str1Array[s.charAt(i)]--;
				str2Array[t.charAt(i)]--;
			}
		}
		return true;
	}
}

