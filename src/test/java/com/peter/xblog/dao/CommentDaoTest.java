package com.peter.xblog.dao;

import dao.CommentDao;
import dao.Impl.CommentDaoImpl;
import utils.DBUtil;
import bean.Comment;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by lfy on 2018/5/21.
 */
public class CommentDaoTest {
    CommentDao cd=new CommentDaoImpl();
    DBUtil db=new DBUtil();
    //测试添加评论
    @Test
    public void testAdd(){
        Date date=new Date();
        Comment comment=new Comment(2L,"哇哇哇哇我",date,1,3L);
        int num =cd.addComment(comment);
        System.out.println(num);
    }
    //测试数据库连接
    @Test
    public void testConnection(){
        System.out.println(db.getConn() );
    }
    //测试根据所评论文章toId(对应于当前文章的id)得到该文章的评论数
    @Test
    public void testgetCount(){
        System.out.println(cd.getCount(3));
    }
    //测试根据id查询评论
    @Test
    public void testgetCommentById(){
        long id=1;
        Comment comment=cd.getCommentById(id);
        System.out.println(comment.getContent());
    }
    //测试根据所评论的文章toid（对应于当前文章的Id）得到该文章的所有评论
    @Test
    public void getComments(){
        long toid=3;
        List<Comment> commentList=cd.getComments(3);
        for (Comment c:commentList) {
            System.out.println(c.getContent());
        }
    }
    //测试根据用户Id查询评论
    @Test
    public void testgetCommentsByAuthor(){
        List<Comment> commentList=cd.getCommentsByAuthor(8);
        for (Comment c:commentList) {
            System.out.println(c.getContent());
        }
    }
    //测试删除评论
    @Test
    public void testDel(){
        int num=cd.delComment(1);
        System.out.println(num);
    }
}
