package FacebookPrep;

public class _0277FindCelebrity {

	public static void main(String[] args) {
		System.out.println(findCelebrity(3));
	}

	static boolean knows(int a, int b) {
		return true;
	}

	public static int findCelebrity(int n) {
		for (int i = 0; i < n; i++) {
			if (isCelebrity(i, n))
				return i;
		}
		return -1;
	}

	public static boolean isCelebrity(int currPerson, int noOfPersons) {
		for (int i = 0; i < noOfPersons; i++) {
			if (i == currPerson || (knows(i, currPerson) && !knows(currPerson, i)))
				continue;
			return false;
		}
		return true;
	}

}
