package April2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1236WebCrawler {

	public static void main(String[] args) {

	}

	interface HtmlParser {
		public List<String> getUrls(String url);
	}

	public static List<String> crawl(String startUrl, HtmlParser htmlParser) {
		String baseHostName = getHostName(startUrl);
		List<String> output = new ArrayList<String>();
		HashSet<String> visitedUrls = new HashSet<String>();
		visitedUrls.add(startUrl);
		Queue<String> q = new LinkedList<String>();
		q.offer(startUrl);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String currUrl = q.poll();
				output.add(currUrl);

				List<String> urls = htmlParser.getUrls(currUrl);
				for (String newUrl : urls) {
					if (!visitedUrls.contains(newUrl) && getHostName(newUrl).equals(baseHostName)) {
						q.offer(newUrl);
						visitedUrls.add(newUrl);
					}
				}
			}

		}
		return output;
	}

	public static String getHostName(String str) {
		String[] strArr = str.split("/");
		return strArr[2];
	}

}
