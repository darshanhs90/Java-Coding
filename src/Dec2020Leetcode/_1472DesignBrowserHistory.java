package Dec2020Leetcode;

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
		Stack<String> backwardUrl;
		Stack<String> forwardUrl;
		String currentUrl = null;

		public BrowserHistory(String homepage) {
			this.backwardUrl = new Stack<String>();
			this.forwardUrl = new Stack<String>();
			this.currentUrl = homepage;
		}

		public void visit(String url) {
			if (this.currentUrl != null) {
				this.backwardUrl.add(this.currentUrl);
			}
			this.currentUrl = url;
			this.forwardUrl.clear();
		}

		public String back(int steps) {
			int count = steps;
			while (count >= 1 && !this.backwardUrl.isEmpty()) {
				this.forwardUrl.push(this.currentUrl);
				this.currentUrl = this.backwardUrl.pop();
				count--;
			}
			return this.currentUrl;
		}

		public String forward(int steps) {
			int count = steps;
			while (count >= 1 && !this.forwardUrl.isEmpty()) {
				this.backwardUrl.push(this.currentUrl);
				this.currentUrl = this.forwardUrl.pop();
				count--;
			}
			return this.currentUrl;
		}
	}
}
