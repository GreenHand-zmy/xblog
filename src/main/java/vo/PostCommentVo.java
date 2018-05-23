package vo;

import bean.Comment;
import bean.Posts;

/**
 * Created by zmy on 2018/5/23.
 */
public class PostCommentVo {
    // 文章
    private Posts posts;

    // 评论
    private Comment comment;

    public PostCommentVo() {
    }

    public PostCommentVo(Posts posts, Comment comment) {
        this.posts = posts;
        this.comment = comment;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
