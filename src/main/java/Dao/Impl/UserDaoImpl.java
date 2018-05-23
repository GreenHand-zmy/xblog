package Dao.Impl;

import utils.DBUtil;
import Dao.UserDao;
import bean.User;

import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int addUser(User user) {
        String sql = "insert into mto_users(created,password,username,name) values(sysDate(),?,?,?)";
        return DBUtil.executeUpdate(sql, user.getPassword(), user.getUsername(), user.getName());
    }

    @Override
    public int delUser(int id) {
        String sql = "delete from mto_users where id=?";
        return DBUtil.executeUpdate(sql, id);
    }

    @Override
    public int updateUser(User user) {
        String sql = "update mto_users set password=?,name=?,avatar=?,signature=?,updated=sysDate() where id=?";
        return DBUtil.executeUpdate(sql, user.getPassword(), user.getName(), user.getAvatar(), user.getSignature(), user.getId());
    }

    @Override
    public User getUser(int id) {
        String sql = "select * from mto_users where id=?";
        return DBUtil.getObject(sql, User.class, id);
    }

    @Override
    public User getUser1(String username) {
        String sql = "select * from mto_users where username=?";
        return DBUtil.getObject(sql, User.class, username);
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from mto_users";
        return DBUtil.getObjects(sql, User.class);
    }

    @Override
    public int isExits(String username) {
        String sql = "select count(*) from mto_users where username=?";
        return DBUtil.getCount(sql, User.class, username);
    }

    @Override
    public int isTrue(String username, String password) {
        String sql="select count(*) from mto_users where username=? and password=?";
        return DBUtil.getCount(sql,User.class,username,password);
    }

    @Override
    public List<User> getNewUsers(int Limit) {
        String sql="select * from mto_users order by created desc Limit ?";
        return DBUtil.getObjects(sql,User.class,Limit);
    }
}
