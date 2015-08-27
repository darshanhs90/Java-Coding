package ctci;


/*Implementation of CTCI */
public class _10BinarySearchTreeTest{

	public static void main(String[] args) {
		_10BinarySearchTree bst=new _10BinarySearchTree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(15);
		bst.insert(5);
		bst.insert(30);
		bst.insert(25);
		bst.insert(35);		
		bst.preOrder();
		bst.postOrder();
		bst.inOrder();
		System.out.println(bst.size());
		System.out.println("Deleting 100 : "+bst.delete(100));
		System.out.println("Deleting 10 : "+bst.delete(20));
		System.out.println(bst.size());
		bst.preOrder();
		bst.postOrder();
		bst.inOrder();
	}
}