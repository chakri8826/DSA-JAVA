import java.util.*;

class Tweet{
    int time,id;
    public Tweet(int time,int id){
        this.time=time;
        this.id=id;
    }
}

class TweetNode{
    Tweet tweet;
    int userId;
    int ind;

    TweetNode(Tweet t, int userId, int idx) { 
        this.tweet = t; this.userId = userId; this.ind = idx;
    }
}

class H10DesignTwitter {
    Map<Integer,List<Tweet>> tweets;
    Map<Integer,Set<Integer>> followMap;
    int time;

    public H10DesignTwitter() {
        tweets = new HashMap<>();
        followMap = new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(time++,tweetId));
    }
    
    // BRUTE    
    // Brute force	TC-> O(N log N)	 SC->O(N)

    // public List<Integer> getNewsFeed(int userId) {
    //     List<Tweet> allTweets = new ArrayList<>();
    
    //     // Add self
    //     if (tweets.containsKey(userId)) {
    //         allTweets.addAll(tweets.get(userId));
    //     }
    
    //     // Add followees
    //     if (followMap.containsKey(userId)) {
    //         for (int followeeId : followMap.get(userId)) {
    //             if (tweets.containsKey(followeeId)) {
    //                 allTweets.addAll(tweets.get(followeeId));
    //             }
    //         }
    //     }
    
    //     // Sort tweets by time (latest first)  (SORTS ALL TWEETS N TWEETS)
    //     allTweets.sort((a, b) -> b.time - a.time);
    
    //     // Collect up to 10 tweet IDs
    //     List<Integer> feed = new ArrayList<>();
    //     for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
    //         feed.add(allTweets.get(i).id);
    //     }
    
    //     return feed;
    // }
    

    // TC->O(F log F) (f MATHRAME SORT AVUTHAY AS WE PUSH ONLY ONE TWEET PER USER)   SC-> O(F) 
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<TweetNode> pq = new PriorityQueue<>((a,b)->Integer.compare(b.tweet.time,a.tweet.time));
        
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if(followMap.containsKey(userId)){
            users.addAll(followMap.get(userId));
        }

        for(int uId:users){
            if(tweets.containsKey(uId)){
                List<Tweet> tweetsList = tweets.get(uId);
                int lastInd = tweetsList.size()-1;
                pq.add(new TweetNode(tweetsList.get(lastInd),uId,lastInd));
            }
        }

        while(!pq.isEmpty() && feed.size()<10){
            TweetNode node = pq.poll();
            feed.add(node.tweet.id);

            if(node.ind>0){
                int prevInd = node.ind-1;
                Tweet prevTweet = tweets.get(node.userId).get(prevInd);
                pq.add(new TweetNode(prevTweet,node.userId,prevInd));
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}