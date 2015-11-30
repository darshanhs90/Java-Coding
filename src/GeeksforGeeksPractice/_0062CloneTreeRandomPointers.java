package GeeksforGeeksPractice;

import java.util.ArrayList;

/*
 * Link : http://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
 * To be done later
 */
public class _0062CloneTreeRandomPointers {
	public static void main(String[] args) {
		TreeNode tn = new TreeNode(10);
		tn.left        = new TreeNode(12);
		tn.right       = new TreeNode(15);
		tn.left.left  = new TreeNode(25);
		tn.left.right = new TreeNode(30);
		tn.right.left = new TreeNode(36);
		list=new ArrayList<>();
		getTreeStructure(tn);
		convertStructure(list);
	}
	private static void convertStructure(ArrayList<Integer> list) {
		DLLNode tn=new DLLNode(list.get(0));
		tn.prev=null;
		DLLNode headPtr=tn;
		for (int i = 1; i < list.size(); i++) {
			DLLNode temp=new DLLNode(list.get(i));
			temp.prev=tn;
			tn.next=temp;
			tn=tn.next;
		}
		while(headPtr!=null)
		{
			System.out.println(headPtr.value);
			headPtr=headPtr.next;
		}
		
		
	}
	static ArrayList<Integer> list;
	private static void getTreeStructure(TreeNode tn) {
		if(tn!=null)
		{	
			getTreeStructure(tn.left);
			list.add(tn.value);
			getTreeStructure(tn.right);
		}
	}


	static class DLLNode{
		DLLNode prev,next;
		int value;
		public DLLNode(int value) {
			this.value=value;
		}
	}



	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
