package June2021GoogLeetcode;

import java.util.HashMap;

public class _0166FractionToRecurringDecimal {
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1, 2));
		System.out.println(fractionToDecimal(2, 1));
		System.out.println(fractionToDecimal(2, 3));
		System.out.println(fractionToDecimal(-1, -2147483648));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0)
			sb.append("-");

		long num = (long) Math.abs((long) numerator);
		long den = (long) Math.abs((long) denominator);

		sb.append(num / den);
		if (num % den == 0) {
			return sb.toString();
		}
		sb.append(".");
		num = num % den;
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(num, sb.length());
		while (num != 0) {
			num *= 10;

			sb.append(num / den);
			num = num % den;
			if (map.containsKey(num)) {
				sb.insert(map.get(num), "(");
				sb.append(")");
				return sb.toString();
			}

			map.put(num, sb.length());
		}
		return sb.toString();
	}

}
