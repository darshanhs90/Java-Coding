package April2021PrepLeetcode;

import java.util.List;

public class _1236WebCrawler {

	public static void main(String[] args) {

	}

	interface HtmlParser {
		public List<String> getUrls(String url);
	}

	public static List<String> crawl(String startUrl, HtmlParser htmlParser) {
	}
}
