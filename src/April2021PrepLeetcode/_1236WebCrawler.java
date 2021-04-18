package April2021PrepLeetcode;

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

		Queue<String> q = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		q.offer(startUrl);
		visited.add(startUrl);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				output.add(str);

				List<String> list = htmlParser.getUrls(str);
				for (String newUrl : list) {
					if (visited.contains(newUrl))
						continue;
					visited.add(newUrl);
					if (!getHostName(newUrl).equals(baseHostName)) {
						continue;
					}

					q.offer(newUrl);
				}
			}
		}

		return output;
	}

	public static String getHostName(String startUrl) {
		String[] splitArr = startUrl.split("/");
		return splitArr[2];
	}
}
