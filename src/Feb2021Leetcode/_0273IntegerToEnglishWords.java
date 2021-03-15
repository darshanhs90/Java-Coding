package Feb2021Leetcode;

public class _0273IntegerToEnglishWords {

	public static void main(String[] args) {
		System.out.println(numberToWords(123));
		System.out.println(numberToWords(12345));
		System.out.println(numberToWords(1234567));
		System.out.println(numberToWords(1234567891));
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
		int tensVal = num - (noOfHundreds * 100);
		int noOftens = (tensVal / 10) * 10;
		int rest = tensVal % 10;
		String str = "";
		if (noOfHundreds > 0) {
			str += ones(noOfHundreds) + " Hundred ";
		}

		if (tensVal > 10 && tensVal < 20) {
			str += lessThan20(tensVal);
		} else {
			if (noOftens > 0) {
				str += twos(noOftens) + " ";
			}

			if (rest > 0) {
				str += ones(rest);
			}
		}
		return str;
	}

	public static String numberToWords(int num) {
        if(num == 0)
            return "Zero";
		int noOfBillions = num / 1000000000;
		int noOfMillions = (num - 1000000000 * noOfBillions) / 1000000;
		int noOfThousands = (num - 1000000000 * noOfBillions - 1000000 * noOfMillions) / 1000;
		int restVal = num - 1000000000 * noOfBillions - 1000000 * noOfMillions - 1000 * noOfThousands;

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

		if (restVal > 0) {
			str += threes(restVal);
		}

		return str;
	}

}
