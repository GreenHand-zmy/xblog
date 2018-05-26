package com.peter.xblog.service;

import Service.CommentService;
import Service.Impl.CommentServiceImpl;
import bean.Comment;
import org.junit.Test;
import vo.CommentVo;
import vo.PostCommentVo;

import java.util.Date;
import java.util.List;

/**
 * Created by lfy on 2018/5/22.
 */
public class CommentServiceTest {
    CommentService commentService = new CommentServiceImpl();

    //测试添加评论
    @Test
    public void testAdd() {
        Date date = new Date();
        Comment comment = new Comment(2L, "哇哇哇哇我", date, 1, 3L);
        int num = commentService.addComment(comment);
        System.out.println(num);
    }

    //测试数据库连接
    @Test
    public void testgetCount() {
        System.out.println(commentService.getCount(3));
    }

    //测试根据所评论文章toId(对应于当前文章的id)得到该文章的评论数
    @Test
    public void testgetCommentById() {
        long id = 1;
        Comment comment = commentService.getCommentById(id);
        System.out.println(comment.getContent());
    }

    //测试根据id查询评论
    @Test
    public void getComments() {
        long toid = 3;
        List<Comment> commentList = commentService.getComments(3);
        for (Comment c : commentList) {
            System.out.println(c.getContent());
        }
    }

    //测试根据所评论的文章toid（对应于当前文章的Id）得到该文章的所有评论
    @Test
    public void testgetCommentsByAuthor() {
        long authorid = 2;
        List<Comment> commentList = commentService.getCommentsByAuthor(2);
        for (Comment c : commentList) {
            System.out.println(c.getContent());
        }
    }

    //测试根据用户Id查询评论
    @Test
    public void testDel() {
        int num = commentService.delComment(1);
        System.out.println(num);
    }

    //测试删除评论
    @Test
    public void getPostCommentVoByAuthorId() {
        List<PostCommentVo> postCommentVoByAuthorId = commentService.getPostCommentVoByAuthorId(6L);
    }

    @Test
    public void getCommentVoByPostId() {
        List<CommentVo> commentVoList = commentService.getCommentVoByPostId(12L);
    }
}
