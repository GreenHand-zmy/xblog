package Dao;

import bean.Posts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fang on 2018/5/21.
 */
public class PostDaoImpl extends DBUtil implements PostDao{

     DBUtil db =new DBUtil();
    @Override
    public int addPost(Posts post) {
        String sql="insert into mto_posts values(?,?,?,sysdate(),?,?,?,?,?,?,?,?,?)";
        return super.executeUpdate(sql,post.getId(),post.getAuthorId(),post.getComments(),
                post.getEditor(),post.getFavors(),post.getFeatured(),post.getChannelId(),
                post.getStatus(),post.getSummary(),post.getTags(),post.getTitle(),post.getViews());
    }//添加文章

    @Override
    public int updatePost(Posts post) {
        String sql="update mto_posts set channelId=?,tags=?,title=? where id=?";
        Object[] values={post.getChannelId(),post.getTags(),post.getTitle(),post.getId()};
        return super.executeUpdate(sql,values);
    }//修改文章

    @Override
    public int deletePost(Posts postId) {
        String sql="delete from mto_posts where id=?";
        return super.executeUpdate(sql, postId);
    }//删除文章

    @Override
    public List<Posts> getPostAuthorId(String authorId) {
        String sql="select * from mto_posts where authorId like '%"+authorId+"%'";
        return db.getObjects(sql,Posts.class);
    }//根据作者模糊查询

    @Override
    public List<Posts> getPostTitle(String title) {
        String sql="select * from mto_posts where title like '%"+title+"%'";
        return db.getObjects(sql,Posts.class);
    }//根据文章标题模糊查询

    @Override
    public List<Posts> getAllPosts() {
        String sql="select * from mto_posts";
        return db.getObjects(sql,Posts.class);
    }//查询所有
}
