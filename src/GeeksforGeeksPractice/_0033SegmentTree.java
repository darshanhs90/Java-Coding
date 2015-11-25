package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
*/
public class _0033SegmentTree {

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
