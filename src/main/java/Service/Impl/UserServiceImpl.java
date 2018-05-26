package Service.Impl;

import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Service.UserService;
import bean.User;

import static constant.UserStatusConstant.ADMIN_STATUS;
import static constant.UserStatusConstant.DELETED_STATUS;
import static constant.UserStatusConstant.NORMAL_STATUS;
import static utils.CheckUtil.*;

import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    //注册用户
    @Override
    public int addUser(User user) {
        check(user.getPassword() != null, "密码不能为空");
        check(user.getUsername() != null, "用户名不能为空");
        int num1 = userDao.isExits(user.getUsername());
        check(num1 == 0, "用户名已存在");
        check(user.getName() != null, "昵称不能为空");
        user.setStatus(NORMAL_STATUS);
        int num = userDao.addUser(user);
        return num;
    }

    @Override
    public int addAdmin(User user) {
        check(user.getPassword() != null, "密码不能为空");
        check(user.getUsername() != null, "用户名不能为空");
        int num1 = userDao.isExits(user.getUsername());
        check(num1 == 0, "用户名已存在");
        check(user.getName() != null, "昵称不能为空");
        user.setStatus(ADMIN_STATUS);
        int num = userDao.addUser(user);
        return num;
    }

    @Override
    public int delUser(long id) {
        User user = userDao.getUser(id);
        check(user != null, "该用户不存在");
        user.setStatus(DELETED_STATUS);
        return userDao.updateUser(user);

    }

    @Override
    public int updateUser(User user) {
        check(user.getPassword() != null, "密码不能为空");
        check(user.getName() != null, "真实姓名不能为空");
        int num = userDao.updateUser(user);
        return num;
    }

    @Override
    public User getUser(long id) {
        User user = userDao.getUser(id);
        check(user != null, "该用户不存在");
        return user;
    }

    @Override
    public User getUser1(String username) {
        User user = userDao.getUser1(username);
        return user;
    }

    public List<User> getUsername(String username) {
        List<User> userList = userDao.getUsername(username);
        check(userList != null, "无查询结果");
        return userList;
    }

    @Override
    public List<User> getAll() {
        List<User> list = userDao.getAll();
        check(list != null, "无查询结果");
        return list;
    }

    @Override
    public int isTrue(String username, String password) {
        int num = userDao.isTrue(username, password);
        return num;
    }

    @Override
    public List<User> getNewUsers(int Limit) {
        List<User> list = userDao.getNewUsers(Limit);
        return list;
    }

    @Override
    public User login(String username, String password) {
        int exits = userDao.isExits(username);
        check(exits > 0, "用户不存在");
        User user1 = userDao.getUser1(username);
        check(password.equals(user1.getPassword()), "密码错误");
        return user1;
    }
}
