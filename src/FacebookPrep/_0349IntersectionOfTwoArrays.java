package FacebookPrep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class _0349IntersectionOfTwoArrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> num1Set = new HashSet<Integer>();
		HashSet<Integer> num2Set = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			num1Set.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (num1Set.contains(nums2[i]) && !num2Set.contains(nums2[i]))
				num2Set.add(nums2[i]);
		}

		int[] out = new int[num2Set.size()];
		int index = 0;
		Iterator<Integer> iter = num2Set.iterator();
		while (iter.hasNext()) {
			out[index] = iter.next();
			index++;
		}
		return out;
	}
}
