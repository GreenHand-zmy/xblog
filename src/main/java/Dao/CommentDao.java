package Dao;

import bean.Comment;

import java.util.List;

/**
 * Created by lfy on 2018/5/21.
 */
public interface CommentDao {
    public Comment getCommentById(long id );//根据评论编号得到评论
    public List<Comment> getComments(long toid);//根据所评论的文章（toid）得到该文章的所有评论
    public List<Comment> getCommentsByAuthor(long authorId);//得到一个用户的所有评论
    public int delComment(long id);//根据评论编号删除评论
    public int addComment(Comment comment);//增加一条评论
    public int getCount(long toid);//根据所评论文章得到该文章的评论数
}
