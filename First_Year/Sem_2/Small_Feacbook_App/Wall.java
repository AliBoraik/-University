package FB;

import java.util.LinkedList;
import java.util.List;

public class Wall {
    public List<Post> posts;
    public Wall(){
     this.posts=new LinkedList<>();
    }
    protected void addPost(Post newPost){
        this.posts.add(newPost);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "posts=" + posts +
                '}';
    }
}
