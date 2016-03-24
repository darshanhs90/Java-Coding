package appleInterview;

import java.util.LinkedList;
import java.util.Stack;

public class _03PrepDocReverseListOfLists {
	public static void main(String[] args) {
		LinkedList<LinkedList<Integer>> listOfLists=new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			LinkedList<Integer> l=new LinkedList<>();
			l.add(i);
			l.add(i+1);
			listOfLists.add(l);
		}
		reverseLists(listOfLists);
	}
	private static LinkedList<LinkedList<Integer>> reverseLists(LinkedList<LinkedList<Integer>> listOfLists) {
		Stack<LinkedList<Integer>> listStack=new Stack<>();
		for (int i = 0; i < listOfLists.size(); i++) {
			listStack.push(listOfLists.get(i));
		}
		listOfLists=new LinkedList<>();
		while(!listStack.isEmpty()){
			listOfLists.add(listStack.pop());
		}
		return listOfLists;
	}
}
