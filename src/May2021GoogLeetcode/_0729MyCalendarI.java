package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0729MyCalendarI {
	public static void main(String[] args) {
		MyCalendar myCalendar = new MyCalendar();
		System.out.println(myCalendar.book(10, 20)); // returns true
		System.out.println(myCalendar.book(15, 25)); // returns false
		System.out.println(myCalendar.book(20, 30)); // returns true
	}

	static class MyCalendar {
		List<int[]> merged;

		public MyCalendar() {
			merged = new ArrayList<int[]>();
		}

		public boolean book(int start, int end) {
			if (!contains(start, end)) {
				merge(start, end);
				return true;
			}
			return false;
		}

		public boolean contains(int start, int end) {
			for (int i = 0; i < merged.size(); i++) {
				int[] arr = merged.get(i);
				int currStart = arr[0];
				int currEnd = arr[1];

				if (start >= currStart && start < currEnd)
					return true;

				if (end > currStart && end <= currEnd)
					return true;
			}
			return false;
		}

		public void merge(int start, int end) {
			merged.add(new int[] { start, end });
		}
	}

}
