package Service;

import bean.Post;
import utils.PageBean;

import java.util.List;

/**
 * Created by Fang on 2018/5/21.
 */
public interface PostsService {
    int addPost(Post post);//添加文章

    int updatePost(Post post);//修改文章

    int deletePost(Long Id);//删除文章

    int updatePostFavors(Post post);//修改文章点赞数

    int updatePostViews(Post post);//修改文章阅读量

    int updatePostComments(Post post);//修改文章评论量

    List<Post> getPostTitle(String title);//根据文章标题模糊查询

    List<Post> getPostAuthorId(Long authorId);//根据作者标号查询

    List<Post> getChannelPosts(Long channel);//根据频道id查询所有文章

    List<Post> getAllPosts();//查询所有

    Post getPost(Long id);//根据id查询文章

    List<Post> findNewPostsLimit(int LIMIT);//根据时间查询前LIMIT条

    List<Post> findNewPostsLimit2(int LIMIT);//根据点赞查询前LIMIT条

    List<Post> findNewPostsLimit3(int LIMIT);//根据评论查询前LIMIT条

    List<Post> findNewPostsLimit4(int LIMIT);//根据评论查询前LIMIT条

    /**
     * 获取分页数据
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @param channelId 频道编号
     * @return
     */
    PageBean<Post> findByPage(int pageIndex, int pageSize, Long channelId, String orderBy);

    /**
     * 获取分页数据(默认已制定页大小)
     *
     * @param pageIndex 页码
     * @param channelId 频道编号
     * @param orderBy   根据指定字段排序
     * @return
     */
    PageBean<Post> findByPage(int pageIndex, Long channelId, String orderBy);

    /**
     * 返回文章总数
     *
     * @return
     */
    Integer countAll();

    /**
     * 根据作者编号,查找返回数量
     *
     * @param authorId 作者编号
     * @return 文章数量
     */
    Integer countByAuthorId(Long authorId);
}
