package May2021GoogLeetcode;

import java.util.Stack;

public class _0085MaximalRectangle {

	public static void main(String[] args) {
		System.out.println(maximalRectangle(
				new char[][] { new char[] { '1', '0', '1', '0', '0' }, new char[] { '1', '0', '1', '1', '1' },
						new char[] { '1', '1', '1', '1', '1' }, new char[] { '1', '0', '0', '1', '0' }, }));

		System.out.println(maximalRectangle(new char[][] {}));

		System.out.println(maximalRectangle(new char[][] { new char[] { '0' } }));

		System.out.println(maximalRectangle(new char[][] { new char[] { '1' } }));

		System.out.println(maximalRectangle(new char[][] { new char[] { '0', '0' } }));

		System.out.println(maximalRectangle(new char[][] { new char[] { '0', '1' } }));
	}

	public static int maximalRectangle(char[][] matrix) {
		
	}

}
