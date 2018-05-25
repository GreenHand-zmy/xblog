package Servlet;

import Service.CommentService;
import Service.Impl.CommentServiceImpl;
import Service.Impl.PostsServiceImpl;
import Service.Impl.UserServiceImpl;
import Service.PostsService;
import Service.UserService;
import bean.Post;
import bean.User;
import constant.ChannelStatusConstant;
import utils.JsonUtil;
import utils.ResultBean;
import vo.PostCommentVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ZH on 2018/5/22.
 */
@WebServlet(value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private PostsService postsService = new PostsServiceImpl();
    private CommentService commentService = new CommentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");

        if ("register".equals(op)) {
            // 注册用户
            register(req, resp);

        } else if ("login".equals(op)) {
            // 用户登录
            login(req, resp);

        } else if ("ajaxLogin".equals(op)) {
            // ajax登录
            ajaxLogin(req, resp);
        } else if ("logout".equals(op)) {
            // 用户注销
            logout(req, resp);
        } else if ("update".equals(op)) {
            // 用户更新
            update(req, resp);
        } else if ("ajaxGetHotUser".equals(op)) {
            ajaxGetHotUser(req, resp);
        } else if ("toLogin".equals(op)) {
            //到登录页面
            req.getRequestDispatcher("jsps/default/auth/login.jsp").forward(req, resp);
        } else if ("toRegister".equals(op)) {
            //到注册页面
            req.getRequestDispatcher("jsps/default/auth/register.jsp").forward(req, resp);
        } else if ("toMyPage".equals(op)) {
            //到我的主页
            User user = (User) req.getSession().getAttribute("user");
            List<Post> postsList = postsService.getPostAuthorId(user.getId());
            req.setAttribute("postsList", postsList);
            req.getRequestDispatcher("jsps/default/user/method_posts.jsp").forward(req, resp);
        } else if ("toMyArticle".equals(op)) {
            //到我的文章
            User user = (User) req.getSession().getAttribute("user");
            List<Post> postList = postsService.getPostAuthorId(user.getId());
            req.setAttribute("postList", postList);
            req.getRequestDispatcher("jsps/default/user/method_posts.jsp").forward(req, resp);
        } else if ("toMyComment".equals(op)) {
            //到我的评论
            User user = (User) req.getSession().getAttribute("user");
            List<PostCommentVo> postCommentVoList = commentService.getPostCommentVoByAuthorId(user.getId());
            req.setAttribute("postCommentVoList", postCommentVoList);
            req.getRequestDispatcher("jsps/default/user/method_comments.jsp").forward(req, resp);
        } else if ("toUpdate".equals(op)) {
            //到编辑信息页面
            req.getRequestDispatcher("jsps/default/user/profile.jsp").forward(req, resp);
        } else if ("toUpdateAvatar".equals(op)) {
            //到编辑头像页面

            req.getRequestDispatcher("jsps/default/user/avatar.jsp").forward(req, resp);
        } else if ("toUpdatePassword".equals(op)) {
            //到编辑密码页面
            req.getRequestDispatcher("jsps/default/user/password.jsp").forward(req, resp);
        } else if ("toOtherUser".equals(op)) {
            //查看他人主页
            Long id = Long.parseLong(req.getParameter("antherId"));
            User user = userService.getUser(id);
            req.setAttribute("user", user);
            Post post = postsService.getPost(id);
            req.setAttribute("posts", post);
            req.getRequestDispatcher("jsps/default/view/view.jsp").forward(req, resp);
        } else if ("showUserAvatar".equals(op)) {
            // 输出图片
            long authorId = Long.parseLong(req.getParameter("authorId"));
            User user = userService.getUser(authorId);
            File file = new File("D:\\JSPWork\\xblog\\xblog\\target\\xblog" + user.getAvatar());
            resp.setContentType("image/jpeg");
            OutputStream out = resp.getOutputStream();
            FileInputStream input = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int count;
            while ((count = input.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
            input.close();
        }
    }

    private void ajaxGetHotUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = null;
        try {
            int limit = Integer.parseInt(req.getParameter("limit"));
            List<User> userList = userService.getNewUsers(limit);
            resp.setContentType("application/json;charset=utf-8");
            writer = resp.getWriter();
            writer.write(JsonUtil.objectToJson(new ResultBean<>().success(userList)));
        } catch (RuntimeException e) {
            writer.write(JsonUtil.objectToJson(new ResultBean<>().fail(e.getMessage())));
        }
    }

    private void ajaxLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = userService.login(username, password);
            req.getSession().setAttribute("user", user);
            resp.setContentType("application/json;charset=utf-8");
            writer.write(JsonUtil.objectToJson(new ResultBean<>().success()));
        } catch (RuntimeException e) {
            writer.write(JsonUtil.objectToJson(new ResultBean<>().fail(e.getMessage())));
        } finally {
            writer.close();
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int num = userService.isTrue(username, password);
        if (num > 0) {
            User user = userService.getUser1(username);
            req.getSession().setAttribute("user", user);
            user.setLastLogin(new Date());
            userService.updateUser(user);
            resp.sendRedirect("index");
        } else {
            resp.getWriter().print("<script>alert('用户名或密码错误');history.go('-1');</script>");
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

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.getUser(id);
        String name = req.getParameter("name");
        String signature = req.getParameter("signature");
        String file = req.getParameter("file");
        String password = req.getParameter("password");
        if (file == null && password == null) {
            user.setName(name);
            user.setSignature(signature);
            userService.updateUser(user);
        } else if (name == null && password == null) {
            user.setAvatar(file);
            userService.updateUser(user);
        } else if (name == null && file == null) {
            user.setPassword(password);
            userService.updateUser(user);
        }
        req.getSession().setAttribute("user", user);
        User user1 = (User) req.getSession().getAttribute("user");
        List<Post> postsList = postsService.getPostAuthorId(user1.getId());
        req.setAttribute("postsList", postsList);
        req.getRequestDispatcher("jsps/default/user/method_posts.jsp").forward(req, resp);
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 销毁Session
        req.getSession().invalidate();
        // 跳转到首页
        resp.sendRedirect("index");
    }
}
