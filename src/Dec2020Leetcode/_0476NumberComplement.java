package Dec2020Leetcode;

public class _0476NumberComplement {

	public static void main(String[] args) {
		System.out.println(findComplement(5));
		System.out.println(findComplement(1));
	}

	public static int findComplement(int num) {
		String str = Integer.toString(num, 2);
		char cArr[] = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] == '1')
				cArr[i] = '0';
			else
				cArr[i] = '1';
		}
		return Integer.parseInt(new String(cArr),2);
	}

}
