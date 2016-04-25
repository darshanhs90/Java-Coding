package yelpInterview;

import java.util.Arrays;
import java.util.HashSet;

public class _Matrix03PrintUniqueRows {
	public static void main(String a[]){
		int mat[][] = {{0, 1, 0, 0, 1},
					   {1, 0, 1, 1, 0},
					   {0, 1, 0, 0, 1},
					   {1, 0, 1, 0, 0}
		};
		printUniqueRows(mat);
	}

	private static void printUniqueRows(int[][] mat) {
		HashSet<String> str=new HashSet<>();
		for (int i = 0; i < mat.length; i++) {
			StringBuilder sb=new StringBuilder();
			for (int j = 0; j < mat[0].length; j++) {
				sb.append(mat[i][j]);
			}
			
			if(!str.contains(sb.toString())){
				System.out.println(Arrays.toString(mat[i]));
				str.add(sb.toString());
			}
		}
	}





}