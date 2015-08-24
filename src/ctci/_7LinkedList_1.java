package ctci;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;




/*Implementation of CTCI 2.1*/
public class _7LinkedList_1 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		int noOfElements=Integer.parseInt(scanner.nextLine());
		_2linkedList linkedList=new _2linkedList();
		String stringArray[]=scanner.nextLine().split(" ");
		scanner.close();
		for (int i = 0; i < stringArray.length; i++) {
			linkedList.add(Integer.parseInt(stringArray[i]));
		}
		_2linkedList finalList=removeDups(noOfElements, linkedList);
		for (int i = 0; i < finalList.size(); i++) {
			System.out.print(finalList.get(i)+" ");
		}
	}

	private static _2linkedList removeDups(int noOfElements, _2linkedList linkedList) {
		HashMap<Integer,Integer> hashedLinkedList=new HashMap<Integer, Integer>();
		_2linkedList finalList=new _2linkedList();
		for (int i = 0; i < noOfElements; i++) {
			if(hashedLinkedList.put(linkedList.get(i), linkedList.get(i))==null){
				finalList.add(linkedList.get(i));
			}
		}
		return finalList;
	}
}
