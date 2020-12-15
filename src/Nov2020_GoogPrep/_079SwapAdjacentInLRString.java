package Nov2020_GoogPrep;

public class _079SwapAdjacentInLRString {

	public static void main(String[] args) {
		System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
		System.out.println(canTransform("X", "L"));
		System.out.println(canTransform("LLR", "RRL"));
		System.out.println(canTransform("XL", "LX"));
		System.out.println(canTransform("XLLR", "LXLX"));
		System.out.println(canTransform("XXXXLXXXXX", "LXXXXXXXXX"));
	}

	public static boolean canTransform(String start, String end) {
		if (!start.replace("X", "").equals(end.replace("X", "")))
			return false;

		int index = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) == 'L') {

				while (index < end.length() && end.charAt(index) != 'L') {
					index++;
				}

				if (i < index++)
					return false;
			}
		}

		index = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) == 'R') {

				while (index < end.length() && end.charAt(index) != 'R') {
					index++;
				}

				if (i > index++)
					return false;
			}
		}

		return true;
	}
}
