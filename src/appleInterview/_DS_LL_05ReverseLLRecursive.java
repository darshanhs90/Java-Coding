package appleInterview;

public class _DS_LL_05ReverseLLRecursive {
	static Node head;
	static class Node{
		Node next;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(1);
		n.next=new Node(2);
		n.next.next=new Node(3);
		n.next.next.next=new Node(4);
		n.next.next.next.next=new Node(5);
		n.next.next.next.next.next=new Node(6);
		print(n);
		n=reverseUtil(n,null);
		print(n);

	}

	static Node reverseUtil(Node curr, Node prev) {
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return null;
		}
		Node nextNode = curr.next;
		curr.next = prev;
		reverseUtil(nextNode, curr);
		return head;
	}

	private static void print(Node n) {
		while(n!=null){
			System.out.print(n.value+"/");
			n=n.next;
		}
		System.out.println();
	}

}
