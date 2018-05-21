package Dao;

import bean.User;

import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public interface UserDao {
    //增加用户
    int addUser(User user);
    //删除用户
    int delUser(int id);
    //更新用户信息
    int updateUser(User user);
    //根据ID查询用户
    User getUser(int id);
    //查询所有用户
    List<User> getAll();
    //查询用户名是否存在
    int isExits(String username);
}
