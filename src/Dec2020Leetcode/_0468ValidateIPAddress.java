package Dec2020Leetcode;

public class _0468ValidateIPAddress {

	public static void main(String[] args) {
		System.out.println(validIPAddress("172.16.254.1"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("256.256.256.256"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
		System.out.println(validIPAddress("1e1.4.5.6"));
	}

	public static String validIPAddress(String IP) {
		String parts[] = IP.split("\\.");
		if (parts.length == 1) {
			parts = IP.split(":");
			if (parts.length == 8 && IP.charAt(IP.length() - 1) != ':' && isValidIPV6(parts)) {
				return "IPv6";
			}
		} else if (parts.length == 4 && IP.charAt(IP.length() - 1) != '.' && isValidIPV4(parts)) {
			return "IPv4";
		}
		return "Neither";
	}

	public static boolean isValidIPV6(String[] parts) {
		for (String part : parts) {
			if (part.length() < 1 || part.length() > 4)
				return false;
			for (int i = 0; i < part.length(); i++) {
				char c = part.charAt(i);
				if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))
					continue;
				else
					return false;
			}
		}
		return true;
	}

	public static boolean isValidIPV4(String[] parts) {
		for (String part : parts) {
			if (part.length() < 1 || part.length() > 3 || part.length() > 1 && part.charAt(0) == '0')
				return false;
			for (int i = 0; i < part.length(); i++) {
				char c = part.charAt(i);
				if (c >= '0' && c <= '9')
					continue;
				else
					return false;
			}
			if (Integer.parseInt(part) > 255)
				return false;
		}
		return true;
	}

}
