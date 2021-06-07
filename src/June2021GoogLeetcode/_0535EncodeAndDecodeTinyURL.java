package June2021GoogLeetcode;

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
			int hashCode = longUrl.hashCode();
			map.put(hashCode, longUrl);
			return "http://tinyurl.com/" + hashCode;
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			int hashCode = Integer.parseInt(shortUrl.substring(19));
			return map.get(hashCode);
		}
	}

}
