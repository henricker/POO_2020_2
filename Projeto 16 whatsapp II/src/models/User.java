package models;

import java.util.TreeMap;

public class User {
    private String userId;
    private TreeMap<String, Chat> chats;

    public User(String userId) {
        this.userId = userId;
        this.chats = new TreeMap<String, Chat>();
    }

    public String getChatsString() {
        StringBuilder sb = new StringBuilder();

        this.chats.values().forEach(chat -> {
            sb.append("    - " + chat + "\n");
        });

        return sb.toString();
    }

    public TreeMap<String, Chat> getchats() {
        return this.chats;
    }

    public String getNotify() {
        StringBuilder sb = new StringBuilder();

        this.chats.values().forEach(chat -> {
            sb.append("    - "+ chat.getInboxNotify(this.userId) + "\n");
        });

        return sb.toString();
    }

    public String getUserId() {
        return this.userId;
    }

}
