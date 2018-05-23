package com.peter.xblog.dao;

import Dao.Impl.PostDaoImpl;
import Dao.PostDao;
import bean.Posts;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Fang on 2018/5/21.
 */
public class PostsDaoTest {
    PostDao pd = new PostDaoImpl();

    @Test
    public void testAdd() {
        Date date = new Date();
        Posts post = new Posts(2L, 3, date, "4", 5, 1, 1, 1, "1", "1", "1", 1,2);
        int num = pd.addPost(post);
        System.out.println(num);
    }

    @Test
    public void testSelect() {
        List<Posts> list = pd.getPostAuthorId(2L);
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    @Test
    public void testSelect2() {
        List<Posts> list = pd.getChannelPosts(1L);
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    @Test
    public void testDelect() {

        pd.deletePost(1L);
        List<Posts> list = pd.getAllPosts();
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    @Test
    public void testSelectAll() {
        List<Posts> list = pd.getAllPosts();
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    @Test
    public void testUpdate() {
        Posts post = new Posts(1L, 1, "1", "2");
        pd.updatePost(post);
        List<Posts> list = pd.getPostAuthorId(1L);
        for (Posts post1 :list) {
            System.out.println(post);
        }
    }
    @Test
    public void testSelectAll2() {
        List<Posts> list = pd.findNewPostsLimit(1);
        for (Posts post :list) {
            System.out.println(post);
        }
    }
}
