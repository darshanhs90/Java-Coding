package Jan2021Leetcode;

import java.util.HashMap;

public class _0535EncodeAndDecodeTinyURL {

	public static void main(String[] args) {
		Codec codec = new Codec();
		System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
	}

	public static class Codec {
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		// Encodes a URL to a shortened URL.
		public String encode(String longUrl) {
			int val = longUrl.hashCode();
			map.put(val, longUrl);
			return "http://tinyurl.com/" + val;
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			shortUrl = shortUrl.replace("http://tinyurl.com/", "");
			return map.get(Integer.parseInt(shortUrl));
		}
	}

}
