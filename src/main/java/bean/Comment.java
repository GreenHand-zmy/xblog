package bean;

import java.util.Date;

/**
 * Created by zmy on 2018/5/21.
 */
public class Comment {
    // 评论编号
    private Long id;

    // 评论者编号
    private Long authorId;

    // 评论的内容
    private String content;

    // 评论时间
    private Date created;

    // 评论的状态
    private Integer status;

    // 所评文章
    private Long toId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }
}
