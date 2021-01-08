package Dec2020Leetcode;

public class _0606ConstructStringFromBinaryTree {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		System.out.println(tree2str(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		System.out.println(tree2str(tn));
	}
	
    public static String tree2str(TreeNode tn) {
    	if(tn == null)
    		return "";
        StringBuilder sb =new StringBuilder();
        tree2str(tn,sb);
        return sb.toString();
    }
    
	
    public static void tree2str(TreeNode tn, StringBuilder sb) {
        if(tn == null)
        	return;
        sb.append(tn.val);
        if(tn.left!=null)
        {
        	sb.append("(");
        	tree2str(tn.left, sb);
            sb.append(")");
        }

        if(tn.right!=null)
        {
        	if(tn.left == null)
        	{
        		sb.append("()");
        	}
        	sb.append("(");
        	tree2str(tn.right, sb);
        	sb.append(")");
        }
    }
	
}
