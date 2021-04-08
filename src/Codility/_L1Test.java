package Codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 */

public class _L1Test {
	public static void main(String[] args) {
		try {
			generateRows(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Number pyramid ===============
	 * 
	 * 1-> 1 2-> 1 2 3-> 1 3 2 4-> 1 4 5 2 5-> 1 5 9 7 2
	 * 
	 * ...
	 * 
	 * ..
	 * 
	 * 10->
	 */

	/*
	 * base case ->n== 1 tempList - >1
	 * 
	 * 
	 * for 2->num
	 */

	// prev list - >1,2

	// currlist -> empty

	// iterate through prevlist(index of prevlist is i)
	// if i == 0
	// append 1 to currlist

	// append(prelist.get(i)+prevlist.get(i+1))

	// if(i == last element)
	// append last element of prevlist

	// prevlist

	public static void generateRows(int num) throws Exception {
		if (num <= 0) {
			throw new Exception("Invalid");
		}

		// base case if for n<2

		if (num == 1) {
			System.out.println(new ArrayList<Integer>(Arrays.asList(1)));
		} else if (num == 2) {
			System.out.println(new ArrayList<Integer>(Arrays.asList(1)));
			System.out.println(new ArrayList<Integer>(Arrays.asList(1, 2)));
		} else {
			System.out.println(new ArrayList<Integer>(Arrays.asList(1)));
			System.out.println(new ArrayList<Integer>(Arrays.asList(1, 2)));
			List<Integer> prevList = new ArrayList<Integer>(Arrays.asList(1, 2));

			for (int i = 3; i <= num; i++) {
				List<Integer> currList = new ArrayList<Integer>();
				// prev list is 1,2
				currList.add(1);
				// curr list ->1
				for (int j = 1; j < prevList.size(); j++) {
					currList.add(prevList.get(j - 1) + prevList.get(j));
				}
				currList.add(2);
				System.out.println(currList);
				prevList = currList;
			}
		}
	}

}