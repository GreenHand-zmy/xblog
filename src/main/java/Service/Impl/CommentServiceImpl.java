package Service.Impl;

import Dao.CommentDao;
import Dao.Impl.CommentDaoImpl;
import Service.CommentService;
import bean.Comment;

import java.util.List;

import static utils.CheckUtil.check;

/**
 * Created by lfy on 2018/5/21.
 */
public class CommentServiceImpl  implements CommentService {
    CommentDao cd=new CommentDaoImpl();
    @Override
    public Comment getCommentById(long id) {
        Comment comment=cd.getCommentById(id);
        check(comment!=null,"没有符合id的评论！");
        return comment;
    }

    @Override
    public List<Comment> getComments(long toid) {
        List<Comment> commentList=cd.getComments(toid);
        check(commentList!=null,"暂无评论！");
        return commentList;
    }

    @Override
    public List<Comment> getCommentsByAuthor(long authorId) {
        List<Comment> commentList=cd.getCommentsByAuthor(authorId);
        check(commentList!=null,"用户暂无评论！");
        return commentList;
    }

    @Override
    public int delComment(long id) {
        int num=cd.delComment(id);
        check(num!=0,"删除评论失败！");
        return num;
    }

    @Override
    public int addComment(Comment comment) {
        int num=cd.addComment(comment);
        check(comment.getStatus()!=null,"评论状态不能为空");
        check(num!=0,"评论失败！");
        return num;
    }

    @Override
    public int getCount(long toid) {
        int num=cd.getCount(toid);
        check(num>=0,"评论统计数量错误！");
        return num;
    }
}
