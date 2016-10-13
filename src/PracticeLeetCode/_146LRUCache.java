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
a
	int capacity=0;
	Node head=null,tail=null;
	HashMap<Integer, Node> map=new HashMap<>();
	public _146LRUCache(int capacity) {
		this.capacity=capacity;
	}
	//http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
	public int get(int key) {
		if(map.containsKey(key))
		{
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
			map.put(key, n);
			remove(n);
			setHead(n);
		}
		else{
			Node n=new Node(key,value);
			if(map.size()>=capacity)
			{
				map.remove(tail.key);
				remove(tail);
			}
			map.put(key, n);
			setHead(n);
		}
	}
	public void setHead(Node n)
	{
		n.next=head;
		n.pre=null;
		if(head!=null)
			head.pre=n;
		head=n;

		if(tail==null)
			tail=head;
	}
	public void remove(Node n)
	{
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
}