class Twitter {
    int timestamp = 0;
    class Pair{
        int tweetId;
        int time;
        public Pair(int tweetId, int time){
            this.time = time;
            this.tweetId = tweetId;
        }
    }
    HashMap<Integer, HashSet<Integer>> follows = new HashMap<>();
    HashMap<Integer, ArrayList<Pair>> tweets = new HashMap<>();
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Pair(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        int count = 0;
        if(tweets.containsKey(userId)){
            for(int i = tweets.get(userId).size() - 1; i >= 0 && count < 10; i--, count++){
                pq.offer(new Pair(tweets.get(userId).get(i).tweetId, tweets.get(userId).get(i).time));
            }
        }
        
        if(follows.containsKey(userId)){
            for(int followers : follows.get(userId)){
                count = 0;
                if(tweets.containsKey(followers)){
                    for(int i = tweets.get(followers).size() - 1; i >= 0 && count < 10; i--, count++){
                        pq.offer(new Pair(tweets.get(followers).get(i).tweetId, tweets.get(followers).get(i).time));
                    }
                }
            }
        }

        count = 0;
        while(!pq.isEmpty() && count < 10){
            ans.add(pq.poll().tweetId);
            count++;
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
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