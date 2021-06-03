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
		
	}
}
