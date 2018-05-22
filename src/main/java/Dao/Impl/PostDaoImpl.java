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
        String sql="insert into mto_posts (author_id,comments,created,editor,favors,featured,channel_id,status,summary,tags,title,views,weight) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return DBUtil.executeUpdate(sql,post.getAuthorId(),post.getComments(),
                post.getCreated(), post.getEditor(),post.getFavors(),post.getFeatured(),
                post.getChannelId(), post.getStatus(),post.getSummary(),post.getTags(),post.getTitle(),
                post.getViews(),post.getWeight());
    }//添加文章

    @Override
    public int updatePost(Posts post) {
        String sql="update mto_posts set channel_id=?,tags=?,title=? where id=?";
        Object[] values={post.getChannelId(),post.getTags(),post.getTitle(),post.getId()};
        return DBUtil.executeUpdate(sql,values);
    }//修改文章

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
    public int isExits(Long id) {
        String sql = "select count(*) from mto_posts where id=?";
        return DBUtil.getCount(sql, Posts.class, id);
    }//查询id是否存在
    public Posts getPost(Long id) {
        String sql = "select * from mto_posts where id=?";
        return DBUtil.getObject(sql, Posts.class, id);
    }//根据id查询
}
