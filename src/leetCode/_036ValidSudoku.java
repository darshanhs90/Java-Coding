package leetCode;

import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/valid-sudoku/
 */

public class _036ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		HashMap<Character, Integer> rowMap=new HashMap<>();
		HashMap<Integer, HashMap<Character, Integer>> columnMap=new HashMap<>();
		for (int i = 0; i < board[0].length; i++) {			
			rowMap=new HashMap<>();
			for (int j = 0; j < board.length; j++) {
				if(board[i][j]!='.'){
					if(rowMap.containsKey(board[i][j]))
						return false;
					else
						rowMap.put(board[i][j],1);				
					if(columnMap.containsKey(j))
					{
						if(columnMap.get(j).containsKey(board[i][j]))
							return false;
						else
							columnMap.get(j).put(board[i][j],1);
					}
					else{
						HashMap<Character,Integer> tempMap=new HashMap<>();
						tempMap.put(board[i][j],1);
						columnMap.put(j,tempMap);
					}
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			rowMap=new HashMap<>();
			for (int j = i / 3 * 3; j < i / 3 * 3 + 3; j++) {
				for (int k = i % 3 * 3; k < i % 3 * 3 + 3; k++) {
					if(board[j][k]!='.'){
						if(rowMap.containsKey(board[j][k])){
							System.out.println(i+"/"+j+"/"+k);
							return false;
						}
						else
							rowMap.put(board[j][k],1);
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char sudokuArray[][]=new char[][]
				{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'},
				};


				/*for (int i = 0; i < sudokuArray.length; i++) {
					System.out.println(Arrays.toString(sudokuArray[i]));
				}*/
				System.out.println(isValidSudoku(sudokuArray));


	}
}