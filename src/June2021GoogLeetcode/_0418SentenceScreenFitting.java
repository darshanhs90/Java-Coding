package June2021GoogLeetcode;

public class _0418SentenceScreenFitting {

	public static void main(String[] args) {
		System.out.println(wordsTyping(new String[] { "hello", "world" }, 2, 8));
		System.out.println(wordsTyping(new String[] { "a", "bcd", "e" }, 3, 6));
		System.out.println(wordsTyping(new String[] { "i", "had", "apple", "pie" }, 4, 5));
		System.out.println(wordsTyping(new String[] { "f", "p", "a" }, 8, 7));
		System.out.println(wordsTyping(new String[] { "hello","leetcode" }, 1, 10));
	}

	public static int wordsTyping(String[] sentence, int rows, int cols) {
		int currRow = 0;
		int currWidth = 0;
		int count = 0;
		int index = 0;
		while (currRow < rows) {
			if (index == 0 || currWidth == 0) {
				currWidth += sentence[index].length();
			} else {
				currWidth += sentence[index].length() + 1;
			}

			if (currWidth >= cols-1) {
				if (currWidth == cols-1) {
					currWidth = 0;
				} else {
					currWidth = sentence[index].length();
				}
				currRow++;
			}
			index++;
			
			if (index == sentence.length) {
				count++;
				index = 0;
			}
		}
		return count;
	}

}
