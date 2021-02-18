package Jan2021Leetcode;

import java.util.List;

public class _0281ZigZagIterator {

	public static void main(String[] args) {

	}

	public class ZigzagIterator {
		int l1Index, l2Index;
		List<Integer> l1, l2;
		boolean useL1;

		public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
			l1 = v1;
			l2 = v2;
			l1Index = 0;
			l2Index = 0;
			useL1 = true;
		}

		public int next() {
			int val = -1;
			if (useL1) {
				if (l1Index < l1.size()) {
					val = l1.get(l1Index);
					l1Index++;
				} else {
					val = l2.get(l2Index);
					l2Index++;
				}
			} else {
				if (l2Index < l2.size()) {
					val = l2.get(l2Index);
					l2Index++;
				} else {
					val = l1.get(l1Index);
					l1Index++;
				}
			}
			useL1 = !useL1;
			return val;
		}

		public boolean hasNext() {
			return l1Index < l1.size() || l2Index < l2.size();
		}
	}

}
