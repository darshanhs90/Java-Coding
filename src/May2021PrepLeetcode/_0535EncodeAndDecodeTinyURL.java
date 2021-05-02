package May2021PrepLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _0535EncodeAndDecodeTinyURL {

	public static void main(String[] args) {
		Codec codec = new Codec();
		System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
	}

	public static class Codec {
		Map<Integer, String> map = new HashMap<>();

		public String encode(String longUrl) {
			map.put(longUrl.hashCode(), longUrl);
			return "http://tinyurl.com/" + longUrl.hashCode();
		}

		public String decode(String shortUrl) {
			return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
		}
	}

}
