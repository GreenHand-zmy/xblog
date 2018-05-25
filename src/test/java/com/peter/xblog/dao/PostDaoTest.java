package com.peter.xblog.dao;

import Dao.Impl.PostDaoImpl;
import Dao.PostDao;
import bean.Post;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Fang on 2018/5/21.
 */
public class PostDaoTest {
    PostDao pd = new PostDaoImpl();

    //测试添加文章
    @Test
    public void testAdd() {
        Date date = new Date();
        Post post = new Post(2L, 3, date, "4", 5, 1, 1, 1, "1", "1", "1", 1, 2, "321");
        int num = pd.addPost(post);
        System.out.println(num);
    }

    //测试按作者id查找文章
    @Test
    public void testSelect() {
        List<Post> list = pd.getPostAuthorId(2L);
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试按栏目id查找文章
    @Test
    public void testSelect2() {
        List<Post> list = pd.getChannelPosts(1L);
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试按文章标题模糊查询
    @Test
    public void testSelect3() {
        List<Post> list = pd.getPostTitle("123");
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试删除文章
    @Test
    public void testDelect() {
        pd.deletePost(8L);
        List<Post> list = pd.getAllPosts();
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试查找所有文章
    @Test
    public void testSelectAll() {
        List<Post> list = pd.getAllPosts();
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试更改文章
    @Test
    public void testUpdate() {
        Post post = new Post(7, 2, 2, 2, "2", 2, "234");
        pd.updatePost(post);
        List<Post> list = pd.getPostAuthorId(2L);
        for (Post post1 : list) {
            System.out.println(post);
        }
    }

    //测试更改文章点赞数
    @Test
    public void testUpdate2() {
        Post post = new Post(7, 2);
        pd.updatePostFavors(post);
        List<Post> list = pd.getPostAuthorId(2L);
        for (Post post1 : list) {
            System.out.println(post);
        }
    }

    //测试更改文章阅读数
    @Test
    public void testUpdate3() {
        Post post = new Post(7, 2);
        pd.updatePostViews(post);
        List<Post> list = pd.getPostAuthorId(2L);
        for (Post post1 : list) {
            System.out.println(post);
        }
    }

    //测试更改文章评论数
    @Test
    public void testUpdate4() {
        Post post = new Post(7, 3);
        pd.updatePostComments(post);
        List<Post> list = pd.getPostAuthorId(2L);
        for (Post post1 : list) {
            System.out.println(post);
        }
    }

    //测试根据时间顺序查找文章
    @Test
    public void testSelectAll2() {
        List<Post> list = pd.findNewPostsLimit(1);
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试根据点赞数顺序查找文章
    @Test
    public void testSelectAll3() {
        List<Post> list = pd.findNewPostsLimit2(3);
        for (Post post : list) {
            System.out.println(post);
        }
    }

    //测试根据评论数顺序查找文章
    @Test
    public void testSelectAll4() {
        List<Post> list = pd.findNewPostsLimit3(3);
        for (Post post : list) {
            System.out.println(post);
        }
    }

    @Test
    public void countAll() {
        Integer integer = pd.countAll();
        System.out.println(integer);
    }

    @Test
    public void findByOffsetAndLimit() {
        List<Post> postList = pd.findByOffsetAndLimit(1L, 0, 10, "created");
    }

    @Test
    public void countByAuthorId() {
        Integer integer = pd.countByAuthorId(7L);
    }

    @Test
    public void countByChannelId() {
        Integer count = pd.countByChannelId(1L);
    }
}
