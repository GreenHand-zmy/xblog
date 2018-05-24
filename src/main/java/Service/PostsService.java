package Service;

import bean.Posts;
import utils.PageBean;

import java.util.List;

/**
 * Created by Fang on 2018/5/21.
 */
public interface PostsService {
    public int addPost(Posts post);//添加文章

    public int updatePost(Posts post);//修改文章

    public int deletePost(Long Id);//删除文章

    public int updatePostFavors(Posts post);//修改文章点赞数

    public int updatePostViews(Posts post);//修改文章阅读量

    public int updatePostComments(Posts post);//修改文章评论量

    public List<Posts> getPostTitle(String title);//根据文章标题模糊查询

    public List<Posts> getPostAuthorId(Long authorId);//根据作者标号查询

    public List<Posts> getChannelPosts(Long channel);//根据频道id查询所有文章

    public List<Posts> getAllPosts();//查询所有

    public Posts getPost(Long id);//根据id查询文章

    public List<Posts> findNewPostsLimit(int LIMIT);//根据时间查询前LIMIT条

    public List<Posts> findNewPostsLimit2(int LIMIT);//根据点赞查询前LIMIT条

    public List<Posts> findNewPostsLimit3(int LIMIT);//根据评论查询前LIMIT条

    /**
     * 获取分页数据
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return
     */
    PageBean<Posts> findByPage(int pageIndex, int pageSize);
    public List<Posts> findNewPostsLimit4(int LIMIT);//根据阅读数查询前LIMIT条
}
