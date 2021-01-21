package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

			} else {
				if (overLaps(list, start, end))
					return false;
				list.add(new int[] { start, end });
				Collections.sort(list, new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						// TODO Auto-generated method stub
						return o1[0] - o2[0];
					}
				});
			}
			return true;
		}

		public boolean overLaps(List<int[]> list, int start, int end) {
			for (int[] interval : list) {
				int currStart = interval[0];
				int currEnd = interval[1];
				if (currStart < end && start < currEnd)
					return true;
				if (currStart > start)
					break;
			}
			return false;
		}
	}

}
