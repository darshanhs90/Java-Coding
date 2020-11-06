package Leetcode2020Nov;

public class _1342NumberOfStepsToReduceANumberToZero {
	public static void main(String[] args) {
		System.out.println(numberOfSteps(14));
		System.out.println(numberOfSteps(8));
		System.out.println(numberOfSteps(123));
	}

	public static int numberOfSteps(int num) {
		if (num == 0)
			return 0;
		if (num % 2 == 0) {
			return 1 + numberOfSteps(num / 2);
		} else {
			return 1 + numberOfSteps(num - 1);
		}
	}
}
