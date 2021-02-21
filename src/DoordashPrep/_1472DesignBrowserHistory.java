package DoordashPrep;

import java.util.Stack;

public class _1472DesignBrowserHistory {
	public static void main(String[] args) {
		BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
		browserHistory.visit("google.com"); // You are in "leetcode.com". Visit "google.com"
		browserHistory.visit("facebook.com"); // You are in "google.com". Visit "facebook.com"
		browserHistory.visit("youtube.com"); // You are in "facebook.com". Visit "youtube.com"
		System.out.println(browserHistory.back(1)); // You are in "youtube.com", move back to "facebook.com" return
													// "facebook.com"
		System.out.println(browserHistory.back(1)); // You are in "facebook.com", move back to "google.com" return
													// "google.com"
		System.out.println(browserHistory.forward(1)); // You are in "google.com", move forward to "facebook.com" return
														// "facebook.com"
		browserHistory.visit("linkedin.com"); // You are in "facebook.com". Visit "linkedin.com"
		System.out.println(browserHistory.forward(2)); // You are in "linkedin.com", you cannot move forward any steps.
		System.out.println(browserHistory.back(2)); // You are in "linkedin.com", move back two steps to "facebook.com"
													// then to
		// "google.com". return "google.com"
		System.out.println(browserHistory.back(7)); // You are in "google.com", you can move back only one step to
													// "leetcode.com".
		// return "leetcode.com"
	}

	static class BrowserHistory {
		Stack<String> backStack;
		String currentUrl;
		Stack<String> forwardStack;

		public BrowserHistory(String homepage) {
			this.backStack = new Stack<String>();
			this.forwardStack = new Stack<String>();
			this.currentUrl = homepage;
		}

		public void visit(String url) {
			this.backStack.add(this.currentUrl);
			this.currentUrl = url;
			this.forwardStack.clear();
		}

		public String back(int steps) {
			while(!backStack.isEmpty() && steps>0)
			{
				forwardStack.push(this.currentUrl);
				this.currentUrl = backStack.pop();
				steps--;
			}
			return this.currentUrl;
		}

		public String forward(int steps) {
			while(!forwardStack.isEmpty() && steps>0)
			{
				backStack.push(this.currentUrl);
				this.currentUrl = forwardStack.pop();
				steps--;
			}
			return this.currentUrl;
		}
	}
}
