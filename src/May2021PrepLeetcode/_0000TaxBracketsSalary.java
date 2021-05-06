package May2021PrepLeetcode;

import java.util.Iterator;
import java.util.TreeMap;

public class _0000TaxBracketsSalary {
	// https://leetcode.com/discuss/interview-question/1170063/Facebook-Phone-Interview
	public static void main(String[] args) {
		System.out.println(calculateTaxes(55000));
	}

	public static float calculateTaxes(int income) {
		TreeMap<Integer, Double> map = new TreeMap<Integer, Double>();
		map.put(5000, 0.0);
		map.put(10000, 0.1);
		map.put(20000, 0.2);
		map.put(10001, 0.3);
		map.put(10000000, 0.4);

		Iterator<Integer> keys = map.keySet().iterator();
		int total = 0;
		while (income > 0 && keys.hasNext()) {
			int val = keys.next();
			if (!keys.hasNext()) {
				total += income * map.get(val);
				return total;
			}

			if (income >= val) {
				total += val * map.get(val);
				income -= val;
			} else {
				total += income * map.get(val);
				income -= val;
			}
		}
		return total;
	}
}
