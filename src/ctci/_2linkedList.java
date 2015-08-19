package ctci;


/*Implementation of Singly Linked List Data Structure*/
public class _2linkedList {
	private Node presentNode;
	private Node headNode;
	public _2linkedList() {
	}
	public int get(int position){
		return 0;
	}
	public void add(int value,int position){
		
	}
	public void add(int value){
		if(presentNode==null){
			headNode=new Node();
			headNode.next=null;
			headNode.data=value;
			presentNode=headNode;
		}
		else{
			Node newNode=new Node();
			presentNode.next=newNode;
			newNode.next=null;
			newNode.data=value;
			presentNode=newNode;
		}
	}
}
class Node{
	int data;
	Node next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}
