package com.peter.xblog.service;


import service.Impl.PostsServiceImpl;
import service.PostsService;
import bean.Post;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Fang on 2018/5/22.
 */
public class PostServiceTest {
    PostsService postsService = new PostsServiceImpl();

    //测试添加文章
    @Test
    public void testAdd() {
        Date date = new Date();
        Post post = new Post(2L, 3, date, "4", 5, 1, 1, 1, "1", "1", "1", 1, 1, "312");
        int num = postsService.addPost(post);
        System.out.println(num);
    }

    //测试根据作者id查找文章
    @Test
    public void testSelect() {
        List<Post> list = postsService.getPostAuthorId(1L);
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试删除文章
    @Test
    public void testDelect() {
        postsService.deletePost(16L);
    }

    //测试查找所有文章
    @Test
    public void testSelectAll() {
        List<Post> list = postsService.getAllPosts();
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试修改文章
    @Test
    public void testUpdate() {
        Post post = new Post(7, 2, 2, 2, "2", 2, "789");
        postsService.updatePost(post);
        List<Post> list = postsService.getPostAuthorId(1L);
        for (Post post1 : list) {
            System.out.println(post);
        }
    }

    //测试更改文章点赞数
    @Test
    public void testUpdate2() {
        Post post = new Post(7, 13);
        postsService.updatePostFavors(post);
        List<Post> list = postsService.getPostAuthorId(2L);
        for (Post post1 : list) {
            System.out.println(post);
        }
    }

    //测试更改文章阅读数
    @Test
    public void testUpdate3() {
        Post post = new Post(7, 10);
        postsService.updatePostViews(post);
        List<Post> list = postsService.getPostAuthorId(2L);
        for (Post post1 : list) {
            System.out.println(post);
        }
    }

    //测试更改文章评论数
    @Test
    public void testUpdate4() {
        Post post = new Post(7, 5);
        postsService.updatePostComments(post);
        List<Post> list = postsService.getPostAuthorId(2L);
        for (Post post1 : list) {
            System.out.println(post);
        }
    }

    //测试根据时间顺序查找文章
    @Test
    public void testSelectAll2() {
        List<Post> list = postsService.findNewPostsLimit(3);
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试根据点赞数顺序查找文章
    @Test
    public void testSelectAll3() {
        List<Post> list = postsService.findNewPostsLimit2(3);
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试根据评论数顺序查找文章
    @Test
    public void testSelectAll4() {
        List<Post> list = postsService.findNewPostsLimit3(3);
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试根据文章id查找文章
    @Test
    public void getPost() {
        Post post = postsService.getPost(5L);
        System.out.println(post);
    }

   /* @Test
    public void findByPage() {
        PageBean<Post> page = postsService.findByPage(1, 2);
        page.getPageSize();
    }*/
}
