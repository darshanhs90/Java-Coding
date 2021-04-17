package April2021Leetcode;

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
		String currUrl;
		Stack<String> forwardStack, backwardStack;

		public BrowserHistory(String homepage) {
			this.currUrl = homepage;
			this.forwardStack = new Stack<String>();
			this.backwardStack = new Stack<String>();
		}

		public void visit(String url) {
			backwardStack.push(this.currUrl);
			this.currUrl = url;
			this.forwardStack.clear();
		}

		public String back(int steps) {
			while (steps > 0 && !this.backwardStack.isEmpty()) {
				this.forwardStack.push(this.currUrl);
				this.currUrl = this.backwardStack.pop();
				steps--;
			}
			return this.currUrl;

		}

		public String forward(int steps) {
			while (steps > 0 && !this.forwardStack.isEmpty()) {
				this.backwardStack.push(this.currUrl);
				this.currUrl = this.forwardStack.pop();
				steps--;
			}
			return this.currUrl;
		}
	}
}
