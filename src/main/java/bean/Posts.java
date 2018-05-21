package bean;


import java.util.Date;

/**
 * Created by lfy on 2018/5/21.
 */
public class Posts {
    //博客编号
    private long id;

    //作者
    private long authorId;

    //评论数
    private int comments;

    //创建时间
    private Date created;

    //编辑器
    private String editor;

    //喜欢数
    private int favors;

    //推荐状态
    private int featured;

    //频道编号
    private int channelId;

    //文章状态
    private int status;

    //摘要
    private String summary;

    //标签
    private String tags;

    //标题
    private String title;

    //阅读数
    private int views;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getFavors() {
        return favors;
    }

    public void setFavors(int favors) {
        this.favors = favors;
    }

    public int getFeatured() {
        return featured;
    }

    public void setFeatured(int featured) {
        this.featured = featured;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
