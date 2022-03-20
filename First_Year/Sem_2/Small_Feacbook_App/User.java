package FB;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class User extends Wall {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private Date birthday;
    private String City;
    private List<User> subscriptions;
    public Wall wallPost;
    public User(int id, String first_name, String last_name, String email, String gender, Date birthday, String city) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        City = city;
        subscriptions=new LinkedList<>();
        wallPost=new Wall();
    }
    public String getFirst_name() {
        return first_name;
    }

    public boolean setLikeOnPost(long idPost,int from){
        for (User subscription : subscriptions) {
            Wall u = subscription.wallPost;
            for (int j = 0; j < u.posts.size(); j++) {
                Post postsInWall = u.posts.get(j);
                if (postsInWall.getIdPost() == idPost) {
                    if (postsInWall.liked(from)) {
                        postsInWall.addLike(from);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean setCommentsOnPost(long idPost, String comment, int from){
        for (User subscription : subscriptions) {
            Wall u = subscription.wallPost;
            for (int j = 0; j < u.posts.size(); j++) {
                Post postsInWall = u.posts.get(j);
                if (postsInWall.getIdPost() == idPost) {
                    postsInWall.addComments(comment, from);
                    return true;
                }
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return City;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }
    public void addSubscriptions(User newUser){
        this.subscriptions.add(newUser);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", City='" + City + '\'' +
//                ", subscriptions=" + subscriptions +
                '}';
    }
}
