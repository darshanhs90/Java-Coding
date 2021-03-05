package FacebookPortalPrep;

public class _0007Strings_RotationalCipher {

	public static void main(String[] args) {
		System.out.println(rotationalCipher("Zebra-493?", 3));
		System.out.println(rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
	}

	public static String rotationalCipher(String input, int rotationFactor) {
		// Write your code here
		int numberRotation = rotationFactor % 10;
		int characterRotation = rotationFactor % 26;
		char[] cArr = input.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			if (Character.isDigit(c)) {
				c = (char) (((c - '0' + numberRotation) % 10) + '0');
			} else if (Character.isAlphabetic(c)) {
				if (Character.isLowerCase(c)) {
					c = (char) (((c - 'a' + characterRotation) % 26) + 'a');
				} else {
					c = (char) (((c - 'A' + characterRotation) % 26) + 'A');
				}
			}
			cArr[i] = c;
		}
		return new String(cArr);
	}
}
