package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/find-all-possible-interpretations/
 */
public class _0037ArrayDigitsToTree {
	private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "v", "z"};
	public static void main(String[] args) {
		// aacd(1,1,3,4) amd(1,13,4) kcd(11,3,4)
		int[] arr = {1, 1, 3, 4};
		printAllInterpretations(arr);

		// aaa(1,1,1) ak(1,11) ka(11,1)
		int[] arr2 = {1, 1, 1};
		printAllInterpretations(arr2);

		// bf(2,6) z(26)
		int[] arr3 = {2, 6};
		printAllInterpretations(arr3);

		// ab(1,2), l(12)  
		int[] arr4 = {1, 2};
		printAllInterpretations(arr4);

		// a(1,0} j(10)  
		int[] arr5 = {1, 0};
		printAllInterpretations(arr5);

		// "" empty string output as array is empty
		int[] arr6 = {};
		printAllInterpretations(arr6);

		// abba abu ava lba lu
		int[] arr7 = {1, 2, 2, 1};
		printAllInterpretations(arr7);





	}




	private static void printAllInterpretations(int[] arr) {


	}




	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
