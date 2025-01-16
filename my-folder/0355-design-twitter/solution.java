class Twitter {
    List<int[]> tweets = new ArrayList<>();
    Set<Integer>[] set = new HashSet[501];

    public Twitter() {
        for(int i = 1; i <= 500; i++){
            set[i] = new HashSet<Integer>();
            set[i].add(i);
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<Integer>();
        int t = 0;
        for(int i = tweets.size() - 1; i >= 0; i--){
            if(set[userId].contains(tweets.get(i)[0])){
                t++;
                feed.add(tweets.get(i)[1]);
                if(t == 10) return feed;
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        set[followerId].add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        set[followerId].remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
