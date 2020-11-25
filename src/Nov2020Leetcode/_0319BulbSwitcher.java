package Nov2020Leetcode;

public class _0319BulbSwitcher {

	public static void main(String[] args) {
		System.out.println(bulbSwitch(3));
		System.out.println(bulbSwitch(0));
		System.out.println(bulbSwitch(1));

	}

	public static int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}

}
