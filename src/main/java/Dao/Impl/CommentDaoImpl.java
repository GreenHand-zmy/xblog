package Dao.Impl;

import Dao.CommentDao;
import utils.DBUtil;
import bean.Comment;

import java.util.List;

/**
 * Created by lfy on 2018/5/21.
 */
public class CommentDaoImpl implements CommentDao {

    @Override
    public Comment getCommentById(long id) {
        String sql = "SELECT id,author_id,content,created,status,to_id FROM mto_comments WHERE id=?";
        return DBUtil.getObject(sql, Comment.class, id);
    }

    @Override
    public List<Comment> getComments(long toid) {
        String sql = "SELECT id,author_id,content,created,status,to_id FROM mto_comments WHERE to_id=?";
        return DBUtil.getObjects(sql, Comment.class, toid);
    }

    @Override
    public List<Comment> getCommentsByAuthor(long authorId) {
        String sql = "SELECT id,author_id,content,created,status,to_id FROM mto_comments WHERE author_id=?";
        return DBUtil.getObjects(sql, Comment.class, authorId);
    }

    @Override
    public int delComment(long id) {
        String sql = "DELETE FROM mto_comments WHERE id=?";
        return DBUtil.executeUpdate(sql, id);
    }

    @Override
    public int addComment(Comment comment) {
        String sql = "INSERT INTO mto_comments (author_id,content,created,status,to_id) VALUES(?,?,?,?,?)";
        return DBUtil.executeUpdate(sql, comment.getAuthorId(), comment.getContent(), comment.getCreated(), comment.getStatus(), comment.getToId());
    }

    @Override
    public int getCount(long toid) {
        String sql = "SELECT COUNT(*) FROM mto_comments WHERE to_id=?";
        return DBUtil.getCount(sql, null, toid);
    }
}
