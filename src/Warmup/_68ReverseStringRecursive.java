package Warmup;

public class _68ReverseStringRecursive {
	public static void main(String[] args) {
		String str="String";
		System.out.println(reverse(str));
	}

	private static String reverse(String str) {
		if(str.length()==0)
			return str;
		return reverse(str.substring(1))+str.charAt(0);
	}

}






