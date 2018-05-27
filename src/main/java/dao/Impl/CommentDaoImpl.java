package dao.Impl;

import dao.CommentDao;
import constant.CommentStatusConstant;
import utils.DBUtil;
import bean.Comment;

import java.util.List;

/**
 * Created by lfy on 2018/5/21.
 */
public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> getAllComments() {
        String sql = "SELECT id,author_id authorId,content,created,status,to_id toId FROM mto_comments";
        return DBUtil.getObjects(sql, Comment.class);
    }

    @Override
    public List<Comment> getCommentContent(String content) {
        String sql = "select * from mto_comments where content like '%" + content + "%'";
        return DBUtil.getObjects(sql, Comment.class);
    }

    @Override
    public int update(Comment comment) {
        String sql = "update mto_comments set `status` = ? where id = ?";
        return DBUtil.executeUpdate(sql, comment.getStatus(), comment.getId());
    }

    //根据评论编号得到评论
    @Override
    public Comment getCommentById(long id) {
        String sql = "SELECT id,author_id authorId,content,created,status,to_id toId FROM mto_comments WHERE id=?";
        return DBUtil.getObject(sql, Comment.class, id);
    }

    // //根据所评论的文章toid（对应于当前文章的Id）得到该文章的所有评论
    @Override
    public List<Comment> getComments(long toid) {
        String sql = "SELECT id,author_id authorId,content,created,status,to_id toId FROM mto_comments WHERE to_id=?";
        return DBUtil.getObjects(sql, Comment.class, toid);
    }

    //得到一个用户的所有评论
    @Override
    public List<Comment> getCommentsByAuthor(long authorId) {
        String sql = "SELECT id,author_id authorId,content,created,status,to_id toId FROM mto_comments WHERE author_id=?";
        return DBUtil.getObjects(sql, Comment.class, authorId);
    }

    //根据评论编号删除评论
    @Override
    public int delComment(long id) {
        String sql = "DELETE FROM mto_comments WHERE id=?";
        return DBUtil.executeUpdate(sql, id);
    }

    //增加一条评论
    @Override
    public int addComment(Comment comment) {
        String sql = "INSERT INTO mto_comments (author_id,content,created,status,to_id) VALUES(?,?,?,?,?)";
        return DBUtil.executeUpdate(sql, comment.getAuthorId(), comment.getContent(), comment.getCreated(), comment.getStatus(), comment.getToId());
    }

    //根据所评论文章toId(对应于当前文章的id)得到该文章的评论数
    @Override
    public int getCount(long toid) {
        String sql = "SELECT COUNT(*) FROM mto_comments WHERE to_id=? and status = " + CommentStatusConstant.NORMAL_STATUS;
        return DBUtil.getCount(sql, null, toid);
    }

    @Override
    public int getCount1(long authorId) {
        String sql = "select count(*) from mto_comments where author_id=? and status = " + CommentStatusConstant.NORMAL_STATUS;
        return DBUtil.getCount(sql, null, authorId);
    }
}
