package LeetCodePractice;

import java.util.Arrays;
import java.util.List;

public class _120Triangle {


	public int minimumTotal(List<List<Integer>> triangle) {
		int sum=0;
		for (int i = 0; i < triangle.size(); i++) {
			List<Integer> list=triangle.get(i);
			Object arr[]=list.toArray();
			Arrays.sort(arr);
			sum+=(Integer)arr[0];
		}
		return sum;
	}
}

