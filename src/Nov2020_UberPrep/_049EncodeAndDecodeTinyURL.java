package Nov2020_UberPrep;

import java.util.HashMap;

public class _049EncodeAndDecodeTinyURL {

	public static void main(String[] args) {
		Codec codec = new Codec();
		System.out.println(codec.encode("https://www.google.com"));
		System.out.println(codec.decode(codec.encode("https://www.google.com")));
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
			String url = shortUrl.split("http://tinyurl.com/")[1];
			return map.get(Integer.parseInt(url));
		}
	}

}
