package Dao.Impl;

import Dao.PostDao;
import bean.Posts;
import utils.DBUtil;

import java.util.List;

/**
 * Created by Fang on 2018/5/21.
 */
public class PostDaoImpl extends DBUtil implements PostDao {

     DBUtil db =new DBUtil();
    @Override
    public int addPost(Posts post) {
        String sql="insert into mto_posts (author_id,comments,created,editor,favors,featured,channel_id,status,summary,tags,title,views) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        return super.executeUpdate(sql,post.getAuthorId(),post.getComments(),
                post.getCreated(), post.getEditor(),post.getFavors(),post.getFeatured(),
                post.getChannelId(), post.getStatus(),post.getSummary(),post.getTags(),post.getTitle(),
                post.getViews());
    }//添加文章

    @Override
    public int updatePost(Posts post) {
        String sql="update mto_posts set channel_id=?,tags=?,title=? where id=?";
        Object[] values={post.getChannelId(),post.getTags(),post.getTitle(),post.getId()};
        return super.executeUpdate(sql,values);
    }//修改文章

    @Override
    public int deletePost(Long Id) {
        String sql="delete from mto_posts where id=?";
        return super.executeUpdate(sql, Id);
    }//删除文章

    @Override
    public List<Posts> getPostAuthorId(Long authorId) {
        String sql="select * from mto_posts where author_id = ?";
        return db.getObjects(sql,Posts.class,authorId);
    }//根据作者编号查询

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
