package May2021GoogLeetcode;

public class _0158ReadNCharactersGivenRead4IICallMultipleTimes {

	public static void main(String[] args) {

	}

	abstract class Reader4 {
		abstract int read4(char[] buf4);
	}

	public class Solution extends Reader4 {

		@Override
		int read4(char[] buf4) {
			// TODO Auto-generated method stub
			return 0;
		}

		/**
		 * @param buf Destination buffer
		 * @param n   Number of characters to read
		 * @return The number of actual characters read
		 */
		int prevIndex = -1;
		int prevReadChars = 0;
		char[] buf4 = new char[4];

		public int read(char[] buf, int n) {
			int count = 0;
			while (count < n) {
				if (prevIndex == -1) {
					prevReadChars = read4(buf4);
					if (prevReadChars == 0)
						return count;
					prevIndex = 0;
				} else {
					while (prevIndex < prevReadChars) {
						buf[count++] = buf4[prevIndex++];
						if (count == n)
							return count;
					}
					prevIndex = -1;
				}
			}
			return count;
		}

	}
}
