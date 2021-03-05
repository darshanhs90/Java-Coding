package FacebookPortalPrep;

public class _0018Recursion_ChangeInAForeignCurrency {

	public static void main(String[] args) {
		System.out.println(canGetExactChange(94, new int[] { 5, 10, 25, 100, 200 }));
		System.out.println(canGetExactChange(75, new int[] { 4, 17, 29 }));
	}

	public static boolean canGetExactChange(int targetMoney, int[] denominations) {
		if (targetMoney < 0)
			return false;
		if (targetMoney == 0)
			return true;

		for (int i = 0; i < denominations.length; i++) {
			if (canGetExactChange(targetMoney - denominations[i], denominations))
				return true;
		}
		return false;
	}
}
