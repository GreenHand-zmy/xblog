package Servlet;

import Dao.UserDao;
import Service.Impl.PostsServiceImpl;
import Service.Impl.UserServiceImpl;
import Service.PostsService;
import Service.UserService;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZH on 2018/5/22.
 */
@WebServlet(value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        UserService us=new UserServiceImpl();
        PostsService ps= new PostsServiceImpl();
        if("register".equals(op)){
            String username=req.getParameter("username");
            String name=req.getParameter("name");
            String password=req.getParameter("password");
            User user=new User();
            user.setPassword(password);
            user.setName(name);
            user.setUsername(username);
            us.addUser(user);
            resp.sendRedirect("jsps/default/auth/login.jsp");
        }else if("login".equals(op)){
            String username=req.getParameter("username");
            String password=req.getParameter("password");
            int num=us.isTrue(username,password);
            if(num>0){
                User user=us.getUser1(username);
                req.getSession().setAttribute("user",user);
                resp.sendRedirect("index");
            }else{
                resp.sendRedirect("jsps/default/auth/login.jsp");
            }
        }else if("post".equals(op)){
            resp.sendRedirect("jsps/default/user/method_posts.jsp");
        }else if("comment".equals(op)){
            resp.sendRedirect("jsps/default/user/method_comments.jsp");
        }else if("toLogin".equals(op)){
            resp.sendRedirect("jsps/default/auth/login.jsp");
        }else if("toRegister".equals(op)){
            resp.sendRedirect("jsps/default/auth/register.jsp");
        }
    }
}
