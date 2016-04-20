package yelpInterview;

public class _LL08CountOccurencesLL {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){
		Node n=new Node(1);
		n.next=new Node(2);
		n.next.next=new Node(1);
		n.next.next.next=new Node(4);
		n.next.next.next.next=new Node(1);
		n.next.next.next.next.next=new Node(6);
		System.out.println(countOccurences(n,1));
		System.out.println(countOccurencesRecursive(n,1));
	}

	private static int countOccurencesRecursive(Node n, int value) {
		if(n==null)
			return 0;
		if(n.value==value)
			return 1+countOccurences(n.next, value);
		else
			return countOccurences(n.next, value);
	}

	private static int countOccurences(Node n,int value) {
		int count=0;
		while(n!=null){
			if(n.value==value)
				count++;
			n=n.next;
		}
		return count;
	}



}






