package geeksforgeeks;



/*
 * http://www.geeksforgeeks.org/amazon-interview-set-2/
 * Given a linked list containing character in each node, segregate its nodes in such a way that all nodes containing a vowel
 * are moved to the end of the linked list.We will have to maintain the order.
 */
public class _01AmazonInterview_03_01 {
	public static void main(String[] args) {
		_01AmazonInterview_03linkedList linkedList=new _01AmazonInterview_03linkedList();
		linkedList.add("d");
		linkedList.add("a");
		linkedList.add("r");
		linkedList.add("s");
		linkedList.add("h");
		linkedList.add("a");
		linkedList.add("n");
		linkedList.add("e");
		linkedList.add("i");
		linkedList.add("s");
		linkedList.add("h");
		linkedList.add("o");
		linkedList.add("n");
		linkedList.add("u");
		linkedList.add("i");
		System.out.println(linkedList.toString());
		linkedList=reArrangeLinkedList(linkedList);
		System.out.println(linkedList.toString());
		
		
	}

	private static _01AmazonInterview_03linkedList reArrangeLinkedList(
			_01AmazonInterview_03linkedList linkedList) {
		_01AmazonInterview_03linkedList newLinkedList=new _01AmazonInterview_03linkedList();
		for (int i = 0; i < linkedList.size(); i++) {
			String element=linkedList.get(i);
			if(!(element.contentEquals("a")||element.contentEquals("e")||
					element.contentEquals("i")||element.contentEquals("o")||element.contentEquals("u"))){
				newLinkedList.add(element);
			}
		}
		for (int i = 0; i < linkedList.size(); i++) {
			String element=linkedList.get(i);
			if((element.contentEquals("a")||element.contentEquals("e")||
					element.contentEquals("i")||element.contentEquals("o")||element.contentEquals("u"))){
				newLinkedList.add(element);
			}
		}
		return newLinkedList;
	}
	
	
	
	
	


}
class _01AmazonInterview_03linkedList {
	private Node presentNode;
	private Node headNode;
	private int noOfElements=0;
	public _01AmazonInterview_03linkedList() {
	}
	public Node getHeadNode(){
		return headNode;
	}
	public String get(int position){
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
	public boolean add(int position,String value){
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
	public void add(String value){
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
			outputStringBuffer.append(pointerNode.data+" ");
			pointerNode=pointerNode.next;
		}
		return outputStringBuffer.toString();
	}
	public class Node{
		public String data;
		public Node next;
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public Node( String data,Node next) {
			this.data=data;
			this.next=next;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
	}
}