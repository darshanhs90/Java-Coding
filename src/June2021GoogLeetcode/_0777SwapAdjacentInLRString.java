package June2021GoogLeetcode;

public class _0777SwapAdjacentInLRString {
	public static void main(String[] args) {
		System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
		System.out.println(canTransform("X", "L"));
		System.out.println(canTransform("LLR", "RRL"));
		System.out.println(canTransform("XL", "LX"));
		System.out.println(canTransform("XLLR", "LXLX"));
	}

	public static boolean canTransform(String start, String end) {
		if (start.replaceAll("X", "").length() != end.replaceAll("X", "").length())
			return false;

		int index1 = 0, index2 = 0;
		while (index1 < start.length() || index2 < end.length()) {
			while (index1 < start.length() && start.charAt(index1) == 'X')
				index1++;
			while (index2 < end.length() && end.charAt(index2) == 'X')
				index2++;

			if (index1 == start.length() || index2 == end.length())
				break;

			if (start.charAt(index1) != end.charAt(index2))
				return false;

			if (start.charAt(index1) == 'L' && index1 < index2)
				return false;

			if (start.charAt(index2) == 'R' && index1 > index2)
				return false;

			index1++;
			index2++;
		}
		return index1 == index2;
	}
}
