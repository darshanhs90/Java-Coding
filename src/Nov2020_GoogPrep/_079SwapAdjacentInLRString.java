package Nov2020_GoogPrep;

public class _079SwapAdjacentInLRString {

	public static void main(String[] args) {
		System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
		System.out.println(canTransform("X", "L"));
		System.out.println(canTransform("LLR", "RRL"));
		System.out.println(canTransform("XL", "LX"));
		System.out.println(canTransform("XLLR", "LXLX"));
	}

	public static boolean canTransform(String start, String end) {

		for (int i = 0; i < start.length(); i++) {
			char c1 = start.charAt(i);
			char c2 = end.charAt(i);
			if (c1 != c2) {
				if ((i + 1) < start.length()) {
					String str1 = c1 + "" + start.charAt(i + 1);
					String str2 = c2 + "" + end.charAt(i + 1);
					if ((str1.equals("XL") && str2.equals("LX")) || (str1.equals("RX") && str2.equals("XR"))) {
						i += 1;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}x

		return true;
	}
}
