package models;

import java.util.ArrayList;

public class Tweet {
    private static int idCounter = 0;
    private int id;
    private User user;
    private String message;

    private ArrayList<User> likes;

    public Tweet(User user, String message) {
        this.id = Tweet.idCounter++;
        this.user = user;
        this.message = message;
        likes = new ArrayList<User>();
    }

    public void like(User user) {
        likes.add(user);
    }

    public void unlike(User user) {
        likes.remove(user);
    }

    public String toString() {
        StringBuffer data = new StringBuffer();
        data.append(this.id + ":" + this.user + "( " + this.message + " )");
        if(this.likes.size() == 0)
            return data.toString();
        data.append(" [ ");
        for(User user : this.likes)
            data.append(user + " ");
        data.append("]\n");

        return data.toString();
    }


}
