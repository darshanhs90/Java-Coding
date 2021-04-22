package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0355DesignTwitter {

	public static void main(String[] args) {
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		// System.out.println(twitter.getNewsFeed(1));

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
		int tweetId;
		int id;

		public Tweet(int tweetId, int id) {
			this.tweetId = tweetId;
			this.id = id;
		}
	}

	static class Twitter {
		HashMap<Integer, HashSet<Integer>> userFollowerMap;
		HashMap<Integer, List<Tweet>> userTweetMap;
		int id;

		/** Initialize your data structure here. */
		public Twitter() {
			this.userFollowerMap = new HashMap<Integer, HashSet<Integer>>();
			this.userTweetMap = new HashMap<Integer, List<Tweet>>();
			this.id = 0;
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			if (!userFollowerMap.containsKey(userId)) {
				userFollowerMap.put(userId, new HashSet<Integer>());
				userFollowerMap.get(userId).add(userId);
				userTweetMap.put(userId, new ArrayList<Tweet>());
			}
			Tweet tweet = new Tweet(tweetId, id++);
			userTweetMap.get(userId).add(tweet);
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
		 * the news feed must be posted by users who the user followed or by the user
		 * herself. Tweets must be ordered from most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			if (!userFollowerMap.containsKey(userId))
				return new ArrayList<Integer>();
			Iterator<Integer> iter = userFollowerMap.get(userId).iterator();
			List<Tweet> tweets = new ArrayList<Tweet>();
			while (iter.hasNext()) {
				tweets.addAll(userTweetMap.get(iter.next()));
			}

			Collections.sort(tweets, new Comparator<Tweet>() {

				@Override
				public int compare(Tweet o1, Tweet o2) {
					// TODO Auto-generated method stub
					return o2.id - o1.id;
				}
			});

			List<Integer> out = new ArrayList<Integer>();
			for (int i = 0; i < Math.min(10, tweets.size()); i++) {
				out.add(tweets.get(i).tweetId);
			}
			return out;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (!userFollowerMap.containsKey(followerId)) {
				userFollowerMap.put(followerId, new HashSet<Integer>());
				userFollowerMap.get(followerId).add(followerId);
				userTweetMap.put(followerId, new ArrayList<Tweet>());

			}

			if (!userFollowerMap.containsKey(followeeId)) {
				userFollowerMap.put(followeeId, new HashSet<Integer>());
				userFollowerMap.get(followeeId).add(followeeId);
				userTweetMap.put(followeeId, new ArrayList<Tweet>());
			}

			if (!userFollowerMap.get(followerId).contains(followeeId))
				userFollowerMap.get(followerId).add(followeeId);
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (!userFollowerMap.containsKey(followerId)) {
				return;
			}

			if (!userFollowerMap.containsKey(followeeId)) {
				return;
			}

			if (followerId == followeeId)
				return;

			if (!userFollowerMap.get(followerId).contains(followeeId))
				return;
			userFollowerMap.get(followerId).remove(Integer.valueOf(followeeId));
		}
	}

}
