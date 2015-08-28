package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;

import ctci._02linkedList;
import ctci._02linkedList.Node;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-2/
 * You are given a linked list and a parameter k. You will have to swap values in a certain fashion, 
 * swap value of node 1 with node k, then node (k+1) with node 2k and go on doing this in the similar fashion
 */
public class _01AmazonInterview_03_03 {
	public static void main(String[] args) {
		_02linkedList linkedList=new _02linkedList();
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int k=Integer.parseInt(scanner.nextLine());
		scanner.close();
		for (int i = 0; i < 3*k; i++) {
			linkedList.add(i+1);
		}
		System.out.println(linkedList.toString());
		linkedList=replaceValues(linkedList,k);
		System.out.println(linkedList.toString());
	}

	private static _02linkedList replaceValues(_02linkedList linkedList,int k) {
		// TODO Auto-generated method stub
		Node slowPointerNode=linkedList.getHeadNode();
		Node fastPointerNode=linkedList.getHeadNode();
		while(fastPointerNode!=null){
			fastPointerNode=movePointer(k, fastPointerNode);
			if(fastPointerNode==null)
				break;
			fastPointerNode.data=fastPointerNode.data ^ slowPointerNode.data;
			slowPointerNode.data=fastPointerNode.data ^ slowPointerNode.data;
			fastPointerNode.data=fastPointerNode.data ^ slowPointerNode.data;
			slowPointerNode=movePointer(k, slowPointerNode);
		}
		return linkedList;
	}

	private static Node movePointer(int k, Node fastPointerNode) {
		for (int i = 0; i < k; i++) {
			if(fastPointerNode==null)
				return null;
			fastPointerNode=fastPointerNode.next;
		}
		return fastPointerNode;
	}




}