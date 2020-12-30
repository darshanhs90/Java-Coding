package Dec2020Leetcode;

public class _0134GasStation {
	// https://www.youtube.com/watch?v=xWgbFI_rXJs
	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }));
		System.out.println(canCompleteCircuit(new int[] { 3, 1, 1 }, new int[] { 1, 2, 2 }));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int index = 0, total = 0, tank = 0;
		for (int i = 0; i < cost.length; i++) {
			int consumed = gas[i] - cost[i];
			tank += consumed;
			if (tank < 0) {
				index = i + 1;
				tank = 0;
			}
			total += consumed;
		}
		return total < 0 ? -1 : index;
	}
}
