package FB;

import java.util.LinkedList;
import java.util.List;

public class Post  {
    private long idPost;
    private String post;
    private long likes =0;
    private List<String> comments;
    private List<Integer> idUsersWhoLiked;
    private  long numberOfComments=0;
    public Post(String post , long id) {
        this.post=post;
        this.idPost=id;
        comments=new LinkedList<>();
        idUsersWhoLiked=new LinkedList<>();
    }
    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public long getIdPost() {
        return idPost;
    }
    public boolean liked(int from){
       return !idUsersWhoLiked.contains(from);
    }

    public void addLike(int from){
        this.idUsersWhoLiked.add(from);
        this.likes++;
    }
    public void addComments(String comments,int from){
        this.comments.add(comments+" < Comment from IdUser= "+from+" > ");
        numberOfComments++;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", post='" + post + '\'' +
                ", likes=" + likes +
                ", numberOfComments=" + numberOfComments +
                ", comments=" + comments +
                '}';
    }
}
