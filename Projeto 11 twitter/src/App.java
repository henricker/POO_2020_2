
import java.util.ArrayList;

import models.*;
import controller.TwitterController;

public class App {
    public static void main(String[] args) throws Exception {
        TwitterController tc = new TwitterController();

        tc.addUser("henricker");
        tc.addUser("ana");
        tc.follow("henricker", "ana");
        tc.follow("ana", "henricker");
        tc.addTweet("henricker", "kkkk tlgd");
        tc.addTweet("ana", "eoq mah");
        tc.likeTweet("ana", 0);
        tc.unlike("henricker", 1);
        
        tc.addTweet("ana", "quero caféeeeeeeeeeeeeeeee");
        System.out.println(tc.timeline("henricker"));
        System.out.println(tc.show());
        // // // // // // // ArrayList<Tweet> repository = new ArrayList<Tweet>();
        // // // // // // // TweetGenerator gen = new TweetGenerator(repository);
        // // // // // // // User goku = new User("goku");
        // // // // // // // User sara = new User("sara");
        // // // // // // // User tina = new User("tina");

        // // // // // // // goku.follow(sara);
        // // // // // // // goku.follow(tina);
        // // // // // // // sara.follow(tina);

        // // // // // // // sara.writeTweet(gen.create(sara, "estou muito triste hoje"));
        // // // // // // // tina.writeTweet(gen.create(tina, "ganhei chocolate"));
        // // // // // // // sara.writeTweet(gen.create(sara, "partiu ru"));
        // // // // // // // tina.writeTweet(gen.create(tina, "chocolate ruim"));
        // // // // // // // goku.writeTweet(gen.create(goku, "internet maldita"));

        // // // // // // // repository.get(1).like(sara);
        // // // // // // // repository.get(1).like(goku);
        // // // // // // // repository.get(3).like(sara);

        // // // // // // // System.out.println(sara.getUnread());
        // // // // // // // System.out.println(goku.getUnread());

        // // // // // // // System.out.println(sara.getUnread());
        // // // // // // // System.out.println(goku.getUnread());


    }
}
