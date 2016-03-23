package appleInterview;

import java.util.LinkedList;

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

	private static void reverseLists(LinkedList<LinkedList<Integer>> listOfLists) {
		
		
	}




}
