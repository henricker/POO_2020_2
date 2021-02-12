package models;

import java.util.ArrayList;

public class User {
    private String username;
    private int unreadCount;
    private ArrayList<Tweet> timeline;
    private ArrayList<Tweet> myTweets;
    private ArrayList<User> followers;
    private ArrayList<User> followed;

    public User(String username) {
        this.username = username;
        this.timeline = new ArrayList<Tweet>();
        this.myTweets = new ArrayList<Tweet>();
        this.followers = new ArrayList<User>();
        this.followed = new ArrayList<User>();
        this.unreadCount = 0;
    }

    public void writeTweet(Tweet tweet) {
        this.myTweets.add(tweet);
        this.timeline.add(tweet);
        for(User user : this.followers) {
            user.getTimeline().add(tweet);
            user.setUnreadCount();
        }
    }

    public void likeTweet(int index) {
        Tweet tweet = this.timeline.get(index);
        tweet.like(this);
    }

    public void unlikeTweet(int index) {
        Tweet tweet = this.timeline.get(index);
        if(tweet == null)
            return;
        tweet.unlike(this);
    }

    public ArrayList<Tweet> getUnread() {
        if(this.unreadCount == 0)
            return new ArrayList<Tweet>();
        
        ArrayList<Tweet> unread = new ArrayList<Tweet>();
        for(int i = this.timeline.size() - this.unreadCount; i < this.timeline.size(); i++)
            if(!this.timeline.get(i).equals(this))
                unread.add(this.timeline.get(i));
        
        this.unreadCount = 0;
        return unread;
        
    }

    public void follow(User user) {
        this.followed.add(user);
        user.addFollower(this);
    }

    public void unfollow(User user) {
        this.followed.remove(user);
        user.getFollowers().remove(this);
    }

    public void addFollower(User user) {
        this.followers.add(user);
    }

    public ArrayList<Tweet> getTimeline() {
        this.unreadCount = 0;
        return this.timeline;
    }

    public ArrayList<User> getFollowers() {
        return this.followers;
    }

    public ArrayList<User> getFolloweds() {
        return this.followed;
    }

    public void setUnreadCount() {
        this.unreadCount++;
    }

    public String toString() {
        return this.username;
    }
}
