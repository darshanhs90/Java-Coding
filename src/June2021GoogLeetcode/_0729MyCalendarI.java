package June2021GoogLeetcode;

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
		List<int[]> list;

		public MyCalendar() {
			list = new ArrayList<int[]>();
		}

		public boolean book(int start, int end) {
			if (list.isEmpty()) {
				list.add(new int[] { start, end });
				return true;
			} else {
				for (int i = 0; i < list.size(); i++) {
					int currStart = list.get(i)[0];
					int currEnd = list.get(i)[1];

					if (start >= currStart && start <= currEnd)
						return false;
					if (end >= currStart && end <= currEnd)
						return false;
				}

				list.add(new int[] { start, end });
				return true;
			}
		}
	}

}
