package dao;

import bean.Comment;

import java.util.List;

/**
 * Created by lfy on 2018/5/21.
 */
public interface CommentDao {
    Comment getCommentById(long id);//根据评论编号得到评论

    List<Comment> getComments(long toid);//根据所评论的文章toid（对应于当前文章id）得到该文章的所有评论

    List<Comment> getCommentsByAuthor(long authorId);//得到一个用户的所有评论

    int delComment(long id);//根据评论编号删除评论

    int addComment(Comment comment);//增加一条评论

    int getCount(long toid);//根据所评论文章（对应于当前文章id）得到该文章的评论数

    int getCount1(long authorId);//查看一人的所有评论数

    List<Comment> getAllComments();//查询所有评论

    List<Comment> getCommentContent(String content);//根据评论内容模糊查询

    /**
     * 更新一个评论
     *
     * @param comment 更新评论
     * @return
     */
    int update(Comment comment);
}
