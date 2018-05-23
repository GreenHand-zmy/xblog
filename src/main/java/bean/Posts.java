package bean;


import java.util.Date;

/**
 * Created by lfy on 2018/5/21.
 */
public class Posts {
    private long id;//博客编号
    private long authorId;//作者
    private int comments;//评论数
    private Date created;//创建时间
    private int favors;//喜欢数
    private int featured;//推荐状态
    private int channelId;//频道编号
    private int status;//文章状态
    private String title;//标题
    private int views;//阅读数
    private int weight;//置顶
    // 文章内容
    private String content;

    public Posts() {
    }

    public Posts(long authorId, int comments, Date created, String editor, int favors, int featured, int channelId, int status, String summary, String tags, String title, int views, int weight) {
        this.authorId = authorId;
        this.comments = comments;
        this.created = created;
        this.favors = favors;
        this.featured = featured;
        this.channelId = channelId;
        this.status = status;
        this.title = title;
        this.views = views;
        this.weight = weight;
    }

    public Posts(long id, int featured, int channelId, int status, String summary, String tags, String title, int weight) {
        this.id = id;
        this.featured = featured;
        this.channelId = channelId;
        this.status = status;
        this.title = title;
        this.weight = weight;
    }

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
