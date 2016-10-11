import java.io.PrintStream;

///////////////////////////////////////////////////////////////////////////
//
// Node class
//
///////////////////////////////////////////////////////////////////////////

class Node
{
    private int key; // Every node stores an integer key
    private Node left; // Left child, if any
    private Node right; // Right child, if any
    private Node parent; // Parent node, if any

    public Node(int x)
    {
        key = x;
        left = null;
        right = null;
        parent = null;
    }

    //
    // Accessor methods
    //
    public int getKey() { return key; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    public Node getParent() { return parent; }
    public void setKey(int x) { key = x; }
    public void setLeft(Node x) { left = x; }
    public void setRight(Node x) { right = x; }
    public void setParent(Node x) { parent = x; }

    //
    // Retrieves the child with the next bigger key
    //
    public Node getSuccessorChild()
    {
        //
        // The successor is the next bigger number in the tree, or in other
        // words, the successor child is the left most child of the right
        // branch
        //
        Node successor = getRight();
        while (successor != null && successor.getLeft() != null) {
            successor = successor.getLeft();
        }

        //
        // Note that if no right branch exist, the successor is null!
        //
        return successor;
    }

    //
    // Finds the node with the corresponding key
    //
    public Node findNode(int k)
    {
        if (k == getKey()) {
           return this;
        }

        if (k < getKey()) {
            if (getLeft() != null) {
                return getLeft().findNode(k);
            }
        } else {
            if (getRight() != null) {
                return getRight().findNode(k);
            }
        }

        return null;
    }

    //
    // Pretty display
    //
    public void display(PrintStream ps, int offset)
    {
        if (right != null) {
            right.display(ps, offset + 4);
        }

        for (int i = 0; i < offset; i ++) {
            ps.print(" ");
        }

        ps.println(key);

        if (left != null) {
            left.display(ps, offset + 4);
        }
    }

    //
    // Replaces a child of the current node with a new node
    //
    public boolean replaceChild(Node oldNode, Node newNode)
    {
        //
        // If oldNode equals any of the children, the corresponding child is
        // replaced with newNode
        //

        //
        // oldNode found in the left position
        //
        if (left == oldNode) {
            left = newNode;

            if (left != null) {
                left.setParent(this);
            }

            return true;
        }

        //
        // oldNode found in the right position
        //
        if (right == oldNode) {
            right = newNode;

            if (right != null) {
                right.setParent(this);
            }

            return true;
        }

        return false;
    }

    //
    // Inserts a node as a child of this node
    //
    public boolean insertNode(Node node)
    {

        //
        // Inserts "node" as a child of this node
        //
    	if(node == null){
    		return false;
    	} else {
    		if(node.getKey() < getKey()){
    			if(getLeft() != null){
    				left.insertNode(node);
    			} else {
    				setLeft(node);
    			}
    		} else {
    			if(getRight() != null){
    				right.insertNode(node);
    			} else {
    				setRight(node);
    			}
    		}
    		return true;
    	}
        

        ////////////////////////////////////////////////////////////////////
        //
        // End test section
        //
        ////////////////////////////////////////////////////////////////////

    }

};

///////////////////////////////////////////////////////////////////////////
//
// BinaryTree class
//
///////////////////////////////////////////////////////////////////////////

class BinaryTree
{
    // Pointer to the root node
    private Node root;

    public BinaryTree()
    {
        root = null;
    }

    //
    // Deletes the node with the corresponding key
    //
    public boolean deleteNode(int key)
    {
        //
        // return if no root
        //
        if (root == null) {
            return false;
        }

        //
        // This is the node to be deleted
        //
        Node node = root.findNode(key);

        //
        // Nothing to delete
        //
        if (node == null){
            return false;
        }

        //
        // This is the parent of the node to be deleted
        // It is null if the node to be deleted is the tree root
        //
        Node parent = node.getParent();

        //
        // Find the successor node that will take the place of the deleted node
        // The successor node is the node with the next bigger key, if any
        //
        Node succ = node.getSuccessorChild();

        //
        // If the successor is null, then the node to be deleted has no
        // right children. In this case its left child will take its place.
        //
        if (succ == null){

            //
            // There is a valid parent
            //
            if (parent != null) {
                parent.replaceChild(node, node.getLeft());
            }

            //
            // If the parent is null, the node to be deleted was the tree root
            //
            else {
                root = node.getLeft();
                if (node.getLeft() != null){
                    node.getLeft().setParent(null);
                }
            }
        }

        else {

            //
            // We found a valid successor
            // The successor will take the place of the node to be deleted
            //

            //////////////////////////////////////////////////////////////////
            //
            // Begin test section
            //
            //////////////////////////////////////////////////////////////////



            //////////////////////////////////////////////////////////////////
            //
            // End test section
            //
            //////////////////////////////////////////////////////////////////
        }

        return true;
    }

    //
    // Inserts a node with the corresponding key
    //
    public boolean insertNode(int key)
    {
        //
        // Empty tree
        //
        if (root == null) {
            root = new Node(key);
            return true;
        }

        //
        // Node already exists. No duplicates allowed
        //
        if (root.findNode(key) != null) {
            return false;
        }

        Node n = new Node(key);

        //
        // This is doing the actual job
        //
        return root.insertNode(n);
    }

    public void display(PrintStream ps)
    {
        if (root != null) root.display(ps, 0);
    }
};

///////////////////////////////////////////////////////////////////////////
//
// BinTest class
//
///////////////////////////////////////////////////////////////////////////

class BinTest
{
    public static void main(String[] args)
    {
        BinaryTree bt = new BinaryTree();

        bt.insertNode(5);
        bt.insertNode(8);
        bt.insertNode(6);
        bt.insertNode(2);
        bt.insertNode(7);
        bt.insertNode(9);
        bt.insertNode(4);

        System.out.println("Initial tree:");
        bt.display(System.out);

        bt.deleteNode(8);
        System.out.println("Tree after 8 is deleted:");
        bt.display(System.out);

        bt.deleteNode(5);
        System.out.println("Tree after 5 is deleted:");
        bt.display(System.out);
    }
}
//Programming Test

