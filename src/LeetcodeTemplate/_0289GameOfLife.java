package LeetcodeTemplate;

public class _0289GameOfLife {

	public static void main(String[] args) {
		gameOfLife(new int[][] { new int[] { 0, 1, 0 }, new int[] { 0, 0, 1 }, new int[] { 1, 1, 1 },
				new int[] { 0, 0, 0 } });

		gameOfLife(new int[][] { new int[] { 1, 1 }, new int[] { 1, 0 } });
	}

	// Any live cell with fewer than two live neighbors dies as if caused by
	// under-population.
	// Any live cell with two or three live neighbors lives on to the next
	// generation.
	// Any live cell with more than three live neighbors dies, as if by
	// over-population.
	// Any dead cell with exactly three live neighbors becomes a live cell, as if by
	// reproduction.

	public static void gameOfLife(int[][] board) {
s
	}

}
