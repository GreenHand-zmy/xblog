package Dao.Impl;

import Dao.CommentDao;
import Dao.DBUtil;
import bean.Comment;

import java.util.Date;
import java.util.List;

/**
 * Created by lfy on 2018/5/21.
 */
public class CommentDaoImpl extends DBUtil implements CommentDao {
    DBUtil db=new DBUtil();
    @Override
    public Comment getCommentById(long id) {
        String sql="SELECT * FROM mto_comments WHERE id=?";
        return db.getObject(sql,Comment.class,id);
    }

    @Override
    public List<Comment> getComments(long toid) {
        String sql="SELECT * FROM mto_comments WHERE to_id=?";
        return db.getObjects(sql,Comment.class,toid);
    }

    @Override
    public List<Comment> getCommentsByAuthor(long authorId) {
        String sql="SELECT * FROM mto_comments WHERE author_id=?";
        return db.getObjects(sql,Comment.class,authorId);
    }

    @Override
    public int delComment(long id) {
        String sql="DELETE FROM mto_comments WHERE id=?";
        return db.executeUpdate(sql,id);
    }

    @Override
    public int addComment(Comment comment) {
        String sql="INSERT INTO mto_comments (author_id,content,created,status,to_id) VALUES(?,?,?,?,?)";
        return db.executeUpdate(sql,comment.getAuthorId(),comment.getContent(),new Date(),comment.getStatus(),comment.getToId());
    }
}
