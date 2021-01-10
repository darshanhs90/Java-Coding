package Dec2020Leetcode;

public class _1287ElementAppearingMoreThan25PercentInSortedArray {
	public static void main(String[] args) {
		System.out.println(findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 6, 6, 7, 10 }));
	}

    public static int findSpecialInteger(int[] arr) {
    	int val =arr[0];
    	int count = 1;
        for (int i = 1; i < arr.length; i++) {
			if(val == arr[i])
				count++;
			else {
				val = arr[i];
				count = 1;
			}
			if(count > arr.length/4)
				return val;
		}
        return val;
    }
}
