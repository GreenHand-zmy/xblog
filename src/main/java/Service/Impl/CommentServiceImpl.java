package Service.Impl;

import Dao.CommentDao;
import Dao.Impl.CommentDaoImpl;
import Service.CommentService;
import Service.PostsService;
import bean.Comment;
import bean.Post;
import constant.CommentStatusConstant;
import utils.DBUtil;
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
    //根据评论编号得到评论
    @Override
    public Comment getCommentById(long id) {
        Comment comment = commentDao.getCommentById(id);
        check(comment != null, "没有符合id的评论！");
        return comment;
    }
    //根据所评论的文章（toid）得到该文章的所有评论
    @Override
    public List<Comment> getComments(long toid) {
        List<Comment> commentList = commentDao.getComments(toid);
        check(commentList != null, "暂无评论！");
        return commentList;
    }
    //得到一个用户的所有评论
    @Override
    public List<Comment> getCommentsByAuthor(long authorId) {
        List<Comment> commentList = commentDao.getCommentsByAuthor(authorId);
        check(commentList != null, "用户暂无评论！");
        return commentList;
    }
    //根据评论编号删除评论
    @Override
    public int delComment(long id) {
        String sql="UPDATE mto_comments SET `status`=? WHERE id=?";
        int num = DBUtil.executeUpdate(sql, CommentStatusConstant.DELETED_STATUS,id);
        check(num != 0, "删除评论失败！");
        return num;
    }
    //增加一条评论
    @Override
    public int addComment(Comment comment) {
        int num = commentDao.addComment(comment);
        check(comment.getStatus() != null, "评论状态不能为空");
        check(num != 0, "评论失败！");
        return num;
    }
    //根据所评论文章toId(对应于当前文章的id)得到该文章的评论数
    @Override
    public int getCount(long toid) {
        int num = commentDao.getCount(toid);
        check(num >= 0, "评论统计数量错误！");
        return num;
    }

    //查询所有评论
    @Override
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    @Override
    public int DisComment(long id) {
        String sql="UPDATE mto_comments SET `status`=? WHERE id=?";
        return DBUtil.executeUpdate(sql,CommentStatusConstant.DISABLED_STATUS,id);
    }

    @Override
    public List<PostCommentVo> getPostCommentVoByAuthorId(Long authorId) {
        // 根据作者编号查询所有评论
        List<Comment> commentList = getCommentsByAuthor(authorId);
        List<PostCommentVo> postCommentVoList = new ArrayList<>();
        commentList.forEach(comment -> {
            // 根据评论toId查询评论了哪篇文章
            Long toId = comment.getToId();
            Post targetPost = postsService.getPost(toId);
            postCommentVoList.add(new PostCommentVo(targetPost, comment));
        });
        return postCommentVoList;
    }

    @Override
    public int getCount1(long authorId) {
        int  num = commentDao.getCount1(authorId);
        return num;
    }

    @Override
    public List<Comment> getCommentContent(String content) {
        List<Comment> list = commentDao.getCommentContent(content);
        check(list != null, "无查询结果");
        return list;
    }
}
