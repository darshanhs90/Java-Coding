package PracticeLeetCode;

public class _344ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseString(""));
		System.out.println(reverseString("asd"));
	}
	public static String reverseString(String s) {
		if(s==null||s.length()==0)
			return s;
		return reverseString(s.substring(1))+s.charAt(0);
		//        return s!=null?new StringBuilder(s).reverse().toString():s;
	}
}
