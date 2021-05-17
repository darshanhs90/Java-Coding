package May2021Leetcode;

import java.util.Iterator;
import java.util.TreeMap;

public class _0000TaxBracketsSalary {
	// https://leetcode.com/discuss/interview-question/1170063/Facebook-Phone-Interview
	public static void main(String[] args) {
		System.out.println(calculateTaxes(55000));
	}

	public static double calculateTaxes(int income) {
		TreeMap<Integer, Double> map = new TreeMap<Integer, Double>();
		map.put(5000, 0.0);
		map.put(10000, 0.1);
		map.put(20000, 0.2);
		map.put(10001, 0.3);
		map.put(10000000, 0.4);
		double out = 0;
		Iterator<Integer> iter = map.keySet().iterator();
		while (iter.hasNext() && income > 0) {
			Integer val = iter.next();
			if (iter.hasNext()) {
				if (income <= val) {
					out += income * map.get(val);
					income = 0;
				} else {
					income = income - val;

					out += (val * map.get(val));
				}
			} else {
				out += income * map.get(val);
			}
		}
		return out;
	}
}
