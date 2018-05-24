package vo;

import bean.Comment;
import bean.Post;

/**
 * Created by zmy on 2018/5/23.
 */
public class PostCommentVo {
    // 文章
    private Post post;

    // 评论
    private Comment comment;

    public PostCommentVo() {
    }

    public PostCommentVo(Post post, Comment comment) {
        this.post = post;
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
