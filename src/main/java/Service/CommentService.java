package Service;

import bean.Comment;
import vo.PostCommentVo;

import java.util.List;

/**
 * Created by lfy on 2018/5/21.
 */
public interface CommentService {
    /**
     * 根据评论编号得到评论
     * @param id 评论编号
     * @return Comment 评论
     */
    Comment getCommentById(long id);

    /**
     * 得到该Post下的所有评论
     * @param toid 评论属性to_id可对应于所评论Post的id
     * @return List<Comment> 该Post下的所有评论
     */
    List<Comment> getComments(long toid);

    /**
     * 得到一个用户的所有评论
     * @param authorId 评论者ID
     * @return List<Comment> 评论
     */
    List<Comment> getCommentsByAuthor(long authorId);

    /**
     * 根据评论编号删除评论
     * @param id 评论编号
     * @return int
     */
    int delComment(long id);

    /**
     * 增加一条评论
     * @param comment 评论（对象）
     * @return int
     */
    int addComment(Comment comment);

    /**
     * 根据所评论的toId(对应于当前Post的id)得到该Post的评论数
     * @param toid 评论的toId(对应于Post的id)
     * @return int 对应Post的评论数
     */
    //
    int getCount(long toid);

    /**
     * 查询所有评论
     * @return List<Comment>
     */
    List<Comment> getAllComments();

    /**
     * 涉嫌违规禁用评论
     * @param id 评论编号
     * @return int
     */
    int DisComment(long id);

    List<PostCommentVo> getPostCommentVoByAuthorId(Long authorId);

    /**
     * 查看一人的所有评论数
     * @param authorId 评论者ID（对应于用户Id）
     * @return int
     */
    int getCount1(long authorId);

    /**
     * 根据评论内容模糊查询
     * @param content 评论内容
     * @return
     */
    List<Comment> getCommentContent(String content);
}
