package Dao.Impl;

import Dao.PostDao;
import bean.Post;
import constant.TableNameConstant;
import utils.DBUtil;

import java.util.List;

/**
 * Created by Fang on 2018/5/21.
 */
public class PostDaoImpl implements PostDao {
    /**
     * 添加文章
     *
     * @param post 文章实体
     * @return
     */
    @Override
    public int addPost(Post post) {
        String sql = "INSERT INTO mto_posts(author_id,channel_id,title,content,created)" +
                "values(?,?,?,?,CURRENT_TIMESTAMP)";
        return DBUtil.executeUpdate(sql, post.getAuthorId(), post.getChannelId(), post.getTitle(), post.getContent());
    }

    /**
     * 修改文章
     *
     * @param post 文章实体
     * @return
     */
    @Override
    public int updatePost(Post post) {
        String sql = "update mto_posts set featured=?,status=?,content=?,weight=?,channel_id=?,title=? where id=?";
        Object[] values = {post.getFeatured(), post.getStatus(), post.getContent(), post.getWeight(), post.getChannelId(), post.getTitle(), post.getId()};
        return DBUtil.executeUpdate(sql, values);
    }

    /**
     * 按照文章id修改点赞数
     *
     * @param post 文章实体
     * @return
     */
    @Override
    public int updatePostFavors(Post post) {
        String sql = "update mto_posts set favors=? where id=?";
        Object[] values = {post.getFavors(), post.getId()};
        return DBUtil.executeUpdate(sql, values);
    }

    /**
     * 按照文章id修改阅读数
     *
     * @param post 文章实体
     * @return
     */
    @Override
    public int updatePostViews(Post post) {
        String sql = "update mto_posts set views=? where id=?";
        Object[] values = {post.getViews(), post.getId()};
        return DBUtil.executeUpdate(sql, values);
    }

    /**
     * 按照文章id修改评论数
     *
     * @param post 文章实体
     * @return
     */
    @Override
    public int updatePostComments(Post post) {
        String sql = "update mto_posts set comments=? where id=?";
        Object[] values = {post.getComments(), post.getId()};
        return DBUtil.executeUpdate(sql, values);
    }

    /**
     * 根据文章id删除文章
     *
     * @param Id 文章编号
     * @return
     */
    @Override
    public int deletePost(Long Id) {
        String sql = "delete from mto_posts where id=?";
        return DBUtil.executeUpdate(sql, Id);
    }

    /**
     * 根据作者编号查询
     *
     * @param authorId 作者编号
     * @return
     */
    @Override
    public List<Post> getPostAuthorId(Long authorId) {
        String sql = "select id,author_id authorId,channel_id channelId,title,content,views,comments,favors,featured,created,status,weight from mto_posts where author_id = ?";
        return DBUtil.getObjects(sql, Post.class, authorId);
    }

    /**
     * 根据文章标题模糊查询
     *
     * @param title 文章标题
     * @return
     */
    @Override
    public List<Post> getPostTitle(String title) {
        String sql = "select id,author_id authorId,channel_id channelId,title,content,views,comments,favors,featured,created,status,weight from mto_posts where title like '%" + title + "%'";
        return DBUtil.getObjects(sql, Post.class);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Post> getAllPosts() {
        String sql = "select id,author_id authorId,channel_id channelId,title,content,views,comments,favors,featured,created,status,weight from mto_posts";
        return DBUtil.getObjects(sql, Post.class);
    }


    /**
     * 根据频道id查询所有文章
     *
     * @param channel 频道号
     * @return
     */
    @Override
    public List<Post> getChannelPosts(Long channel) {
        String sql = "select id,author_id authorId,channel_id channelId,title,content,views,comments,favors,featured,created,status,weight from mto_posts where channel_id = ?";
        return DBUtil.getObjects(sql, Post.class, channel);
    }

    /**
     * 查询id是否存在
     *
     * @param id
     * @return
     */
    @Override
    public int isExits(Long id) {
        String sql = "select count(*) from mto_posts where id=?";
        return DBUtil.getCount(sql, Post.class, id);
    }


    /**
     * 根据id查询
     *
     * @param id 文章编号
     * @return
     */
    public Post getPost(Long id) {
        String sql = "select id,author_id authorId,channel_id channelId,title,content,views,comments,favors,featured,created,status,weight from mto_posts where id=?";
        return DBUtil.getObject(sql, Post.class, id);
    }


    /**
     * 根据时间查询前LIMIT条
     *
     * @param LIMIT 条数
     * @return
     */
    @Override
    public List<Post> findNewPostsLimit(int LIMIT) {
        String sql = "SELECT id,author_id authorId,channel_id channelId,title,content,views,comments,favors,featured,created,status,weight FROM mto_posts ORDER BY created DESC LIMIT ?";
        return DBUtil.getObjects(sql, Post.class, LIMIT);
    }


    /**
     * 根据点赞查询前LIMIT条
     *
     * @param LIMIT 条数
     * @return
     */
    @Override
    public List<Post> findNewPostsLimit2(int LIMIT) {
        String sql = "SELECT id,author_id authorId,channel_id channelId,title,content,views,comments,favors,featured,created,status,weight FROM mto_posts ORDER BY favors DESC LIMIT ?";
        return DBUtil.getObjects(sql, Post.class, LIMIT);
    }

    /**
     * 根据评论查询前LIMIT条
     *
     * @param LIMIT 条数
     * @return
     */
    @Override
    public List<Post> findNewPostsLimit3(int LIMIT) {
        String sql = "SELECT id,author_id authorId,channel_id channelId,title,content,views,comments,favors,featured,created,status,weight FROM mto_posts ORDER BY comments DESC LIMIT ?";
        return DBUtil.getObjects(sql, Post.class, LIMIT);
    }


    /**
     * 根据阅读数查询前LIMIT条
     *
     * @param LIMIT 条数
     * @return
     */
    @Override
    public List<Post> findNewPostsLimit4(int LIMIT) {
        String sql = "SELECT id,author_id authorId,channel_id channelId,title,content,views,comments,favors,featured,created,status,weight FROM mto_posts ORDER BY views DESC LIMIT ?";
        return DBUtil.getObjects(sql, Post.class, LIMIT);
    }

    /**
     * 计算总
     *
     * @return
     */
    @Override
    public Integer countAll() {
        String sql = "select count(*) from " + TableNameConstant.POST_TABLE;
        return DBUtil.getCount(sql, Integer.class);
    }

    @Override
    public Integer countByChannelId(Long channelId) {
        String sql = "select count(*) from " + TableNameConstant.POST_TABLE + " where channel_id = ?";
        return DBUtil.getCount(sql, Integer.class, channelId);
    }

    @Override
    public Integer countByAuthorId(Long authorId) {
        String sql = "select count(*) from " + TableNameConstant.POST_TABLE +
                " where author_id = ?";

        return DBUtil.getCount(sql, Integer.class, authorId);
    }

    @Override
    public List<Post> findByOffsetAndLimit(Long channelId, Integer offset, Integer limit, String orderBy) {
        String sql;
        if (channelId != null) {
            sql = "SELECT id,author_id authorId,channel_id channelId,title,content,views," +
                    "comments,favors,featured,created,status,weight " +
                    "from " + TableNameConstant.POST_TABLE + " where channel_id = ?" + " order by " + orderBy + " desc limit ?,?";
            return DBUtil.getObjects(sql, Post.class, channelId, offset, limit);
        } else {
            sql = "SELECT id,author_id authorId,channel_id channelId,title,content,views," +
                    "comments,favors,featured,created,status,weight " +
                    "from " + TableNameConstant.POST_TABLE + " order by " + orderBy + " desc limit ?,?";
            return DBUtil.getObjects(sql, Post.class, offset, limit);
        }

    }
}
