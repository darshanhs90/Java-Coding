package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _00002GeneratePickupDelivery {
	public static void main(String[] args) {
		System.out.println(generate(1));
		System.out.println(generate(2));
		System.out.println(generate(3));
	}

	public static List<String> generate(int number) {
		int[] pickupDeliveryArr = new int[number];
		List<String> output = new ArrayList<String>();
		dfs(pickupDeliveryArr, new ArrayList<String>(), output);
		// System.out.println(output.size());
		return output;
	}

	public static void dfs(int[] pickupDeliveryArr, List<String> list, List<String> output) {
		if (list.size() == 2 * pickupDeliveryArr.length) {
			String str = String.join(",", list);
			output.add(str);
			return;
		}

		for (int i = 0; i < pickupDeliveryArr.length; i++) {
			if (pickupDeliveryArr[i] == 0) {
				pickupDeliveryArr[i] = 1;
				list.add("P" + i);
				dfs(pickupDeliveryArr, list, output);
				list.remove("P" + i);
				pickupDeliveryArr[i] = 0;
			}
		}
		for (int i = 0; i < pickupDeliveryArr.length; i++) {
			if (pickupDeliveryArr[i] == 1) {
				pickupDeliveryArr[i] = 2;
				list.add("D" + i);
				dfs(pickupDeliveryArr, list, output);
				list.remove("D" + i);
				pickupDeliveryArr[i] = 1;
			}
		}
	}
}
