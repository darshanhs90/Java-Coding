package May2021GoogLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _0388LongestAbsoluteFilePath {

	public static void main(String[] args) {
		System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
		System.out.println(lengthLongestPath(
				"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

		System.out.println(lengthLongestPath("a"));
		System.out.println(lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
	}

	public static int lengthLongestPath(String input) {
	
	}

	public static int lengthLongestPath2(String input) {

		if (input == null || input.isEmpty())
			return 0;

		int maxLength = 0; // if may possible the string does not contain any file at all hence 0

		// to keep the length of every sub-dir at same level. It stores length of string
		// at each level
		Map<Integer, Integer> levelVsLength = new HashMap<Integer, Integer>();

		levelVsLength.putIfAbsent(0, 0); // empty level will have 0 length string

		// 1. Split the string by '\n'
		String[] string = input.split("\n");

		for (String s : string) {

			// 2. Find the last index of '\t' { last because a sub-string may contain
			// multiple '\t' but as above question they effectively a single sub-dir or
			// file}
			int tabIndexLevel = s.lastIndexOf('\t') + 1; // this will return the index of '\' if '\t' present, to make
															// index of '\t' we add 1. It also play well when there is
															// no '\t' then it makes level 0

			// 3. Compute the remaining length of string without '\t'
			int len = s.length() - tabIndexLevel;

			// 4. Check does this is a file or not
			if (!s.contains(".")) {
				// a) if a sub-dir, than append its length to just higher level sub-dir
				levelVsLength.put(tabIndexLevel + 1, levelVsLength.get(tabIndexLevel) + len + 1);
			} else {
				// b) if its a file, compute the length of string for this file. To compute, get
				// the level at this file is and add the length of the file
				maxLength = Math.max(maxLength, levelVsLength.get(tabIndexLevel) + len);
			}
		}
		return maxLength;

	}

}
