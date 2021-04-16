package April2021Leetcode;

public class _0158ReadNCharactersGivenRead4IICallMultipleTimes {

	class Reader4 {
		int read4(char[] buf4) {
			return 0;
		}
	}

	public class Solution extends Reader4 {
		/**
		 * @param buf Destination buffer
		 * @param n   Number of characters to read
		 * @return The number of actual characters read
		 */
		int prevIndex = 0;
		char[] prevBuf = new char[4];
		int prevSize = 0;

		public int read(char[] buf, int n) {
			int counter = 0;
			while (counter < n) {
				if (prevIndex < prevSize) {
					buf[counter++] = prevBuf[prevIndex++];
				} else {
					prevIndex = 0;
					prevSize = read4(prevBuf);
					if (prevSize == 0)
						break;
					buf[counter++] = prevBuf[prevIndex++];
				}
			}
			return counter;
		}
	}

}
