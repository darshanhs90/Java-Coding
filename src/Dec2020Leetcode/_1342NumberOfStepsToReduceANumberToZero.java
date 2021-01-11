package Dec2020Leetcode;

public class _1342NumberOfStepsToReduceANumberToZero {
	public static void main(String[] args) {
		System.out.println(numberOfSteps(14));
		System.out.println(numberOfSteps(8));
		System.out.println(numberOfSteps(123));
	}

	public static int numberOfSteps(int num) {
		int steps = 0;
		while (num != 0) {
			if (num % 2 == 0)
				num /= 2;
			else {
				num -= 1;
			}
			steps++;
		}
		return steps;
	}
}
