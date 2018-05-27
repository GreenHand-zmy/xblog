package service;

import bean.User;

import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public interface UserService {
    /**
     * 增加普通用户
     *
     * @param user 用户对象
     * @return
     */
    int addUser(User user);

    /**
     * 增加管理员用户
     *
     * @param user 用户对象
     * @return
     */
    int addAdmin(User user);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return
     */
    int delUser(long id);

    /**
     * 更新用户信息
     *
     * @param user 用户对象
     * @return
     */
    int updateUser(User user);

    /**
     * 根据用户ID查用户
     *
     * @param id 用户ID
     * @return
     */
    User getUser(long id);

    /**
     * 根据用户名查用户
     *
     * @param username 用户名
     * @return
     */
    User getUser1(String username);

    /**
     * 根据用户名模糊查用户
     *
     * @param username 用户名
     * @return
     */
    List<User> getUsername(String username);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> getAll();

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    int isTrue(String username, String password);

    /**
     * 查询热门用户
     *
     * @param Limit 行数
     * @return
     */
    List<User> getNewUsers(int Limit);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 用户密码
     */
    User login(String username, String password);
}
