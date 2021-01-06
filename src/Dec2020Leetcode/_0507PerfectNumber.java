package Dec2020Leetcode;

public class _0507PerfectNumber {

	public static void main(String[] args) {
		System.out.println(checkPerfectNumber(28));
		System.out.println(checkPerfectNumber(6));
		System.out.println(checkPerfectNumber(496));
		System.out.println(checkPerfectNumber(8128));
		System.out.println(checkPerfectNumber(2));
		System.out.println(checkPerfectNumber(120));
	}

	public static boolean checkPerfectNumber(int num) {
		int count = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0)
				count += i;
		}
		return count == num;
	}

}
