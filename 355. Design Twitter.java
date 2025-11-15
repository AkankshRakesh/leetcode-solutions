class Twitter {
    class Pair{
        int time;
        int tweetId;
        public Pair(int time, int tweetId){
            this.time = time;
            this.tweetId = tweetId;
        }
    }
    HashMap<Integer, ArrayList<Pair>> userTweets = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> userFollows = new HashMap<>();
    int time = 0;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userTweets.containsKey(userId)){
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(new Pair(time, tweetId));
            userTweets.put(userId, arr);
        }    
        else{
            userTweets.get(userId).add(new Pair(time, tweetId));
        }
        if(!userFollows.containsKey(userId)){
            ArrayList<Integer> follows = new ArrayList<>();
            follows.add(userId);
            userFollows.put(userId, follows);
        }
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        if (!userFollows.containsKey(userId)) return ans;

        ArrayList<Integer> follows = userFollows.get(userId);

        int[] inds = new int[follows.size()];
        for(int i = 0; i < follows.size(); i++){
            ArrayList<Pair> tweets = userTweets.get(follows.get(i));
            if (tweets == null || tweets.size() == 0) {
                inds[i] = -1;
            } else {
                inds[i] = tweets.size() - 1;
            }
        }
        while(ans.size() != 10){
            int mostRecentId = -1;
            int mostRecentIdTime = -1;
            int userSelected = -1;

            for(int i = 0; i < follows.size(); i++){
                ArrayList<Pair> tweets = userTweets.get(follows.get(i));
                if(inds[i] >= 0){
                    if(tweets.get(inds[i]).time > mostRecentIdTime){
                        mostRecentIdTime = tweets.get(inds[i]).time;
                        mostRecentId = tweets.get(inds[i]).tweetId;
                        userSelected = i;
                    }
                }
            }

            if(mostRecentId == -1) break;
            inds[userSelected]--;
            ans.add(mostRecentId);
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollows.putIfAbsent(followerId, new ArrayList<>());
        ArrayList<Integer> follows = userFollows.get(followerId);

        if (!follows.contains(followerId)) follows.add(followerId);

        if (!follows.contains(followeeId)) follows.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollows.get(followerId).remove((Integer)followeeId);
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