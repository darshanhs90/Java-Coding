package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0271EncodeAndDecodeStrings {

	public static void main(String[] args) {

		Codec codec = new Codec();
		System.out
				.println(codec.decode(codec.encode(new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "sss", "f")))));

	}

	public static class Codec {

		// Encodes a list of strings to a single string.
		public String encode(List<String> strs) {
		}

		// Decodes a single string to a list of strings.
		public List<String> decode(String s) {
		}
	}
}
