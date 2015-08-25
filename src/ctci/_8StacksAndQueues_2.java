package ctci;

import java.util.ArrayList;


/*Implementation of CTCI 3.2*/
class _8Stacks {
	private Node presentNode;
	private int noOfElements;
	ArrayList<Integer> minList=new ArrayList<Integer>();
	public _8Stacks() {
		presentNode=new Node();
		presentNode.previousNode=null;
	}
	public void push(int value){
		if(minList.size()==0)
			minList.add(value);
		else{
			if(value<minList.get(minList.size()-1))
				minList.add(value);
			else
				minList.add(minList.get(minList.size()-1));
		}
		presentNode.data=value;
		Node newNode=new Node();
		newNode.previousNode=presentNode;
		presentNode=newNode;
		noOfElements++;
	}
	public int pop() throws ArrayIndexOutOfBoundsException{
		int value=presentNode.previousNode.data;
		presentNode=presentNode.previousNode;
		if(minList.size()!=0)
			minList.remove(minList.size()-1);
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
	public int min(){
		return minList.get(minList.size()-1);
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
public class _8StacksAndQueues_2{
	public static void main(String[] args) {
		_8Stacks stack=new _8Stacks();
		stack.push(10);
		stack.push(20);
		stack.push(30);		
		System.out.println("Min is"+stack.min());
		stack.push(5);
		System.out.println("Min is"+stack.min());
		stack.pop();
		System.out.println(stack.size());
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.isEmpty());
		stack.pop();
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.toString());
	}
}
