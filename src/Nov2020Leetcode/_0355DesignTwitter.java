package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0355DesignTwitter {

	public static void main(String[] args) {
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		System.out.println(twitter.getNewsFeed(1));

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		System.out.println(twitter.getNewsFeed(1));

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		System.out.println(twitter.getNewsFeed(1));

	}

	static class Tweet {
		int id;
		int postedBy;

		public Tweet(int id, int postedBy) {
			this.id = id;
			this.postedBy = postedBy;
		}
	}

	static class User {
		int id;
		List<Integer> followers;

		public User(int id) {
			this.id = id;
			this.followers = new ArrayList<Integer>();
		}
	}

	static class Twitter {
		List<User> users;
		List<Tweet> tweets;
		HashMap<Integer, User> userMap = new HashMap<Integer, User>();

		/** Initialize your data structure here. */
		public Twitter() {
			this.users = new ArrayList<User>();
			this.tweets = new ArrayList<Tweet>();
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			if (!userMap.containsKey(userId)) {
				User user = new User(userId);
				user.followers.add(userId);
				userMap.put(userId, user);
				this.users.add(user);
			}
			this.tweets.add(new Tweet(tweetId, userId));
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
		 * the news feed must be posted by users who the user followed or by the user
		 * herself. Tweets must be ordered from most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			List<Integer> tweets = new ArrayList<Integer>();
			if (userMap.containsKey(userId)) {
				List<Integer> followers = userMap.get(userId).followers;
				for (int i = this.tweets.size() - 1; i >= 0; i--) {
					if (tweets.size() >= 10)
						break;
					Tweet tweet = this.tweets.get(i);
					if (followers.indexOf(tweet.postedBy) > -1) {
						tweets.add(tweet.id);
					}
				}
			}
			return tweets;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (!userMap.containsKey(followerId)) {
				User user = new User(followerId);
				user.followers.add(followerId);
				userMap.put(followerId, user);
				this.users.add(user);
			}
			if (!userMap.containsKey(followeeId)) {
				User user = new User(followeeId);
				user.followers.add(followeeId);
				userMap.put(followeeId, user);
				this.users.add(user);
			}
			userMap.get(followerId).followers.add(followeeId);
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (userMap.containsKey(followerId) && userMap.containsKey(followeeId) && followerId != followeeId)
				userMap.get(followerId).followers.remove(Integer.valueOf(followeeId));
		}
	}

}
