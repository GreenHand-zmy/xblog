package com.peter.xblog.service;

import Service.CommentService;
import Service.Impl.CommentServiceImpl;
import bean.Comment;
import org.junit.Test;
import vo.PostCommentVo;

import java.util.Date;
import java.util.List;

/**
 * Created by lfy on 2018/5/22.
 */
public class CommentServiceTest {
    CommentService commentService = new CommentServiceImpl();

    @Test
    public void testAdd() {
        Date date = new Date();
        Comment comment = new Comment(2L, "哇哇哇哇我", date, 1, 3L);
        int num = commentService.addComment(comment);
        System.out.println(num);
    }

    @Test
    public void testgetCount() {
        System.out.println(commentService.getCount(3));
    }

    @Test
    public void testgetCommentById() {
        long id = 1;
        Comment comment = commentService.getCommentById(id);
        System.out.println(comment.getContent());
    }

    @Test
    public void getComments() {
        long toid = 3;
        List<Comment> commentList = commentService.getComments(3);
        for (Comment c : commentList) {
            System.out.println(c.getContent());
        }
    }

    @Test
    public void testgetCommentsByAuthor() {
        long authorid = 2;
        List<Comment> commentList = commentService.getCommentsByAuthor(2);
        for (Comment c : commentList) {
            System.out.println(c.getContent());
        }
    }

    @Test
    public void testDel() {
        int num = commentService.delComment(1);
        System.out.println(num);
    }

    @Test
    public void getPostCommentVoByAuthorId() {
        List<PostCommentVo> postCommentVoByAuthorId = commentService.getPostCommentVoByAuthorId(6L);

    }
}
