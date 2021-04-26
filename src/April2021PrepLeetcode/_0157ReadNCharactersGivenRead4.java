package April2021PrepLeetcode;

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

			int index = 0;
			char[] buf4 = new char[4];
			while (index < n) {
				int bufferChars = read4(buf4);
				if(bufferChars == 0)
					return index;
				for (int i = 0; i < bufferChars; i++) {
					buf[index++] = buf4[i];

					if (index == n)
						return index;
				}
			}
			return index;
		}

	}
}
