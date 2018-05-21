package Service.Impl;

import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Service.UserService;
import bean.User;

import static utils.CheckUtil.*;

import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public class UserServiceImpl implements UserService {
    UserDao ud= new UserDaoImpl();

    //注册用户
    @Override
    public int addUser(User user) {
        check(user.getPassword()!=null,"密码不能为空");
        check(user.getUsername()!=null,"用户名不能为空");
        int num1 = ud.isExits(user.getUsername());
        check(num1==0,"用户名已存在");
        check(user.getName()!=null,"真实姓名不能为空");
        int num=ud.addUser(user);
        return num;
    }

    @Override
    public int delUser(int id) {
        User user=ud.getUser(id);
        check(user!=null,"该用户不存在");
        int num=ud.delUser(id);
        return num;
    }

    @Override
    public int updateUser(User user) {
        check(user.getPassword()!=null,"密码不能为空");
        check(user.getUsername()!=null,"用户名不能为空");
        int num1 = ud.isExits(user.getUsername());
        check(num1==0,"用户名已存在");
        check(user.getName()!=null,"真实姓名不能为空");
        int num=ud.updateUser(user);
        return num;
    }

    @Override
    public User getUser(int id) {
        User user=ud.getUser(id);
        check(user!=null,"该用户不存在");
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> list=ud.getAll();
        check(list!=null,"无查询结果");
        return list;
    }
}
