package ctci;


/*Implementation of Queue Data Structure*/
public class _05queue {
	Node headNode;
	Node exitNode;
	int noOfElements=0;
	public int poll(){//Retrieves and removes the head of this queue, or returns null if this queue is empty.
		int returnData=0;
		if(headNode!=null)
		{
			returnData=headNode.data;
			headNode=headNode.next;
			noOfElements--;
		}
		return returnData;
	}
	public int peek(){//Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
		if(headNode!=null)
			return headNode.data;
		return 0;
	}
	public Boolean isEmpty(){
		return noOfElements==0?true:false;
	}
	public void clear(){
		noOfElements=0;
		headNode=exitNode=null;
	}
	public void add(int value){
		if(headNode==null){
			headNode=new Node();
			headNode.data=value;
			exitNode=headNode;
		}
		else{
			Node newNode=new Node();
			newNode.data=value;
			exitNode.next=newNode;
			exitNode=newNode;
		}
		noOfElements++;
	}
	public int remove(){//Retrieves and removes the head of this queue. This method differs from poll only in that it throws an exception if this queue is empty.
		int returnData=0;
		if(headNode!=null)
		{
			returnData=headNode.data;
			headNode=headNode.next;
			noOfElements--;
		}
		return returnData;
	}
	public Boolean contains(int value){
		Node pointerNode=new Node();
		pointerNode=headNode;
		while(pointerNode!=null){
			if(pointerNode.data==value)
				return true;
			pointerNode=pointerNode.next;
		}
		return false;
	}
	public int size(){
		return noOfElements;
	}
	public String toString(){
		StringBuilder outputStringBuilder=new StringBuilder();
		Node pointerNode=new Node();
		pointerNode=headNode;
		while(pointerNode!=null){
			outputStringBuilder.append(pointerNode.data+",");
			pointerNode=pointerNode.next;
		}
		return outputStringBuilder.toString();
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
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}

	}
}
