package Dao;

import bean.Post;

import java.util.List;

/**
 * 文章数据库访问层
 * Created by Fang on 2018/5/21.
 */
public interface PostDao {
    /**
     * 添加文章
     *
     * @param post 文章实体
     * @return SQL语句影响行数
     */
    int addPost(Post post);

    /**
     * 修改文章
     *
     * @param post 文章实体
     * @return SQL语句影响行数
     */
    int updatePost(Post post);

    /**
     * 修改文章点赞数
     *
     * @param post 文章实体
     * @return SQL语句影响行数
     */
    int updatePostFavors(Post post);

    /**
     * 修改文章阅读量
     *
     * @param post 文章实体
     * @return SQL语句影响行数
     */
    int updatePostViews(Post post);

    /**
     * 修改文章评论量
     *
     * @param post 文章实体
     * @return SQL语句影响行数
     */
    int updatePostComments(Post post);

    /**
     * 删除文章
     *
     * @param Id 文章编号
     * @return SQL语句影响行数
     */
    int deletePost(Long Id);

    /**
     * 返回文章总数
     *
     * @return
     */
    Integer countAll();

    /**
     * 根据频道编号查询文章数量
     *
     * @param channelId 频道编号
     * @return
     */
    Integer countByChannelId(Long channelId);

    /**
     * 根据作者编号,查找返回数量
     *
     * @param authorId 作者编号
     * @return 文章数量
     */
    Integer countByAuthorId(Long authorId);

    /**
     * 根据偏移量和限制数量查找文章
     * 如果频道为空,查找所有文章
     * 如果频道为空,查找该频道所有文章
     *
     * @param channelId 频道编号
     * @param offset    偏移量
     * @param limit     限制大小
     * @param orderBy
     * @return
     */
    List<Post> findByOffsetAndLimit(Long channelId, Integer offset, Integer limit, String orderBy);

    /**
     * 查询所有
     *
     * @return 所有文章
     */
    List<Post> getAllPosts();

    /**
     * 根据频道id查询所有文章
     *
     * @param channelId 频道编号
     * @return 该频道的所有文章
     */
    List<Post> getChannelPosts(Long channelId);

    /**
     * 根据文章编号查询
     *
     * @param id 文章编号
     * @return 文章实体
     */
    Post getPost(Long id);

    List<Post> getPostTitle(String title);//根据文章标题模糊查询

    List<Post> getPostAuthorId(Long authorId);//根据作者标号查询

    int isExits(Long id);//查询id是否存在

    List<Post> findNewPostsLimit(int LIMIT);//根据时间查询前LIMIT条

    List<Post> findNewPostsLimit2(int LIMIT);//根据点赞查询前LIMIT条

    List<Post> findNewPostsLimit3(int LIMIT);//根据评论数查询前LIMIT条

    List<Post> findNewPostsLimit4(int LIMIT);//根据阅读数数查询前LIMIT条
}
