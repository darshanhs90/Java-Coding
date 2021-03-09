package Feb2021Leetcode;

public class _0273IntegerToEnglishWords {

	public static void main(String[] args) {
		System.out.println(numberToWords(123));
		System.out.println(numberToWords(12345));
		System.out.println(numberToWords(1234567));
		System.out.println(numberToWords(1234567891));
	}

	public static String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		int noOfBillions = num / 1000000000;
		int noOfMillions = (num - (noOfBillions * 1000000000)) / 1000000;

		int noOfThousands = (num - (noOfBillions * 1000000000) - (noOfMillions * 1000000)) / 1000;

		int restVal = (num - (noOfBillions * 1000000000) - (noOfMillions * 1000000) - noOfThousands * 1000);

		String str = "";
		if (noOfBillions > 0) {
			str += threes(noOfBillions) + " Billion ";
		}
		if (noOfMillions > 0) {
			str += threes(noOfMillions) + " Million ";
		}
		if (noOfThousands > 0) {
			str += threes(noOfThousands) + " Thousand ";
		}
		str += threes(restVal);
		return str.trim();
	}

	public static String ones(int num) {
		switch (num) {
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		}
		return "";
	}

	public static String twos(int num) {
		switch (num) {
		case 10:
			return "Ten";
		case 20:
			return "Twenty";
		case 30:
			return "Thirty";
		case 40:
			return "Forty";
		case 50:
			return "Fifty";
		case 60:
			return "Sixty";
		case 70:
			return "Seventy";
		case 80:
			return "Eighty";
		case 90:
			return "Ninety";
		}
		return "";
	}

	public static String lessThan20(int num) {
		switch (num) {
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 14:
			return "Fourteen";
		case 15:
			return "Fifteen";
		case 16:
			return "Sixteen";
		case 17:
			return "Seventeen";
		case 18:
			return "Eighteen";
		case 19:
			return "Nineteen";
		}
		return "";
	}

	public static String threes(int num) {
		int noOfHundreds = num / 100;
		int tensVal = num - (100 * noOfHundreds);
		int noOfTens = tensVal / 10;

		int restVal = num - (noOfTens * 10) - (100 * noOfHundreds);

		String str = "";
		if (noOfHundreds > 0) {
			str += ones(noOfHundreds) + " Hundred ";
		}

		if (tensVal > 10 && tensVal < 20) {
			str += " " + lessThan20(tensVal);
		} else {
			str += twos(noOfTens * 10) + " " + ones(restVal);
		}
		return str;
	}
}
