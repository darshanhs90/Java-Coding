package May2021GoogLeetcode;

public class _0683KEmptySlots {

	// https://www.youtube.com/watch?v=ioKRhlQyPnU
	public static void main(String[] args) {
		System.out.println(kEmptySlots(new int[] { 1, 3, 2 }, 1));
		System.out.println(kEmptySlots(new int[] { 1, 2, 3 }, 1));
	}

	public static int kEmptySlots(int[] flowers, int k) {
		int[] pos = new int[flowers.length + 1];
		for (int i = 0; i < flowers.length; i++) {
			pos[flowers[i]] = i + 1;
		}

		int start = 1, end = k + 2;
		int res = Integer.MAX_VALUE;
		for (int i = 1; end <= flowers.length; i++) {
			if (pos[i] > pos[start] && pos[i] > pos[end])
				continue;

			if (i == end) {
				res = Math.min(res, Math.max(pos[start], pos[end]));
			}

			start = i;
			end = i + k + 1;
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

}
