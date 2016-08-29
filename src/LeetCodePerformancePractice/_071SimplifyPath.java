package LeetCodePerformancePractice;

public class _071SimplifyPath {
	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));

	}
	public static String simplifyPath(String path) {

	}
	/*static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static List<Integer> traversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode top = stack.peek();
			if (top.left != null) {
				stack.push(top.left);
				top.left = null;
			} else {
				result.add(top.val);
				stack.pop();
				if (top.right != null) {
					stack.push(top.right);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		tn.right.left.right=new TreeNode(8);
		tn.right.right.right=new TreeNode(9);		
		System.out.println(traversal(tn));
		System.out.println(fun(5));
	}


	static int fun(int n) {
		int count = 0;
		for (int i = n; i > 0; i /= 2) {
			for (int j = 0; j < i; j++) 
				count += 1;
		}
		return count;
	}*/
}
