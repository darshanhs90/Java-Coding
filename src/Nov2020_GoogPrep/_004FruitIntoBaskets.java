package Nov2020_GoogPrep;

public class _004FruitIntoBaskets {

	public static void main(String[] args) {
		System.out.println(totalFruit(new int[] { 1, 2, 1 }));
		System.out.println(totalFruit(new int[] { 0, 1, 2, 2 }));
		System.out.println(totalFruit(new int[] { 1, 2, 3, 2, 2 }));
		System.out.println(totalFruit(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 }));
		System.out.println(totalFruit(new int[] { 1, 1, 1, 2, 1, 3, 3, 3, 3, 3 }));
		System.out.println(totalFruit(new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3, 3 }));
	}

	public static int totalFruit(int[] tree) {
		if (tree.length < 2)
			return tree.length;
		int max = 0;
		int currCount = 0;
		Integer fruitType1 = null, fruitType2 = null;
		for (int i = 0; i < tree.length; i++) {
			if (fruitType1 == null) {
				fruitType1 = tree[i];
				currCount++;
			} else if (fruitType1 != tree[i] && fruitType2 == null) {
				fruitType2 = tree[i];
				currCount++;
			} else if (tree[i] == fruitType1 || tree[i] == fruitType2) {
				currCount++;
			}
			else {
				// tree[i] != either of fruittype
				//find first change and add count to it and set either of fruittypes to null;
			}
		}

	}
}
