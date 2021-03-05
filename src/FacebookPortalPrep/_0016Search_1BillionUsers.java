package FacebookPortalPrep;

public class _0016Search_1BillionUsers {

	public static void main(String[] args) {
		System.out.println(getBillionUsersDay(new float[] { (float) 1.5 }));
		System.out.println(getBillionUsersDay(new float[] { (float) 1.1, (float) 1.2, (float) 1.3 }));
		System.out.println(getBillionUsersDay(new float[] { (float) 1.01, (float) 1.02 }));
	}

	public static int getBillionUsersDay(float[] growthRates) {
		// Write your code here
		long noOfDays = 0;
		long threshold = 1000000000;
		double sum = 0;
		while (sum < threshold) {
			noOfDays++;
			sum = 0;
			for (int i = 0; i < growthRates.length; i++) {
				sum += Math.pow(growthRates[i], noOfDays);
			}
		}

		return (int) noOfDays;
	}
}
