package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _0937ReorderDataInLogFiles {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(reorderLogFiles(
				new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" })));
	}

	static class Pair {
		String nonIdString;
		String fullString;
		String identifier;

		public Pair(String identifier, String nonIdString, String fullString) {
			this.nonIdString = nonIdString;
			this.fullString = fullString;
			this.identifier = identifier;
		}
	}

	public static String[] reorderLogFiles(String[] logs) {
		List<Pair> letterLogs = new ArrayList<Pair>();
		List<String> digitLogs = new ArrayList<String>();
		for (String log : logs) {
			String[] parts = log.split(" ");
			if (Character.isDigit(parts[1].charAt(0))) {
				digitLogs.add(log);
			} else {
				letterLogs.add(new Pair(parts[0], log.substring(parts[0].length()), log));
			}
		}

		Collections.sort(letterLogs, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				int val = o1.nonIdString.compareTo(o2.nonIdString);
				if (val == 0) {
					return o1.identifier.compareTo(o2.identifier);
				}
				return val;
			}
		});

		String[] output = new String[logs.length];
		int index = 0;
		for (int i = 0; i < letterLogs.size(); i++) {
			output[index] = letterLogs.get(i).fullString;
			index++;
		}
		for (int i = 0; i < digitLogs.size(); i++) {
			output[index] = digitLogs.get(i);
			index++;
		}
		return output;
	}
}
