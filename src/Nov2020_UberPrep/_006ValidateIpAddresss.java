package Nov2020_UberPrep;

public class _006ValidateIpAddresss {

	public static void main(String[] args) {
		System.out.println(validIPAddress("172.16.254.1"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("256.256.256.256"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
		System.out.println(validIPAddress("1e1.4.5.6"));
	}

	public static String validIPAddress(String IP) {
		String[] parts = IP.split("\\.");
		if (parts.length != 4) {
			parts = IP.split(":");
			if (parts.length == 8 && IP.charAt(IP.length() - 1) != ':') {

				for (int i = 0; i < parts.length; i++) {
					if (!isValidIPV6(parts[i]))
						return "Neither";
				}

				return "IPv6";
			}
		} else if (parts.length == 4) {
			for (int i = 0; i < parts.length; i++) {
				if (!isValidIPV4(parts[i]))
					return "Neither";
			}
			if (IP.charAt(IP.length() - 1) == '.')
				return "Neither";
			return "IPv4";
		}
		return "Neither";
	}

	public static boolean isValidIPV4(String str) {
		if (str.length() >= 1 && str.length() <= 3) {
			if (str.length() > 1 && str.charAt(0) == '0')
				return false;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c >= '0' && c <= '9') {
					continue;
				} else {
					return false;
				}
			}

			if (Integer.parseInt(str) > 255)
				return false;

		} else {
			return false;
		}
		return true;
	}

	public static boolean isValidIPV6(String str) {
		if (str.length() >= 1 && str.length() <= 4) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F') {
					continue;
				} else {
					return false;
				}
			}

		} else {
			return false;
		}
		return true;
	}

}
