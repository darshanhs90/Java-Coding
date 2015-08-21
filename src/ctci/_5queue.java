package ctci;


/*Implementation of Queue Data Structure*/
public class _5queue {
	Node entryNode;
	Node exitNode;
	int noOfElements=0;
	public String poll(){
		return "";
	}
	public String peek(){
		return "";
	}
	public Boolean isEmpty(){
		return false;
	}
	public void clear(){
		
	}
	public void add(String value){
		
	}
	public String remove(){
		return "";
	}
	public Boolean contains(String value){
		return false;
	}
	public int size(){
		return noOfElements;
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
