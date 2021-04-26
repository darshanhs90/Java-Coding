package April2021PrepLeetcode;

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

		char[] prevBuf = new char[4];
		int prevBufChars = 0;
		int prevBufIndex = 0;


		public int read(char[] buf, int n) {
			int index = 0;
			while (index < n) {
				if (prevBufIndex >= prevBufChars) {
					prevBufChars = read4(prevBuf);
					prevBufIndex = 0;
					if(prevBufChars == 0)
						return index;
				} else {
					buf[index++] = prevBuf[prevBufIndex++];
				}
			}
			return index;
		}

	}
}
