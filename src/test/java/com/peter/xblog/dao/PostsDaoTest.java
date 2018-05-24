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
    //测试添加文章
    @Test
    public void testAdd() {
        Date date = new Date();
        Posts post = new Posts(2L, 3, date, "4", 5, 1, 1, 1, "1", "1", "1", 1,2,"321");
        int num = pd.addPost(post);
        System.out.println(num);
    }
    //测试按作者id查找文章
    @Test
    public void testSelect() {
        List<Posts> list = pd.getPostAuthorId(2L);
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    //测试按栏目id查找文章
    @Test
    public void testSelect2() {
        List<Posts> list = pd.getChannelPosts(1L);
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    //测试按文章标题模糊查询
    @Test
    public void testSelect3() {
        List<Posts> list = pd.getPostTitle("123");
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    //测试删除文章
    @Test
    public void testDelect() {
        pd.deletePost(8L);
        List<Posts> list = pd.getAllPosts();
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    //测试查找所有文章
    @Test
    public void testSelectAll() {
        List<Posts> list = pd.getAllPosts();
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    //测试更改文章
    @Test
    public void testUpdate() {
        Posts post = new Posts(7,2,2,2,"2",2,"234");
        pd.updatePost(post);
        List<Posts> list = pd.getPostAuthorId(2L);
        for (Posts post1 :list) {
            System.out.println(post);
        }
    }
    //测试更改文章点赞数
    @Test
    public void testUpdate2() {
        Posts post = new Posts(7,2);
        pd.updatePostFavors(post);
        List<Posts> list = pd.getPostAuthorId(2L);
        for (Posts post1 :list) {
            System.out.println(post);
        }
    }
    //测试更改文章阅读数
    @Test
    public void testUpdate3() {
        Posts post = new Posts(7,2);
        pd.updatePostViews(post);
        List<Posts> list = pd.getPostAuthorId(2L);
        for (Posts post1 :list) {
            System.out.println(post);
        }
    }
    //测试更改文章评论数
    @Test
    public void testUpdate4() {
        Posts post = new Posts(7,3);
        pd.updatePostComments(post);
        List<Posts> list = pd.getPostAuthorId(2L);
        for (Posts post1 :list) {
            System.out.println(post);
        }
    }
    //测试根据时间顺序查找文章
    @Test
    public void testSelectAll2() {
        List<Posts> list = pd.findNewPostsLimit(1);
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    //测试根据点赞数顺序查找文章
    @Test
    public void testSelectAll3() {
        List<Posts> list = pd.findNewPostsLimit2(3);
        for (Posts post :list) {
            System.out.println(post);
        }
    }
    //测试根据评论数顺序查找文章
    @Test
    public void testSelectAll4() {
        List<Posts> list = pd.findNewPostsLimit3(3);
        for (Posts post : list) {
            System.out.println(post);
        }
    }
}
