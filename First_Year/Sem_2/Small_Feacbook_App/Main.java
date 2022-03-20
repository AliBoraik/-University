package FB;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocialMedia facebook = new SocialMedia();
        // read the users for file
        facebook.readUsersFromFiles("src/FB/users.txt");
        // read Subscriptions from file
        facebook.readSubscriptionsFromFile("src/FB/Subscriptions");
        // users have subscriptions from ......
        List<User> subscriptionsFromBeijing = facebook.usersHaveSubFrom("Beijing");
        System.out.println(subscriptionsFromBeijing);
        // add posts add set likes the comments
        Post test1=new Post("HelloWorld1",10);
        Post test2=new Post("HelloWorld2",11);
        Post test3=new Post("HelloWorld3",12);
        User user1=facebook.users.get(0);
        User user2= facebook.users.get(1);
        User user3= facebook.users.get(2);
        user1.wallPost.addPost(test1);
        user1.wallPost.addPost(test2);
        user1.wallPost.addPost(test3);
        user2.addSubscriptions(user1);
        System.out.println(user2.setLikeOnPost(10,user2.getId()));
        System.out.println(user2.setLikeOnPost(10,user2.getId()));
        user3.addSubscriptions(user1);
        System.out.println(user3.setLikeOnPost(10,user3.getId()));
        System.out.println(user2.setCommentsOnPost(10," first ",user2.getId()));
        System.out.println(user2.setCommentsOnPost(10," second ",user2.getId()));
        System.out.println(user3.setCommentsOnPost(10," third ",user3.getId()));
        System.out.println(user1.wallPost.toString());

    }
}
