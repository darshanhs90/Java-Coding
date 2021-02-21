package DropboxPrep;

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
		HashSet<String> visited = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		Queue<String> q = new LinkedList<String>();
		
		String domainName = getHostname(startUrl);
		q.offer(startUrl);
		visited.add(startUrl);
		while(!q.isEmpty())
		{
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String url = q.poll();
				list.add(url);
				
				List<String> lst =htmlParser.getUrls(url);
				for (int j = 0; j < lst.size(); j++) {
					String str=  lst.get(j);
					if(!visited.contains(str) && str.contains(domainName))
					{
						visited.add(str);
						q.offer(str);
					}
				}
			}
		}
		return list;
	}
	
    private static String getHostname(String Url) {
        String[] ss = Url.split("/");
        return ss[2];
    }
}
