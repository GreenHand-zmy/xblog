package com.peter.xblog.service;


import Service.Impl.PostsServiceImpl;
import Service.PostsService;
import bean.Posts;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Fang on 2018/5/22.
 */
public class PostsServiceTest {
    PostsService pd = new PostsServiceImpl();

    @Test
    public void testAdd() {
        Date date = new Date();
        Posts post = new Posts(2L, 3, date, "4", 5, 1, 1, 1, "1", "1", "1", 1, 1);
        int num = pd.addPost(post);
        System.out.println(num);
    }

    @Test
    public void testSelect() {
        List<Posts> list = pd.getPostAuthorId(1L);
        for (Posts post : list) {
            System.out.println(post);
        }
    }

    @Test
    public void testDelect() {

        pd.deletePost(1L);
        List<Posts> list = pd.getAllPosts();
        for (Posts post : list) {
            System.out.println(post);
        }
    }

    @Test
    public void testSelectAll() {
        List<Posts> list = pd.getAllPosts();
        for (Posts post : list) {
            System.out.println(post);
        }
    }

    @Test
    public void testUpdate() {
        Posts post = new Posts(2, 2, 2, 2, "2", "2", "2", 2);
        pd.updatePost(post);
        List<Posts> list = pd.getPostAuthorId(1L);
        for (Posts post1 : list) {
            System.out.println(post);
        }
    }

    @Test
    public void testSelectAll2() {
        List<Posts> list = pd.findNewPostsLimit(3);
        for (Posts post : list) {
            System.out.println(post);
        }
    }

    @Test
    public void testSelectAll3() {
        List<Posts> list = pd.findNewPostsLimit2(3);
        for (Posts post : list) {
            System.out.println(post);
        }
    }

    @Test
    public void testSelectAll4() {
        List<Posts> list = pd.findNewPostsLimit3(3);
        for (Posts post : list) {
            System.out.println(post);
        }
    }

    @Test
    public void getPost() {
        Posts post = pd.getPost(5L);
        System.out.println(post);
    }
}
