package yelpInterview;

public class _LL15FlattenALL {
	static class Node{
		int value;
		Node right;
		Node down;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){
		Node n=new Node(5);
		n.right=new Node(10);
		n.down=new Node(7);
		n.down.down=new Node(8);
		n.down.down.down=new Node(30);
		n.right.down=new Node(20);
		n.right.right=new Node(19);
		n.right.right.down=new Node(22);
		n.right.right.down.down=new Node(50);
		n.right.right.right=new Node(28);
		n.right.right.right.down=new Node(35);
		n.right.right.right.down.down=new Node(40);
		n.right.right.right.down.down.down=new Node(45);
		n=flatten(n);
		print(n);
	}

	private static Node flatten(Node n) {
		if(n==null||n.right==null)
			return n;
		return merge(n,flatten(n.right));
	}

	private static Node merge(Node a, Node b) {
		if(a==null)
			return b;
		if(b==null)
			return a;
		Node result;
		if(a.value<b.value)
		{
			result=a;
			result.down=merge(a.down,b);
		}
		else{
			result=b;
			result.down=merge(a,b.down);
		}
		return result;
	}

	private static void print(Node n) {
		while(n!=null)
		{
			System.out.println(n.value);
			n=n.down;
		}
	}

}






