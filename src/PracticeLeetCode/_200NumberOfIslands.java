package PracticeLeetCode;

public class _200NumberOfIslands {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(numIslands(new char[][]{
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}	
		}));

	}
	public static int numIslands(char[][] grid) {
		
	}
}