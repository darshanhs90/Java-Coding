package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/custom-tree-problem/
 * To be done later
 */
public class _0060CustomTreeproblem {
	public static void main(String[] args) {
		String [] links1 = {"a b", "b c", "b d", "a e"};
        System.out.println("------------ Forest 1 ----------------");
        printForest(links1);       
         
        String [] links2 = {"a b", "a g", "b c", "c d", "d e", "c f",
                            "z y", "y x", "x w"};
        System.out.println("------------ Forest 2 ----------------");
        printForest(links2);      
	}


	private static void printForest(String[] links1) {
		
		
		
		
	}


	

	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
