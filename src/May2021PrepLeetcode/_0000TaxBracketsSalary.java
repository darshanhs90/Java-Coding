package May2021PrepLeetcode;

import java.util.TreeMap;

public class _0000TaxBracketsSalary {
	// https://leetcode.com/discuss/interview-question/1170063/Facebook-Phone-Interview
	public static void main(String[] args) {
		System.out.println(calculateTaxes(55000) == 12000);
	}

	public static float calculateTaxes(int income) {
		TreeMap<Integer, Double> map = new TreeMap<Integer, Double>();
		map.put(5000, 0.0);
		map.put(10000, 0.1);
		map.put(20000, 0.2);
		map.put(10000, 0.3);
		map.put(10000000, 0.4);
	}
}
