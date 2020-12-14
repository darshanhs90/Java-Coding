package Nov2020_GoogPrep;

public class _074StrobogrammaticNumber {

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
		System.out.println(isStrobogrammatic("88"));
		System.out.println(isStrobogrammatic("962"));
		System.out.println(isStrobogrammatic("1"));
		System.out.println(isStrobogrammatic("10"));
	}

	public static boolean isStrobogrammatic(String num) {
		if (num.length() == 1) {
			return num.charAt(0) == '0' || num.charAt(0) == '1' || num.charAt(0) == '8';
		}

		int left = 0, right = num.length() - 1;
		while (left <= right) {
			char leftChar = num.charAt(left);
			char rightChar = num.charAt(right);
			switch (leftChar) {
			case '0':
			case '1':
			case '8':
				if (leftChar != rightChar)
					return false;
				break;
			case '6':
				if (rightChar != '9')
					return false;
				break;
			case '9':
				if (rightChar != '6')
					return false;
				break;
			default:
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
