package PracticeLeetCode;

public class _344ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseString(""));
		System.out.println(reverseString("asd"));
	}
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
