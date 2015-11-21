package careerCup;

/*
 * Link: http://www.careercup.com/question?id=264695
 * Write an algorithm to find out how many different summations you can compute using numbers range from 1 to 1000. 2 constraints
 * 1) Each valid sum must be less than 10000
 * 2) A number can only be used once for a sum
 * example:
 * 1+2+300 &lt; 10000 is valid
 * 1+2+300+400 &lt; 10000 is valid
 * 1+2+2 is not valid (2 appear twice)
 */
public class _24googleCareerCup {
	public static void main(String[] args) {
		
		System.out.println(findCombinations(1000));
		
	}

	private static int findCombinations(int value) {
		int count=0;
		boolean[] sum = new boolean[10001];
        sum[0] = true;
        for (int i = 1; i <= value; i++) {
              for (int j = sum.length - 1; j >= i; j--) {
                    if (sum[j - i]) {
                        sum[j] = true;
                    }
              }
        }
        
        for (int i = 1; i < sum.length; i++) {
              if (sum[i]) {
                  count++;
              }
        }
		return count;
	}
}
