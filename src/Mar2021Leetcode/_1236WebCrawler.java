package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _1236WebCrawler {

	public static void main(String[] args) {

		System.out.println(getHostName("http://news.yahoo.com/news"));

	}

	interface HtmlParser {
		public List<String> getUrls(String url);
	}

	public static List<String> crawl(String startUrl, HtmlParser htmlParser) {
		String rootHostName = getHostName(startUrl);
		HashSet<String> output = new HashSet<String>();
		dfs(startUrl, rootHostName, htmlParser, output);
		return new ArrayList<String>(output);
	}
	
	public static void dfs(String startUrl, String rootHostName, HtmlParser htmlParser, HashSet<String> visited) {
		if(visited.contains(startUrl))
			return;
		
		visited.add(startUrl);
		List<String> list = htmlParser.getUrls(startUrl);
		for(String str: list)
		{
			if(getHostName(str).equals(rootHostName))
			{
				dfs(str, rootHostName, htmlParser, visited);
			}
		}
	}

	private static String getHostName(String url) {
		String[] parts = url.split("/");
		return parts[2];
	}
}
