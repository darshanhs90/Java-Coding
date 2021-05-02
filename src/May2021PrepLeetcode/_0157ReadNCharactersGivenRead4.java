package May2021PrepLeetcode;

public class _0157ReadNCharactersGivenRead4 {

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
		public int read(char[] buf, int n) {
			int noOfCharsRead = 0;
			char[] buf4 = new char[4];
			while (noOfCharsRead < n) {
				int noOfCharsReturned = read4(buf4);
				if (noOfCharsReturned == 0)
					break;
				for (int i = 0; i < noOfCharsReturned; i++) {
					buf[noOfCharsRead++] = buf4[i];
					if (noOfCharsRead == n)
						return n;
				}

			}
			return noOfCharsRead;
		}

	}
}
