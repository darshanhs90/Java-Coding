package yelpInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _Matrix10FindCommonElement {
	public static void main(String a[]){
		int mat[][]={ {1, 2, 3, 4, 5},
				{2, 4, 5, 8, 10},
				{3, 5, 7, 9, 11},
				{1, 3, 5, 7, 9},
		};
		System.out.println(findCommonElement(mat));
	}

	private static int findCommonElement(int[][] mat) {
		HashMap<Integer, Integer> map=new HashMap<>();
		for (int i = 0; i < mat.length; i++) {
			HashSet<Integer> set=new HashSet<>();
			for (int j = 0; j < mat[0].length; j++) {
				if(!set.contains(mat[i][j]))
				{	
					set.add(mat[i][j]);
					if(i==0)
					{
						map.put(mat[i][j], 1);
					}
					else{
						if(map.containsKey(mat[i][j]))
							map.put(mat[i][j], map.get(mat[i][j])+1);
					}
				}
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			if(entry.getValue()==mat.length)
				return entry.getKey();
		}
		return -1;
	}




}