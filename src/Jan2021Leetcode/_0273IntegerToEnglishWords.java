package Jan2021Leetcode;

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

	public static String lessThan20(int num) {
		switch (num) {
		case 10:
			return "Ten";
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

	public static String threes(int num) {
		int noOfHundreds = num / 100;
		int noOfTens = num - 100 * noOfHundreds;
		StringBuilder sb = new StringBuilder();
		if (noOfHundreds > 0) {
			sb.append(ones(noOfHundreds) + " Hundred ");
		}

		if (noOfTens <= 0) {
			sb.append(ones(noOfTens));
		} else if (noOfTens > 9 && noOfTens < 20) {
			sb.append(lessThan20(noOfTens));
		} else {
			int tens = (noOfTens / 10) * 10;
			int ones = noOfTens % 10;
			sb.append(twos(tens) + " ");
			sb.append(ones(ones));
		}
		return sb.toString();
	}

	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		int billion = num / 1000000000;
		int million = (num - billion * 1000000000) / 1000000;
		int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
		int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

		String result = "";
		if (billion != 0)
			result = threes(billion) + " Billion";
		if (million != 0) {
			if (!result.isEmpty())
				result += " ";
			result += threes(million) + " Million";
		}
		if (thousand != 0) {
			if (!result.isEmpty())
				result += " ";
			result += threes(thousand) + " Thousand";
		}
		if (rest != 0) {
			if (!result.isEmpty())
				result += " ";
			result += threes(rest);
		}
		return result.trim();
	}
}
