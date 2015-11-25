package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/ternary-search-tree/
*/
public class _0032TernarySearchTree {

	public static void main(String[] args) {

		

	}

	static class TreeNode{
		char value;
		TreeNode left,right,middle;
		public TreeNode(char value) {
			this.value=value;
		}
		
		
		public void insert(TreeNode tn,char value)
		{
			if(tn==null)
			{
				TreeNode tnNew=new TreeNode(value);
			}
			
			if((int)value<tn.value)
			{
				insert(tn.left, value);
			}
			else if((int)value>tn.value)
			{
				insert(tn.right, value);
			}
			else{
				
				
				
			}
			
			
			
		}
		
		
	}

	

	
}
