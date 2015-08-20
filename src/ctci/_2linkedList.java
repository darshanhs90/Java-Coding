package ctci;

/*Implementation of Singly Linked List Data Structure*/
public class _2linkedList {
	private Node presentNode;
	private Node headNode;
	private int noOfElements=0;
	public _2linkedList() {
	}
	public int get(int position){
		return 0;
	}
	public boolean add(int value,int position){
		//check for posn number using noOFelements
		if(position>noOfElements)
			return false;
		if(position==0){
			add(value);
			return true;
		}
		//go from header till that position
		Node pointerNode=new Node();
		pointerNode=headNode;
		int elementCount=0;
		while(position!=elementCount){
			//conditions,its at last
			pointerNode=pointerNode.next;
			elementCount++;
			//not at last
		}
		Node newNode=new Node();
		newNode.data=value;
		newNode.next=pointerNode.next;
		pointerNode.next=newNode;
		noOfElements++;
		return true;
	}
	public int size(){
		return noOfElements;
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
		noOfElements++;
	}
	public boolean delete(){
		if(headNode==null)
			return false;
		headNode=headNode.next;
		return true;
	}
	public boolean delete(int position){
		if(position>noOfElements)
			return false;
		if(position==0){
			delete();
			return true;
		}
		//go from header till that position
		Node pointerNode=new Node();
		pointerNode=headNode;
		int elementCount=0;
		while(position!=elementCount){
			//conditions,its at last
			pointerNode=pointerNode.next;
			elementCount++;
			//not at last
		}
		pointerNode.next=pointerNode.next.next;
		pointerNode.data=pointerNode.next.data;
		return true;
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
