package Nov2020_FBPrep;

public class _033LowestCommonAncestorOfABinaryTree {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		System.out.println(numIslands(
				new char[][] { new char[] { '1', '1', '1', '1', '0' }, new char[] { '1', '1', '0', '1', '0' },
						new char[] { '1', '1', '0', '0', '0' }, new char[] { '0', '0', '0', '0', '0' } }));

		System.out.println(numIslands(
				new char[][] { new char[] { '1', '1', '0', '0', '0' }, new char[] { '1', '1', '0', '0', '0' },
						new char[] { '0', '0', '1', '0', '0' }, new char[] { '0', '0', '0', '1', '1' } }));
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

	}
}
