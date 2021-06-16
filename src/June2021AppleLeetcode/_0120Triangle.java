package June2021AppleLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0120Triangle {
	public static void main(String[] args) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		out.add(new ArrayList<Integer>(Arrays.asList(2)));
		out.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
		out.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
		out.add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));
		System.out.println(minimumTotal(out));

		out = new ArrayList<List<Integer>>();
		out.add(new ArrayList<Integer>(Arrays.asList(-10)));
		System.out.println(minimumTotal(out));

	}

	public static int minimumTotal(List<List<Integer>> triangle) {

	}

}
