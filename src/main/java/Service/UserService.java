package Service;

import bean.User;

import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public interface UserService {
    int addUser(User user);

    int delUser(int id);

    int updateUser(User user);

    User getUser(long id);

    User getUser1(String username);

    List<User> getAll();

    int isTrue(String username,String password);

    List<User> getNewUsers(int Limit);
}
