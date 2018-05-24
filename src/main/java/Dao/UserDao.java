package Dao;

import bean.User;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager;

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
    User getUser(long id);
    //根据用户名查询用户
    User getUser1(String username);
    //查询所有用户
    List<User> getAll();
    //查询用户名是否存在
    int isExits(String username);
    //判断登录
    int isTrue(String username,String password);
    //查询热门用户
    List<User> getNewUsers(int Limit);
}
