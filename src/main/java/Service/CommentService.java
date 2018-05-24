package Service;

import bean.Comment;
import vo.PostCommentVo;

import java.util.List;

/**
 * Created by lfy on 2018/5/21.
 */
public interface CommentService {
    //根据评论编号得到评论
    Comment getCommentById(long id);

    //根据所评论的文章toid（对应于当前文章的Id）得到该文章的所有评论
    List<Comment> getComments(long toid);

    //得到一个用户的所有评论
    List<Comment> getCommentsByAuthor(long authorId);

    //根据评论编号删除评论
    int delComment(long id);

    //增加一条评论
    int addComment(Comment comment);

    //根据所评论文章toId(对应于当前文章的id)得到该文章的评论数
    int getCount(long toid);

    //查询所有评论
    List<Comment> getAllComments();

    List<PostCommentVo> getPostCommentVoByAuthorId(Long authorId);

    int getCount1(long authorId);
}
