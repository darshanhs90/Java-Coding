package Oct2023Leetcode;

public class _0388LongestAbsoluteFilePath {

	public static void main(String[] args) {
		System.out.println(lengthLongestPath("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext"));
		System.out.println(lengthLongestPath(
				"dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));

		System.out.println(lengthLongestPath("a"));
		System.out.println(lengthLongestPath("file1.txt\\nfile2.txt\\nlongfile.txt"));
	}

	public static int lengthLongestPath(String input) {

	}

}
