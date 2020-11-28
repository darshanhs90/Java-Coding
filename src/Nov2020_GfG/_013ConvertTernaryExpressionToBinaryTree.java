package Nov2020_GfG;

public class _013ConvertTernaryExpressionToBinaryTree {

	static class Node {
		char data;
		Node left, right;

		Node(char key) {
			data = key;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		printNodes(convertExp("a?b:c", 0));
		System.out.println();
		printNodes(convertExp("a?b?c:d:e", 0));
		System.out.println();
	}

	public static void printNodes(Node node) {
		if (node != null) {
			System.out.print(node.data+"->");
			printNodes(node.left);
			printNodes(node.right);
		}
	}

	public static Node convertExp(String str, int i) {
		if (i > str.length() || str.length() == 0)
			return null;
		Node n = new Node(str.charAt(i));
		i++;
		if (i < str.length() && str.charAt(i) == '?') {
			n.left = convertExp(str, i + 1);
		}

		if (i < str.length() && str.charAt(i) == ':') {
			n.right = convertExp(str, i + 1);
		}
		return n;
	}
}
