package Service.Impl;

import Dao.Impl.PostDaoImpl;
import Dao.PostDao;
import Service.PostsService;
import bean.Post;
import utils.PageBean;

import java.util.List;

import static utils.CheckUtil.check;

/**
 * Created by Fang on 2018/5/21.
 */
public class PostsServiceImpl implements PostsService {
    PostDao postDao = new PostDaoImpl();

    /**
     * 添加文章
     * @param post 文章实体
     * @return
     */
    @Override
    public int addPost(Post post) {
        int num1 = postDao.isExits(post.getId());
        check(num1 == 0, "用户名已存在");
        check(post.getAuthorId() != 0, "作者名不能为空");
        check(post.getFeatured() != -1, "推荐状态不能为空");
        check(post.getStatus() != -1, "文章状态不能为空");
        check(post.getWeight() != -1, "置顶状态不能为空");
        check(post.getContent() != null, "内容不能为空");
        int num = postDao.addPost(post);
        return num;
    }

    /**
     * 更新文章
     * @param post 文章实体
     * @return
     */
    @Override
    public int updatePost(Post post) {
        int num1 = postDao.isExits(post.getId());
        check(num1 == 1, "用户名不存在");
        check(post.getChannelId() != 0, "频道编号不能为空");
        check(post.getContent() != null, "内容不能为空");
        check(post.getTitle() != null, "标题不能为空");
        int num = postDao.updatePost(post);
        return num;
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    @Override
    public int deletePost(Long id) {
        Post post = postDao.getPost(id);
        check(post != null, "该用户不存在");
        int num = postDao.deletePost(id);
        return num;
    }

    /**
     * 修改文章点赞数
     * @param post 文章实体
     * @return
     */
    @Override
    public int updatePostFavors(Post post) {
        int num = postDao.updatePostFavors(post);
        return num;
    }

    /**
     * 修改文章阅读数
     * @param post 文章实体
     * @return
     */
    @Override
    public int updatePostViews(Post post) {
        int num = postDao.updatePostViews(post);
        return num;
    }

    /**
     * 修改文章评论数
     * @param post 文章实体
     * @return
     */
    @Override
    public int updatePostComments(Post post) {
        int num = postDao.updatePostComments(post);
        return num;
    }

    /**
     * 按文章标题查找
     * @param title 标题
     * @return
     */
    @Override
    public List<Post> getPostTitle(String title) {
        List<Post> list = postDao.getPostTitle(title);
        check(list != null, "无查询结果");
        return list;
    }

    /**
     * 按文章作者id查找
     * @param authorId 作者id
     * @return
     */
    @Override
    public List<Post> getPostAuthorId(Long authorId) {
        List<Post> list = postDao.getPostAuthorId(authorId);
        check(list != null, "无查询结果");
        return list;
    }

    /**
     * 按文章栏目查询
     * @param channel 栏目
     * @return
     */
    @Override
    public List<Post> getChannelPosts(Long channel) {
        List<Post> list = postDao.getChannelPosts(channel);
        check(list != null, "无查询结果");
        return list;
    }

    /**
     * 查询所有文章
     * @return
     */
    @Override
    public List<Post> getAllPosts() {
        List<Post> list = postDao.getAllPosts();
        check(list != null, "无查询结果");
        return list;
    }

    /**
     * 按文章时间顺序查询
     * @param LIMIT 条数
     * @return
     */
    @Override
    public List<Post> findNewPostsLimit(int LIMIT) {
        List<Post> list = postDao.findNewPostsLimit(LIMIT);
        check(list != null, "无查询结果");
        return list;
    }

    /**
     * 按文章点赞数从多到少查询
     * @param LIMIT 条数
     * @return
     */
    @Override
    public List<Post> findNewPostsLimit2(int LIMIT) {
        List<Post> list = postDao.findNewPostsLimit2(LIMIT);
        check(list != null, "无查询结果");
        return list;
    }

    /**
     * 按文章评论数从多到少查询
     * @param LIMIT 条数
     * @return
     */
    @Override
    public List<Post> findNewPostsLimit3(int LIMIT) {
        List<Post> list = postDao.findNewPostsLimit3(LIMIT);
        check(list != null, "无查询结果");
        return list;
    }

    /**
     * 按文章阅读数数从多到少查询
     * @param LIMIT 条数
     * @return
     */
    @Override
    public List<Post> findNewPostsLimit4(int LIMIT) {
        List<Post> list = postDao.findNewPostsLimit4(LIMIT);
        check(list != null, "无查询结果");
        return list;
    }

    /**
     * 按文章id查询
     * @param id 文章id
     * @return
     */
    @Override
    public Post getPost(Long id) {
        check(id != null, "查找文章必须输入文章编号");
        Post post = postDao.getPost(id);
        return post;
    }

    /**
     * 分页
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return
     */
    @Override
    public PageBean<Post> findByPage(int pageIndex, int pageSize) {
        //todo 分页
        // 查询数据总数
        Integer totalRecords = postDao.countAll();
        // 构造分页对象
        PageBean<Post> pageBean = new PageBean<>(totalRecords, pageIndex, pageSize);
        // 查询数据库并将数据注入到分页对象中
        pageBean.setData(postDao.findByOffsetAndLimit(pageBean.getOffset(), pageBean.getPageSize()));
        return pageBean;
    }

    @Override
    public Integer countAll() {
        return postDao.countAll();
    }

    @Override
    public Integer countByAuthorId(Long authorId) {
        return postDao.countByAuthorId(authorId);
    }
}
