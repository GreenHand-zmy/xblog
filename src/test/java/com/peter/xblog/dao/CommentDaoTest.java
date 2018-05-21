package com.peter.xblog.dao;

import Dao.CommentDao;
import Dao.Impl.CommentDaoImpl;
import utils.DBUtil;
import bean.Comment;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * Created by lfy on 2018/5/21.
 */
public class CommentDaoTest {
    CommentDao cd=new CommentDaoImpl();
    DBUtil db=new DBUtil();
    @Test
    public void testAdd(){
        Date date=new Date();
        Comment comment=new Comment(2L,"哇哇哇哇我",date,1,3L);
        int num =cd.addComment(comment);
        System.out.println(num);
    }
    @Test
    public void testConnection(){
        System.out.println(db.getConn() );
    }
    @Test
    public void testgetCount(){
        System.out.println(cd.getCount(3));
    }
    @Test
    public void testgetCommentById(){
        long id=1;
        Comment comment=cd.getCommentById(id);
        System.out.println(comment.getContent());
    }
    @Test
    public void getComments(){
        long toid=3;
        List<Comment> commentList=cd.getComments(3);
        for (Comment c:commentList) {
            System.out.println(c.getContent());
        }
    }
    @Test
    public void testgetCommentsByAuthor(){
        long authorid=2;
        List<Comment> commentList=cd.getCommentsByAuthor(2);
        for (Comment c:commentList) {
            System.out.println(c.getContent());
        }
    }
    @Test
    public void testDel(){
        int num=cd.delComment(1);
        System.out.println(num);
    }
}
