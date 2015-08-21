package ctci;

/*Implementation of Singly Linked List Data Structure*/
public class _2linkedList {
	private Node presentNode;
	private Node headNode;
	private int noOfElements=0;
	public _2linkedList() {
	}
	public int get(int position){
		if(position>noOfElements)
			throw new ArrayIndexOutOfBoundsException();
		else{
			int elementCount=0;
			Node pointerNode=new Node();
			pointerNode=headNode;
			while(position!=elementCount){
				//conditions,its at last
				pointerNode=pointerNode.next;
				elementCount++;
				//not at last
			}
			return pointerNode.data;
		}
	}
	public boolean add(int position,int value){
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
		while(position-1!=elementCount){
			pointerNode=pointerNode.next;
			elementCount++;
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
		noOfElements--;
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
		while(position-1!=elementCount){
			//conditions,its at last
			pointerNode=pointerNode.next;
			elementCount++;
			//not at last
		}
		pointerNode.next=pointerNode.next.next;
		noOfElements--;
		return true;
	}
	public String toString(){
		Node pointerNode=new Node();
		pointerNode=headNode;
		StringBuffer outputStringBuffer=new StringBuffer();
		while(pointerNode!=null){
			outputStringBuffer.append(pointerNode.data+"\n");
			pointerNode=pointerNode.next;
		}
		return outputStringBuffer.toString();
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
