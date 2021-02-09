package util;

import java.util.ArrayList;

import models.Tweet;
import models.User;

public class TweetGenerator {
    ArrayList<Tweet> repository;

    public TweetGenerator(ArrayList<Tweet> repository) {
        this.repository = repository;
    }

    public Tweet create(User user, String message) {
        Tweet newTweet = new Tweet(user, message);
        this.repository.add(newTweet);
        return newTweet;
    }
}
