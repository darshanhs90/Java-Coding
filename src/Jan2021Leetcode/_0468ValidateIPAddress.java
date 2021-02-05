package Jan2021Leetcode;

public class _0468ValidateIPAddress {

	public static void main(String[] args) {
		System.out.println(validIPAddress("172.16.254.1"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("256.256.256.256"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
		System.out.println(validIPAddress("1e1.4.5.6"));
		System.out.println(validIPAddress("1.1.1.1."));
		System.out.println(validIPAddress("192.0.0.1"));
	}

	public static String validIPAddress(String IP) {
		String[] parts = IP.split("\\.");
		if (parts.length != 4) {
			parts = IP.split(":");
			if (parts.length == 8 && !IP.endsWith(":"))
				return checkIPV6(parts);
		} else {
			if (!IP.endsWith("."))
				return checkIPV4(parts);
		}
		return "Neither";
	}

	public static String checkIPV4(String[] parts) {
		System.out.println("Here");
		for (String part : parts) {
			if (part.length() < 1 || part.length() > 3)
				return "Neither";
			for (int i = 0; i < part.length(); i++) {
				char c = part.charAt(i);
				if (c < '0' || c > '9')
					return "Neither";
			}
			if (part.length() > 1 && part.charAt(0) == '0' || Integer.parseInt(part) > 255)
				return "Neither";
		}
		return "IPv4";
	}

	public static String checkIPV6(String[] parts) {
		for (String part : parts) {
			if (part.length() < 1 || part.length() > 4)
				return "Neither";
			for (int i = 0; i < part.length(); i++) {
				char c = part.charAt(i);
				if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')))
					return "Neither";
			}

		}
		return "IPv6";
	}

}
