package appleInterview;

import java.util.LinkedList;
import java.util.Stack;

public class _13PrepDocReverseLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> l=new LinkedList<>();
		l.add(1);l.add(2);l.add(3);l.add(4);l.add(5);
		printList(l);
		System.out.println();
		l=reverseList(l);
		printList(l);
	}
	private static void printList(LinkedList<Integer> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i)+"/");
		}
	}
	private static LinkedList<Integer> reverseList(LinkedList<Integer> l) {
		Stack<Integer> stack=new Stack<>();
		for (int i = 0; i < l.size(); i++) {
			stack.push(l.removeFirst());
		}
		while(!stack.isEmpty()){
			l.add(stack.pop());
		}
		return l;
	}
}
