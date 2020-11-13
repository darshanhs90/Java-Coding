package Leetcode2020Nov;

public class _1108DefangingAnIPAddress {
	public static void main(String[] args) {
		System.out.println(defangIPaddr("1.1.1.1"));
		System.out.println(defangIPaddr("255.100.50.0"));
	}

	public static String defangIPaddr(String address) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < address.length(); i++) {
			char c = address.charAt(i);
			if (c == '.') {
				sb = sb.append("[.]");
			} else {
				sb = sb.append(c);
			}
		}
		return sb.toString();
	}
}
