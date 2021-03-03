package FacebookPrep;

import java.util.HashMap;

public class _0670MaximumSwap {

	public static void main(String[] args) {
		System.out.println(maximumSwap(2736));
		System.out.println(maximumSwap(9973));
	}

	public static int maximumSwap(int num) {
		String str = String.valueOf(num);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i) - '0', i);
		}

		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			int currNum = cArr[i] - '0';
			for (int j = 9; j >= 1; j--) {
				if (j > currNum && map.containsKey(j) && map.get(j) > i) {
					int newIndex = map.get(j);
					cArr[i] = (char) ((char) j + '0');
					cArr[newIndex] = (char) (currNum + '0');
					return Integer.parseInt(new String(cArr));
				}
			}
		}
		return num;
	}
}
