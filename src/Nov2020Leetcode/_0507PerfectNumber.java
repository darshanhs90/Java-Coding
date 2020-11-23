package Nov2020Leetcode;

public class _0507PerfectNumber {

	public static void main(String[] args) {
		System.out.println(checkPerfectNumber(28));
		System.out.println(checkPerfectNumber(6));
		System.out.println(checkPerfectNumber(496));
		System.out.println(checkPerfectNumber(8128));
		System.out.println(checkPerfectNumber(2));
	}

	public static boolean checkPerfectNumber(int num) {
		if (num % 2 != 0)
			return false;
		int sum = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return num == sum;
	}
}
