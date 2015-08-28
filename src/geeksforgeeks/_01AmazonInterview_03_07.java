package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import ctci._02linkedList;
import ctci._02linkedList.Node;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-2/
 *  You are given a linked list and an integer k. Reverse every consecutive k nodes of the given linked list.
 */
public class _01AmazonInterview_03_07 {
	static Node leadingPointerNode,trailingPointerNode;
	public static void main(String[] args) {

		_02linkedList linkedList=new _02linkedList();
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int k=Integer.parseInt(scanner.nextLine());
		scanner.close();
		for (int i = 0; i < 3*k; i++) {
			linkedList.add(i+1);
		}
		System.out.println(linkedList.toString());
		leadingPointerNode=linkedList.getHeadNode();
		trailingPointerNode=linkedList.getHeadNode();
		while(leadingPointerNode!=null){
			swapElements(k);
		}
		System.out.println(linkedList.toString());
	}
	private static void swapElements(int k) {
		Stack<Integer> stack=new Stack<Integer>();
		for (int i = 0; i < k; i++) {
			if(leadingPointerNode!=null){
				stack.push(leadingPointerNode.data);
				leadingPointerNode=leadingPointerNode.next;
			}
			else{
				return;
			}
		}
		for (int i = 0; i < k; i++) {
			trailingPointerNode.data=stack.pop();
			trailingPointerNode=trailingPointerNode.next;
		}
	}
}