package PracticeLeetCode;

import java.util.HashMap;

public class _146LRUCache {

	class Node{
		Node pre,next;
		int key,value;
		public Node(int key,int value) {
			this.key=key;
			this.value=value; 
		}
	}
	int capacity=0;
	Node head,tail;
	HashMap<Integer, Node> map=new HashMap<>();
	public _146LRUCache(int capacity) {
		this.capacity=capacity;
	}

	public int get(int key) {
		if(map.containsKey(key)){
			Node n=map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;	
	}

	public void set(int key, int value) {
		if(map.containsKey(key))
		{
			Node n=map.get(key);
			n.value=value;
			remove(n);
			setHead(n);
		}
		else{
			Node n=new Node(key, value);
			if(map.size()>=capacity)
			{
				map.remove(key);
			}
			map.put(key, n);
			setHead(n);
		}




	}

	public void remove(Node n){
		if(n.pre!=null)
		{
			n.pre.next=n.next;
		}
		else{
			head=n.next;
		}
		if(n.next!=null)
		{
			n.next.pre=n.pre;
		}
		else{
			tail=n.pre;
		}		
	}

	public void setHead(Node n){
		if(head==null)
		{
			head=n;
		}
		else{
			n.next=head;
			n.pre=null;
			head.pre=n;
			head=n;
		}
		
		if(tail==null)
		{
			tail=head;
		}	
		
	}	
}