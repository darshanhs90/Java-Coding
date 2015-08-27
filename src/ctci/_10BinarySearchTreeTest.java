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
		bst.insert(45);		
		bst.insert(55);		
		bst.insert(65);		
		bst.insert(75);		
		
		bst.preOrder();
		/*		bst.postOrder();
		bst.inOrder();*/
		System.out.println(bst.size());
		bst.delete(100);
		System.out.println("Deleting 20");
		bst.delete(20);
		System.out.println("Deletion of 20 completed");
		System.out.println(bst.size());
		/*bst.preOrder();
		bst.postOrder();
		bst.inOrder();*/
		System.out.println("Height is :"+bst.height());
	}
}