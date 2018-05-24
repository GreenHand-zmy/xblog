package Dao;

import bean.Posts;

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
    int addPost(Posts post);

    /**
     * 修改文章
     *
     * @param post 文章实体
     * @return SQL语句影响行数
     */
    int updatePost(Posts post);

    /**
     * 修改文章点赞数
     *
     * @param post 文章实体
     * @return SQL语句影响行数
     */
    int updatePostFavors(Posts post);

    /**
     * 修改文章阅读量
     *
     * @param post 文章实体
     * @return SQL语句影响行数
     */
    int updatePostViews(Posts post);

    /**
     * 修改文章评论量
     *
     * @param post 文章实体
     * @return SQL语句影响行数
     */
    int updatePostComments(Posts post);

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
     * 根据偏移量和限制数量查找文章
     *
     * @param offset 偏移量
     * @param limit  限制大小
     * @return
     */
    List<Posts> findByOffsetAndLimit(Integer offset, Integer limit);

    /**
     * 查询所有
     *
     * @return 所有文章
     */
    List<Posts> getAllPosts();

    /**
     * 根据频道id查询所有文章
     *
     * @param channelId 频道编号
     * @return 该频道的所有文章
     */
    List<Posts> getChannelPosts(Long channelId);

    /**
     * 根据文章编号查询
     *
     * @param id 文章编号
     * @return 文章实体
     */
    Posts getPost(Long id);

    List<Posts> getPostTitle(String title);//根据文章标题模糊查询

    List<Posts> getPostAuthorId(Long authorId);//根据作者标号查询

    int isExits(Long id);//查询id是否存在

    List<Posts> findNewPostsLimit(int LIMIT);//根据时间查询前LIMIT条

    List<Posts> findNewPostsLimit2(int LIMIT);//根据点赞查询前LIMIT条

    List<Posts> findNewPostsLimit3(int LIMIT);//根据评论数查询前LIMIT条

    List<Posts> findNewPostsLimit4(int LIMIT);//根据阅读数数查询前LIMIT条
}
