package Servlet;

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
    private UserService userService = new UserServiceImpl();
    private PostsService postsService = new PostsServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");

        if ("register".equals(op)) {
            // 注册用户
            register(req, resp);

        } else if ("login".equals(op)) {
            // 用户登录
            login(req, resp);

        } else if ("logout".equals(op)) {
            // 用户注销
            logout(req, resp);
        } else if ("toLogin".equals(op)) {

            req.getRequestDispatcher("jsps/default/auth/login.jsp").forward(req, resp);
        } else if ("toRegister".equals(op)) {

            req.getRequestDispatcher("jsps/default/auth/register.jsp").forward(req, resp);
        } else if ("toMyPage".equals(op)) {

            req.getRequestDispatcher("jsps/default/user/method_feeds.jsp").forward(req, resp);
        } else if ("toMyArticle".equals(op)) {

            req.getRequestDispatcher("jsps/default/user/method_posts.jsp").forward(req, resp);
        } else if ("toMyComment".equals(op)) {

            req.getRequestDispatcher("jsps/default/user/method_comments.jsp").forward(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int num = userService.isTrue(username, password);
        if (num > 0) {
            User user = userService.getUser1(username);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("index");
        } else {
            resp.sendRedirect("jsps/default/auth/login.jsp");
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User();
        user.setPassword(password);
        user.setName(name);
        user.setUsername(username);
        userService.addUser(user);
        resp.sendRedirect("jsps/default/auth/login.jsp");
    }


    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 销毁Session
        req.getSession().invalidate();
        // 跳转到首页
        resp.sendRedirect("index");
    }
}
