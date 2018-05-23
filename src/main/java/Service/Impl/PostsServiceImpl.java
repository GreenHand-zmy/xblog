package Service.Impl;

import Dao.Impl.PostDaoImpl;
import Dao.PostDao;
import Service.PostsService;
import bean.Posts;

import java.util.List;

import static utils.CheckUtil.check;

/**
 * Created by Fang on 2018/5/21.
 */
public class PostsServiceImpl implements PostsService {
    PostDao pd = new PostDaoImpl();

    @Override
    public int addPost(Posts post) {
        int num1 = pd.isExits(post.getId());
        check(num1 == 0, "用户名已存在");
        check(post.getAuthorId() != 0, "作者名不能为空");
        check(post.getFeatured() != -1, "推荐状态不能为空");
        check(post.getStatus() != -1, "文章状态不能为空");
        check(post.getWeight() != -1, "置顶状态不能为空");
        check(post.getContent() != null, "内容不能为空");
        int num = pd.addPost(post);
        return num;
    }

    @Override
    public int updatePost(Posts post) {
        int num1 = pd.isExits(post.getId());
        check(num1 == 1, "用户名不存在");
        check(post.getChannelId() != 0, "频道编号不能为空");
        check(post.getContent() != null, "内容不能为空");
        check(post.getTitle() != null, "标题不能为空");
        int num = pd.updatePost(post);
        return num;
    }

    @Override
    public int deletePost(Long id) {
        Posts post = pd.getPost(id);
        check(post != null, "该用户不存在");
        int num = pd.deletePost(id);
        return num;
    }

    @Override
    public int updatePostFavors(Posts post) {
        int num = pd.updatePostFavors(post);
        return num;
    }

    @Override
    public int updatePostViews(Posts post) {
        int num = pd.updatePostViews(post);
        return num;
    }

    @Override
    public int updatePostComments(Posts post) {
        int num = pd.updatePostComments(post);
        return num;
    }

    @Override
    public List<Posts> getPostTitle(String title) {
        List<Posts> list = pd.getPostTitle(title);
        check(list != null, "无查询结果");
        return list;
    }

    @Override
    public List<Posts> getPostAuthorId(Long authorId) {
        List<Posts> list = pd.getPostAuthorId(authorId);
        check(list != null, "无查询结果");
        return list;
    }

    @Override
    public List<Posts> getChannelPosts(Long channel) {
        List<Posts> list = pd.getChannelPosts(channel);
        check(list != null, "无查询结果");
        return list;
    }

    @Override
    public List<Posts> getAllPosts() {
        List<Posts> list = pd.getAllPosts();
        check(list != null, "无查询结果");
        return list;
    }

    @Override
    public List<Posts> findNewPostsLimit(int LIMIT) {
        List<Posts> list = pd.findNewPostsLimit(LIMIT);
        check(list != null, "无查询结果");
        return list;
    }
    @Override
    public List<Posts> findNewPostsLimit2(int LIMIT) {
        List<Posts> list = pd.findNewPostsLimit2(LIMIT);
        check(list != null, "无查询结果");
        return list;
    }
    @Override
    public List<Posts> findNewPostsLimit3(int LIMIT) {
        List<Posts> list = pd.findNewPostsLimit3(LIMIT);
        check(list != null, "无查询结果");
        return list;
    }
    public Posts getPost(Long id){
        Posts post = pd.getPost(id);
        check(post != null, "该用户不存在");
        return post;
    }
}
