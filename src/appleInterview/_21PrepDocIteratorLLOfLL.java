package appleInterview;

import java.util.Iterator;
import java.util.LinkedList;

public class _21PrepDocIteratorLLOfLL {
	public static void main(String[] args) {
		LinkedList<LinkedList<Integer>> listOfLists=new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			LinkedList<Integer> l=new LinkedList<>();
			l.add(i);
			l.add(i+1);
			listOfLists.add(l);
		}
		iterate(listOfLists);
		
		
	}

	private static void iterate(LinkedList<LinkedList<Integer>> listOfLists) {
		Iterator<LinkedList<Integer>> parentIter=listOfLists.iterator();
		while(parentIter.hasNext())
		{
			Iterator<Integer> childIter=parentIter.next().iterator();
			while(childIter.hasNext())
			{
				System.out.print(childIter.next()+"/");
			}
			System.out.println();
		}
		
	}


}
