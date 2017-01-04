package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _386LexicographicalNumbers {
	public static void main(String[] args) {
		System.out.println(lexicalOrder(13));
	}
	public static List<Integer> lexicalOrder(int n) {
		List<Integer> list=new ArrayList<>();
		for (int i = 1; i <=n; i++) {
			list.add(i);
		}
		Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1+"").compareTo(o2+"");
			}
		});
		return list;
	}

}
