package May2021GoogLeetcode;

public class _0418SentenceScreenFitting {

	public static void main(String[] args) {
		System.out.println(wordsTyping(new String[] { "hello", "world" }, 2, 8));
		System.out.println(wordsTyping(new String[] { "a", "bcd", "e" }, 3, 6));
		System.out.println(wordsTyping(new String[] { "i", "had", "apple", "pie" }, 4, 5));
	}

	public static int wordsTyping(String[] sentence, int rows, int cols) {
		int currWidth = 0;
		int index = 0;
		int out = 0;
		int rowIndex = 0;
		while (rowIndex < rows) {
			if (currWidth == 0) {
				currWidth += sentence[index].length();
			} else {
				currWidth += sentence[index].length() + 1;
			}

			if (currWidth >= cols) {
				if (currWidth == cols) {
					currWidth = 0;
					rowIndex++;
				} else {
					currWidth = sentence[index].length();
					rowIndex++;
				}
			}

			index++;

			if (index == sentence.length) {
				out++;
				index = 0;
			}
		}
		return out;
	}

}
