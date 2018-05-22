package com.peter.xblog.dao;

import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import bean.User;
import org.junit.Test;

import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public class UserDaoTest {
    UserDao ud= new UserDaoImpl();

   @Test
     public void addUser(){
       User user =new User();
       user.setPassword("1234");
       user.setUsername("久123");
       user.setName("zh5");
       int num=ud.addUser(user);
       System.out.println(num);
   }

   @Test
    public void updateUser(){
       User user1 =new User();
       user1.setPassword("1234");
       user1.setUsername("久1");
       user1.setName("zh1");
       user1.setAvatar("1");
       user1.setSignature("zmySB");
       user1.setId((long) 1);
       int num=ud.updateUser(user1);
       System.out.println(num);
   }

   @Test
    public  void delUser(){
        int num = ud.delUser(3);
       System.out.println(num);
   }

   @Test
    public void getUser(){
        User user2=ud.getUser(1);
       System.out.println(user2);
   }

   @Test
    public void getAll(){
       List<User> list=ud.getAll();
       for(User user:list){
           System.out.println(user);
       }
   }

   @Test
    public void isExits(){
       int num= ud.isExits("久");
       System.out.println(num);
   }
}
