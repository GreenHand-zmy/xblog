package com.peter.xblog.service;

import Service.Impl.UserServiceImpl;
import Service.UserService;
import bean.User;
import org.junit.Test;

import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public class UserServiceTest {
    UserService us = new UserServiceImpl();

    @Test
    public void addUser() {
        User user = new User();
        user.setPassword("123");
        user.setUsername("久2");
        user.setName("zh");
        int num = us.addUser(user);
        System.out.println(num);
    }

    @Test
    public void updateUser() {
        User user1 = new User();
        user1.setPassword("1234");
        user1.setUsername("久2");
        user1.setName("zh1");
        user1.setAvatar("1");
        user1.setSignature("zmySB");
        user1.setId((long) 1);
        int num = us.updateUser(user1);
        System.out.println(num);
    }

    @Test
    public void delUser() {
        int num = us.delUser(4);
        System.out.println(num);
    }

    @Test
    public void getUser() {
        User user2 = us.getUser(2);
        System.out.println(user2);
    }

    @Test
    public void getAll() {
        List<User> list = us.getAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
