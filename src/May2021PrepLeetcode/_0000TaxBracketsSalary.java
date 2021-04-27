package May2021PrepLeetcode;

public class _0000TaxBracketsSalary {
	// https://leetcode.com/discuss/interview-question/1170063/Facebook-Phone-Interview
	public static void main(String[] args) {
		System.out.println(isValidOrder(new String[] { "P1", "P2", "D1", "D2" }));// true
		System.out.println(isValidOrder(new String[] { "P1", "D2", "D1", "P2" }));// false
		System.out.println(isValidOrder(new String[] { "P1", "D2" }));// false
		System.out.println(isValidOrder(new String[] { "P1", "P2" }));// false
		System.out.println(isValidOrder(new String[] { "P1", "D1", "D1" }));// false
		System.out.println(isValidOrder(new String[] {}));// true
		System.out.println(isValidOrder(new String[] { "P1", "P1", "D1" }));// False
		System.out.println(isValidOrder(new String[] { "P1", "P1", "D1", "D1" }));// False
		System.out.println(isValidOrder(new String[] { "P1", "D1", "P1" }));// False
		System.out.println(isValidOrder(new String[] { "P1", "D1", "P1", "D1" }));// False
	}

	public static boolean isValidOrder(String[] strList) {

	}
}
