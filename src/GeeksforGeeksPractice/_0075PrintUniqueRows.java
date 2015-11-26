package GeeksforGeeksPractice;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Link : http://www.geeksforgeeks.org/print-unique-rows/
 */
public class _0075PrintUniqueRows {

	public static void main(String[] args) {
		int mat[][] = {{0, 1, 0, 0, 1},
				{1, 0, 1, 1, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 1, 0, 0}
		};

		findUniqueRows(mat);
	}

	private static void findUniqueRows(int[][] mat) {
		HashMap<String, Integer> rowMap=new HashMap<>();
		for (int i = 0; i < mat.length; i++) {
			String str=Arrays.toString(mat[i]).replace(",","").replace("[","").replace("]","").replaceAll(" ","");
			if(rowMap.containsKey(str))
				rowMap.put(str, 2);
			else
				rowMap.put(str, 1);
		}
		Object[] str=rowMap.keySet().toArray();
		for (int i = 0; i < str.length; i++) {
			if(rowMap.get(str[i])<2)
				System.out.println(str[i]);
		}
	}

}
