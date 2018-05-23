package Dao.Impl;

import Dao.PostDao;
import bean.Posts;
import utils.DBUtil;

import java.util.List;

/**
 * Created by Fang on 2018/5/21.
 */
public class PostDaoImpl  implements PostDao {

    @Override
    public int addPost(Posts post) {
        String sql="insert into mto_posts (author_id,comments,content,created,editor,favors,featured,channel_id,status,summary,tags,title,views,weight) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return DBUtil.executeUpdate(sql,post.getAuthorId(),post.getComments(),post.getContent(),
                post.getCreated(), post.getEditor(),post.getFavors(),post.getFeatured(),
                post.getChannelId(), post.getStatus(),post.getSummary(),post.getTags(),post.getTitle(),
                post.getViews(),post.getWeight());
    }//添加文章

    @Override
    public int updatePost(Posts post) {
        String sql="update mto_posts set featured=?,status=?,content=?,summary=?,weight=?,channel_id=?,tags=?,title=? where id=?";
        Object[] values={post.getFeatured(),post.getStatus(),post.getContent(),post.getSummary(),post.getWeight(),post.getChannelId(),post.getTags(),post.getTitle(),post.getId()};
        return DBUtil.executeUpdate(sql,values);
    }//修改文章

    @Override
    public int updatePostFavors(Posts post) {
        String sql="update mto_posts set featured=? where id=?";
        Object[] values={post.getFeatured(),post.getId()};
        return DBUtil.executeUpdate(sql,values);
    }

    @Override
    public int updatePostViews(Posts post) {
        String sql="update mto_posts set views=? where id=?";
        Object[] values={post.getViews(),post.getId()};
        return DBUtil.executeUpdate(sql,values);
    }

    @Override
    public int updatePostComments(Posts post) {
        String sql="update mto_posts set comments=? where id=?";
        Object[] values={post.getComments(),post.getId()};
        return DBUtil.executeUpdate(sql,values);
    }

    @Override
    public int deletePost(Long Id) {
        String sql="delete from mto_posts where id=?";
        return DBUtil.executeUpdate(sql, Id);
    }//删除文章

    @Override
    public List<Posts> getPostAuthorId(Long authorId) {
        String sql="select * from mto_posts where author_id = ?";
        return DBUtil.getObjects(sql,Posts.class,authorId);
    }//根据作者编号查询

    @Override
    public List<Posts> getPostTitle(String title) {
        String sql="select * from mto_posts where title like '%"+title+"%'";
        return DBUtil.getObjects(sql,Posts.class);
    }//根据文章标题模糊查询

    @Override
    public List<Posts> getAllPosts() {
        String sql="select * from mto_posts";
        return DBUtil.getObjects(sql,Posts.class);
    }//查询所有

    @Override
    public List<Posts> getChannelPosts(Long channel) {
        String sql="select * from mto_posts where channel_id = ?";
        return DBUtil.getObjects(sql,Posts.class,channel);
    }//根据频道id查询所有文章

    @Override
    public int isExits(Long id) {
        String sql = "select count(*) from mto_posts where id=?";
        return DBUtil.getCount(sql, Posts.class, id);
    }//查询id是否存在
    public Posts getPost(Long id) {
        String sql = "select * from mto_posts where id=?";
        return DBUtil.getObject(sql, Posts.class, id);
    }//根据id查询

    @Override
    public List<Posts> findNewPostsLimit(int LIMIT) {
        String sql ="SELECT * FROM mto_posts ORDER BY created DESC LIMIT ?";
        return DBUtil.getObjects(sql, Posts.class, LIMIT);
    }//根据时间查询前LIMIT条
    @Override
    public List<Posts> findNewPostsLimit2(int LIMIT) {
        String sql ="SELECT * FROM mto_posts ORDER BY favors DESC LIMIT ?";
        return DBUtil.getObjects(sql, Posts.class, LIMIT);
    }//根据点赞查询前LIMIT条
    @Override
    public List<Posts> findNewPostsLimit3(int LIMIT) {
        String sql ="SELECT * FROM mto_posts ORDER BY comments DESC LIMIT ?";
        return DBUtil.getObjects(sql, Posts.class, LIMIT);
    }//根据评论查询前LIMIT条
}
