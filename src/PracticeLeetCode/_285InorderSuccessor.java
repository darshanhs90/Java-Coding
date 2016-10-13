package PracticeLeetCode;

public class _285InorderSuccessor {
	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(20);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(22);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(12);
		tn.left.right.left=new TreeNode(10);
		tn.left.right.right=new TreeNode(14);
		System.out.println(inorderSuccessor(tn,tn.left).value);
	}


	static boolean next=false;
	static TreeNode tn;
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root==null)
			return null;
		getInOrderSuccessor(root,p);
		return tn;
	}
	private static void getInOrderSuccessor(TreeNode root, TreeNode p) {
		if(root==null)
			return ;
		getInOrderSuccessor(root.left, p);
		if(next)
		{
			tn=root;
			next=false;
			return;
		}
		if(root.value==p.value)
		{
			next=true;
		}
		getInOrderSuccessor(root.right, p);


	}

/*	if(root==null)
        return null;
 
    TreeNode next = null;
    TreeNode c = root;
    while(c!=null && c.val!=p.val){
        if(c.val > p.val){
            next = c;
            c = c.left;
        }else{
            c= c.right;
        }
    }
 
    if(c==null)        
        return null;
 
    if(c.right==null)
        return next;
 
    c = c.right;
    while(c.left!=null)
        c = c.left;
 
    return c;*/
}
