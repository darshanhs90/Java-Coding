package ctci;



/*Implementation of Hash Map Data Structure*/
public class _03stack {
	private Node presentNode;
	private int noOfElements;
	public _03stack() {
		presentNode=new Node();
		presentNode.previousNode=null;
	}
	public void push(int value){
		presentNode.data=value;
		Node newNode=new Node();
		newNode.previousNode=presentNode;
		presentNode=newNode;
		noOfElements++;
	}
	public int pop() throws ArrayIndexOutOfBoundsException{
		int value=presentNode.previousNode.data;
		presentNode=presentNode.previousNode;
		noOfElements--;
		return value;
	}
	public int size(){
		return noOfElements;
	}
	public boolean isEmpty(){
		return noOfElements==0?true:false;
	}
	public String toString(){
		StringBuilder outputStringBuilder=new StringBuilder();
		Node pointerNode=new Node();
		pointerNode=presentNode.previousNode;
		while(pointerNode!=null){
			outputStringBuilder.append(pointerNode.data+"\n");
			pointerNode=pointerNode.previousNode;
		}
		return outputStringBuilder.toString();
	}





	class Node{
		int data;
		Node previousNode;
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getPreviousNode() {
			return previousNode;
		}
		public void setPreviousNode(Node previousNode) {
			this.previousNode = previousNode;
		}

	}
}

