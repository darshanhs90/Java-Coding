package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1236WebCrawler {

	public static void main(String[] args) {
		System.out.println(getHostName("http://leetcode.com/contest"));
	}

	interface HtmlParser {
		public List<String> getUrls(String url);
	}

	public static List<String> crawl(String startUrl, HtmlParser htmlParser) {
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> output = new HashSet<String>();
		String baseHostName = getHostName(startUrl);
		Queue<String> q = new LinkedList<String>();
		q.offer(startUrl);
		visited.add(startUrl);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				output.add(str);

				List<String> list = htmlParser.getUrls(str);
				for (String newUrl : list) {
					if (visited.contains(newUrl) || !getHostName(newUrl).equals(baseHostName)) {
						continue;
					}
					visited.add(newUrl);
					q.offer(newUrl);
				}

			}
		}
		return new ArrayList<String>(output);
	}

	public static String getHostName(String url) {
		String[] parts = url.split("/");
		return parts[0] + "/" + parts[1] + "/" + parts[2];
	}
}
