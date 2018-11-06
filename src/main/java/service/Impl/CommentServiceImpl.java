package service.Impl;

import dao.CommentDao;
import dao.Impl.CommentDaoImpl;
import dao.Impl.UserDaoImpl;
import dao.UserDao;
import service.CommentService;
import service.PostsService;
import bean.Comment;
import bean.Post;
import bean.User;
import constant.CommentStatusConstant;
import utils.DBUtil;
import bean.vo.CommentVo;
import bean.vo.PostCommentVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.CheckUtil.check;

/**
 * Created by lfy on 2018/5/21.
 */
public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao = new CommentDaoImpl();
    private PostsService postsService = new PostsServiceImpl();
    private UserDao userDao = new UserDaoImpl();

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
        return commentList;
    }

    //得到一个用户的所有评论
    @Override
    public List<Comment> getCommentsByAuthor(long authorId) {
        List<Comment> commentList = commentDao.getCommentsByAuthor(authorId);

        // 筛选出评论状态为正常的评论集合
        return commentList
                .stream()
                .filter(comment -> CommentStatusConstant.NORMAL_STATUS.equals(comment.getStatus()))
                .collect(Collectors.toList());
    }

    //根据评论编号删除评论
    @Override
    public int delComment(long id) {
        // 将评论状态更新为已删除
        Comment comment = commentDao.getCommentById(id);
        comment.setStatus(CommentStatusConstant.DELETED_STATUS);

        // 获取被评论文章编号,将评论数减1,并更新
        Post post = postsService.getPost(comment.getToId());
        post.setComments(post.getComments() - 1);
        postsService.updatePostComments(post);
        return commentDao.update(comment);
    }

    //增加一条评论
    @Override
    public int addComment(Comment comment) {
        // 设置评论状态为普通状态,并添加到数据库中
        comment.setStatus(CommentStatusConstant.NORMAL_STATUS);
        int num = commentDao.addComment(comment);

        // 获取被评论的文章编号
        Long toId = comment.getToId();

        // 将被评论的文章,评论数+1
        Post post = postsService.getPost(toId);
        post.setComments(post.getComments() + 1);

        // 将更新后的文章添加到数据库中
        postsService.updatePostComments(post);
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
        String sql = "UPDATE mto_comments SET `status`=? WHERE id=?";
        return DBUtil.executeUpdate(sql, CommentStatusConstant.DISABLED_STATUS, id);
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
    public List<CommentVo> getCommentVoByPostId(Long postId) {
        List<CommentVo> commentVoList = new ArrayList<>();

        Post post = postsService.getPost(postId);
        List<Comment> comments = getComments(post.getId());
        for (Comment comment : comments) {
            // 筛选出正常状态的评论
            if (CommentStatusConstant.NORMAL_STATUS.equals(comment.getStatus())) {
                User user = userDao.getUser(comment.getAuthorId());
                CommentVo commentVo = new CommentVo(user, comment);
                commentVoList.add(commentVo);
            }
        }
        return commentVoList;
    }

    @Override
    public int getCount1(long authorId) {
        int num = commentDao.getCount1(authorId);
        return num;
    }

    @Override
    public List<Comment> getCommentContent(String content) {
        List<Comment> list = commentDao.getCommentContent(content);
        check(list != null, "无查询结果");
        return list;
    }
}
