package Service;

import bean.Posts;

import java.util.List;

/**
 * Created by Fang on 2018/5/21.
 */
public interface PostsService {
    public int addPost(Posts post);//添加文章
    public int updatePost(Posts post);//修改文章
    public int deletePost(Long Id);//删除文章
    public List<Posts> getPostTitle(String title);//根据文章标题模糊查询
    public List<Posts> getPostAuthorId(Long authorId);//根据作者标号查询
    public List<Posts> getChannelPosts(Long channel);//根据频道id查询所有文章
    public List<Posts> getAllPosts();//查询所有
    public List<Posts> findNewPostsLimit(int LIMIT);//根据时间查询前LIMIT条
}
