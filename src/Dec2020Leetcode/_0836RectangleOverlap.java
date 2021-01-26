package Dec2020Leetcode;

public class _0836RectangleOverlap {
	public static void main(String[] args) {
		System.out.println(isRectangleOverlap(new int[] { 0, 0, 2, 2 }, new int[] { 1, 1, 3, 3 }));
		System.out.println(isRectangleOverlap(new int[] { 0, 0, 1, 1 }, new int[] { 1, 0, 2, 1 }));
		System.out.println(isRectangleOverlap(new int[] { 0, 0, 1, 1 }, new int[] { 2, 2, 3, 3, }));
	}

	public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // check if either rectangle is actually a line
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] ||
            rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            // the line cannot have positive overlap
            return false;
        }

        return !(rec1[2] <= rec2[0] ||   // left
                 rec1[3] <= rec2[1] ||   // bottom
                 rec1[0] >= rec2[2] ||   // right
                 rec1[1] >= rec2[3]);    // top
	}
}
