package vo;

import bean.Comment;
import bean.User;

public class CommentVo {
    private User user;
    private Comment comment;

    public CommentVo() {
    }

    public CommentVo(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
