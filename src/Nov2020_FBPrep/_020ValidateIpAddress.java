package Nov2020_FBPrep;

public class _020ValidateIpAddress {

	public static void main(String[] args) {
		System.out.println(validIPAddress("172.16.254.1"));
		System.out.println(validIPAddress("172.16.254.1."));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("256.256.256.256"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
		System.out.println(validIPAddress(":2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("1e1.4.5.6"));
	}

	public static String validIPAddress(String IP) {
		String[] parts = IP.split("\\.");
		if (parts.length == 4) {
			if (isValidIPv4(parts) && IP.charAt(IP.length() - 1) != '.')
				return "IPv4";
			return "Neither";
		} else {
			parts = IP.split(":");
			if (parts.length == 8) {
				if (isValidIPv6(parts) && IP.charAt(IP.length() - 1) != ':')
					return "IPv6";
				return "Neither";
			} else {
				return "Neither";
			}
		}
	}

	public static boolean isValidIPv4(String[] parts) {
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if (part.length() > 0 && part.length() <= 4) {

				try {
					int val = Integer.parseInt(part);
					if (val > 255)
						return false;
					if (part.length() > 1 && part.charAt(0) == '0')
						return false;
				} catch (Exception e) {
					return false;
				}

			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidIPv6(String[] parts) {
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if (part.length() > 0 && part.length() <= 4) {
				for (int j = 0; j < part.length(); j++) {
					char c = Character.toLowerCase(part.charAt(j));
					if (Character.isAlphabetic(c)) {
						if (c < 'a' || c > 'f')
							return false;
					} else if (!Character.isDigit(c)) {
						return false;
					}
				}

			} else {
				return false;
			}
		}
		return true;
	}
}
