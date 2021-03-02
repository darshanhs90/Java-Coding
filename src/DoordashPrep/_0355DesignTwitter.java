package DoordashPrep;

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
		int tweetId, timeStamp;

		public Tweet(int tweetId, int timeStamp) {
			this.tweetId = tweetId;
			this.timeStamp = timeStamp;
		}
	}

	static class Twitter {
		HashMap<Integer, HashSet<Integer>> followersMap;
		HashMap<Integer, List<Tweet>> tweetsMap;
		int tweetTimeStamp;

		/** Initialize your data structure here. */
		public Twitter() {
			followersMap = new HashMap<Integer, HashSet<Integer>>();
			tweetsMap = new HashMap<Integer, List<Tweet>>();
			tweetTimeStamp = 0;
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			if (!followersMap.containsKey(userId)) {
				followersMap.put(userId, new HashSet<Integer>());
				followersMap.get(userId).add(userId);
				tweetsMap.put(userId, new ArrayList<Tweet>());
			}
			tweetsMap.get(userId).add(new Tweet(tweetId, tweetTimeStamp++));
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
		 * the news feed must be posted by users who the user followed or by the user
		 * herself. Tweets must be ordered from most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			if (!tweetsMap.containsKey(userId)) {
				return new ArrayList<Integer>();
			}
			List<Tweet> tweets = new ArrayList<Tweet>();
			HashSet<Integer> followers = followersMap.get(userId);
			Iterator<Integer> iter = followers.iterator();
			while (iter.hasNext()) {
				tweets.addAll(tweetsMap.get(iter.next()));
			}

			Collections.sort(tweets, new Comparator<Tweet>() {

				@Override
				public int compare(Tweet o1, Tweet o2) {
					// TODO Auto-generated method stub
					return o2.timeStamp - o1.timeStamp;
				}
			});

			List<Integer> output = new ArrayList<Integer>();
			for (int i = 0; i < Math.min(tweets.size(), 10); i++) {
				output.add(tweets.get(i).tweetId);
			}
			return output;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (!followersMap.containsKey(followerId)) {
				followersMap.put(followerId, new HashSet<Integer>());
				followersMap.get(followerId).add(followerId);
				tweetsMap.put(followerId, new ArrayList<Tweet>());
			}

			if (!followersMap.containsKey(followeeId)) {
				followersMap.put(followeeId, new HashSet<Integer>());
				followersMap.get(followeeId).add(followeeId);
				tweetsMap.put(followeeId, new ArrayList<Tweet>());
			}

			if (followerId != followeeId) {
				followersMap.get(followerId).add(followeeId);
			}
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (followersMap.containsKey(followerId) && followersMap.get(followerId).contains(followeeId)
					&& followerId != followeeId) {
				followersMap.get(followerId).remove(followeeId);
			}

		}
	}

}
