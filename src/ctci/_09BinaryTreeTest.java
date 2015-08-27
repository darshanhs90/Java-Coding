package ctci;


/*Implementation of Binary Tree Tester */
public class _09BinaryTreeTest{
	public static void main(String[] args) {
		_09BinaryTree binaryTree=new _09BinaryTree();
		binaryTree.insert(10,"",0);
		binaryTree.insert(11,"LEFT",10);
		binaryTree.insert(12,"LEFT",11);
		binaryTree.insert(13,"LEFt",12);
		binaryTree.insert(16,"Right",10);
		System.out.println(binaryTree.search(14));
		System.out.println(binaryTree.search(12));
		System.out.println(binaryTree.search(16));
		binaryTree.delete(10);
		System.out.println(binaryTree.search(10));
	}
}