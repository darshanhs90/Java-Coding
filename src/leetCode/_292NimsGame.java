package leetCode;

/*
 * Link : https://leetcode.com/problems/nim-game/
 */

public class _292NimsGame {
	public static boolean canWinNim(int n) {
		return n%4>0;
	}

	public static void main(String[] args) {
		System.out.println(canWinNim(6));
	}
}