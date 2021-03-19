package Feb2021Leetcode;

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
		List<int[]> out;

		public MyCalendar() {
			out = new ArrayList<int[]>();
		}

		public boolean book(int start, int end) {

			for (int i = 0; i < out.size(); i++) {
				int currStart = out.get(i)[0];
				int currEnd = out.get(i)[1];

				if (start>=currStart && start<currEnd)
					return false;
				
				if (end>currStart && end<=currEnd)
					return false;

			}

			out.add(new int[] { start, end });
			return true;
		}
	}

}
