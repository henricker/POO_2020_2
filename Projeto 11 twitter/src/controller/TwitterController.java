package controller;

import java.util.ArrayList;

import exceptions.UserNotFoundException;
import exceptions.UserAlredyExistsException;
import models.Tweet;
import models.User;
import util.TweetGenerator;

public class TwitterController {
    ArrayList<User> users;
    ArrayList<Tweet> tweets;
    TweetGenerator tweetGenerator;

    public TwitterController() {
        this.users = new ArrayList<User>();
        this.tweets = new ArrayList<Tweet>();
        this.tweetGenerator = new TweetGenerator(this.tweets);
    }

    public void addUser(String username) throws UserAlredyExistsException {
        if(this.getUserByName(username) != null)
            throw new UserAlredyExistsException("User already exists!");
        
        User newUser = new User(username);
        this.users.add(newUser);
    }

    public void addTweet(String username, String message) throws UserNotFoundException {
        User user = this.getUserByName(username);

        if(user == null)
            throw new UserNotFoundException("User not found!");
        
        user.writeTweet(tweetGenerator.create(user, message));
    }

    public void follow(String username, String other) throws UserNotFoundException {
        User user = this.getUserByName(username);
        User user2 = this.getUserByName(other);
        
        if(user == null || user2 == null)
            throw new UserNotFoundException("User not found!");
        
        user.follow(user2);        
    }

    public void unfollow(String username, String other) throws UserNotFoundException{
        User user = this.getUserByName(username);
        User user2 = this.getUserByName(other);
        
        if(user == null || user2 == null)
            throw new UserNotFoundException("User not found!");
        
        user.unfollow(user2);
    }

    public void likeTweet(String username, int index) throws UserNotFoundException {
        User user = this.getUserByName(username);

        if(user == null)
            throw new UserNotFoundException("User not found!");
        
        if(index < 0 || index >= this.tweets.size())
            throw new IndexOutOfBoundsException("Invalid id!");
        
        user.likeTweet(index);
    }

    public void unlike(String username, int index) throws UserNotFoundException {
        User user = this.getUserByName(username);

        if(user == null)
            throw new UserNotFoundException("User not found!");
        
        if(index < 0 || index >= this.tweets.size())
            throw new IndexOutOfBoundsException("Invalid id!");
        
        user.unlikeTweet(index);
    }

    public String unread(String username) throws UserNotFoundException {
        User user = this.getUserByName(username);

        if(user == null)
            throw new UserNotFoundException("User not found!");
        
        StringBuilder data = new StringBuilder();

        ArrayList<Tweet> unreadTweets = user.getUnread();
        for(Tweet tweet : unreadTweets)
            data.append(tweet + "\n");
        
        return data.toString();
    }

    public String timeline(String username) throws UserNotFoundException {
        User user = this.getUserByName(username);

        if(user == null)
            throw new UserNotFoundException("User not found!");
        
        StringBuilder data = new StringBuilder();

        ArrayList<Tweet> timelineTweets = user.getTimeline();
        for(Tweet tweet : timelineTweets)
            data.append(tweet + "\n");
        
        return data.toString();
    }

    public String show() { 
        StringBuilder data = new StringBuilder();
        for(User user : this.users) {
            data.append(user + ":\n");
            data.append("    Seguindo: [ ");
            for(User followed : user.getFolloweds())
                data.append(followed + " ");
            data.append("]\n");
            data.append("    Seguidores: [ ");
            for(User follower : user.getFollowers())
                data.append(follower + " ");
            data.append("]\n");
        }
        return data.toString();
    }

    private User getUserByName(String username) {
        for(int i = 0; i < users.size(); i++)
            if(this.users.get(i).toString().equals(username))
                return this.users.get(i);
        return null;
    }
}
