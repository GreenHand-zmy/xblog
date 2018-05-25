package Dao;

import bean.Post;
import bean.User;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager;

import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public interface UserDao {

    int addUser(User user);




    int updateUser(User user);


    User getUser(long id);

    List<User> getUsername(String username);

    User getUser1(String username);


    List<User> getAll();


    int isExits(String username);


    int isTrue(String username,String password);


    List<User> getNewUsers(int Limit);
}
