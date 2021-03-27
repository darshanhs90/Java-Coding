package Mar2021Leetcode;

public class _0065ValidNumber {

	public static void main(String[] args) {
		System.out.println(isNumber("0"));// T
		System.out.println(isNumber("e"));// F
		System.out.println(isNumber("."));// F
		System.out.println(isNumber(".1"));// T
		System.out.println(isNumber("2"));// T
		System.out.println(isNumber("0089"));// T
		System.out.println(isNumber("-0.1"));// T
		System.out.println(isNumber("+3.14"));// T
		System.out.println(isNumber("4."));// T
		System.out.println(isNumber("-.9"));// T
		System.out.println(isNumber("2e10"));// T
		System.out.println(isNumber("-90E3"));// T
		System.out.println(isNumber("3e+7"));// T
		System.out.println(isNumber("+6e-1"));// T
		System.out.println(isNumber("53.5e93"));// T
		System.out.println(isNumber("-123.456e789"));// T

		System.out.println(isNumber("abc"));// f
		System.out.println(isNumber("1a"));// F
		System.out.println(isNumber("1e"));// F
		System.out.println(isNumber("e3"));// F
		System.out.println(isNumber("99e2.5"));// F
		System.out.println(isNumber("--6"));// F
		System.out.println(isNumber("-+3"));// F
		System.out.println(isNumber("95a54e53"));// F
	}

	public static boolean isNumber(String s) {
		boolean hasNumberBefore = false, hasNumberAfter = false, dotFound = false, eFound = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				hasNumberAfter = true;
				hasNumberBefore = true;
			} else if (c == '+' || c == '-') {
				if(i!=0  && s.charAt(i-1)!='e')
					return false;
			} else if (c == 'e' || c == 'E') {
				if(eFound||!hasNumberBefore)
					return false;
				eFound = true;
				hasNumberAfter = false;
			} else if (c == '.') {
				if (dotFound || eFound)
					return false;
				dotFound = true;
			} else {
				return false;
			}
		}
		return hasNumberAfter && hasNumberBefore;
	}
}
