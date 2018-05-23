package Service.Impl;

import Dao.CommentDao;
import Dao.Impl.CommentDaoImpl;
import Service.CommentService;
import Service.PostsService;
import bean.Comment;
import bean.Posts;
import vo.PostCommentVo;

import java.util.ArrayList;
import java.util.List;

import static utils.CheckUtil.check;

/**
 * Created by lfy on 2018/5/21.
 */
public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao = new CommentDaoImpl();
    private PostsService postsService = new PostsServiceImpl();

    @Override
    public Comment getCommentById(long id) {
        Comment comment = commentDao.getCommentById(id);
        check(comment != null, "没有符合id的评论！");
        return comment;
    }

    @Override
    public List<Comment> getComments(long toid) {
        List<Comment> commentList = commentDao.getComments(toid);
        check(commentList != null, "暂无评论！");
        return commentList;
    }

    @Override
    public List<Comment> getCommentsByAuthor(long authorId) {
        List<Comment> commentList = commentDao.getCommentsByAuthor(authorId);
        check(commentList != null, "用户暂无评论！");
        return commentList;
    }

    @Override
    public int delComment(long id) {
        int num = commentDao.delComment(id);
        check(num != 0, "删除评论失败！");
        return num;
    }

    @Override
    public int addComment(Comment comment) {
        int num = commentDao.addComment(comment);
        check(comment.getStatus() != null, "评论状态不能为空");
        check(num != 0, "评论失败！");
        return num;
    }

    @Override
    public int getCount(long toid) {
        int num = commentDao.getCount(toid);
        check(num >= 0, "评论统计数量错误！");
        return num;
    }

    @Override
    public List<PostCommentVo> getPostCommentVoByAuthorId(Long authorId) {
        // 根据作者编号查询所有评论
        List<Comment> commentList = getCommentsByAuthor(authorId);
        List<PostCommentVo> postCommentVoList = new ArrayList<>();
        commentList.forEach(comment -> {
            // 根据评论toId查询评论了哪篇文章
            Long toId = comment.getToId();
            Posts targetPost = postsService.getPost(toId);
            postCommentVoList.add(new PostCommentVo(targetPost, comment));
        });
        return postCommentVoList;
    }
}
