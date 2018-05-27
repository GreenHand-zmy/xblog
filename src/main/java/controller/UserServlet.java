package controller;

import service.CommentService;
import service.Impl.CommentServiceImpl;
import service.Impl.PostsServiceImpl;
import service.Impl.UserServiceImpl;
import service.PostsService;
import service.UserService;
import bean.Post;
import bean.User;
import utils.JsonUtil;
import utils.MD5Utils;
import utils.ResultBean;
import utils.StringUtil;
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
        } else if ("ajaxUserExisted".equals(op)) {
            ajaxUserExisted(req, resp);
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
            req.getRequestDispatcher("/UserServlet?op=toMyArticle").forward(req, resp);
        } else if ("toMyArticle".equals(op)) {
            //到我的文章
            User user = (User) req.getSession().getAttribute("user");
            List<Post> postList = postsService.getPostAuthorId(user.getId());
            postList.sort((post1, post2) -> post2.getCreated().compareTo(post1.getCreated()));
            req.setAttribute("postList", postList);
            req.getRequestDispatcher("jsps/default/user/method_posts.jsp").forward(req, resp);
        } else if ("toMyComment".equals(op)) {
            //到我的评论
            User user = (User) req.getSession().getAttribute("user");
            List<PostCommentVo> postCommentVoList = commentService.getPostCommentVoByAuthorId(user.getId());
            // 将评论按照时间降序排序
            postCommentVoList.sort((postCommentVo1, postCommentVo2) ->
                    postCommentVo2.getComment().getCreated().compareTo(postCommentVo1.getComment().getCreated()));

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
            // 获取指定用户编号
            Long id = Long.parseLong(req.getParameter("antherId"));
            User user = userService.getUser(id);
            req.setAttribute("user", user);

            // 获取指定用户文章
            List<Post> postList = postsService.getPostAuthorId(user.getId());
            // 对用户文章按照发表日期降序排序
            postList.sort((post1, post2) -> post2.getCreated().compareTo(post1.getCreated()));

            req.setAttribute("postList", postList);

            // 转入展示页面
            req.getRequestDispatcher("jsps/default/view/view.jsp").forward(req, resp);
        } else if ("showUserAvatar".equals(op)) {
            // 输出图片
            showUserAvatar(req, resp);
        }
    }

    private void showUserAvatar(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long authorId = Long.parseLong(req.getParameter("authorId"));
        User user = userService.getUser(authorId);
        String path = this.getServletContext().getRealPath("/upload/avatar");
        File file = new File(path + "/" + user.getAvatar());
        String mimeType = req.getServletContext().getMimeType(user.getAvatar());
        resp.setContentType(mimeType);
        OutputStream out = resp.getOutputStream();
        FileInputStream input = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int count;
        while ((count = input.read(buffer)) > 0) {
            out.write(buffer, 0, count);
        }
        input.close();
    }

    private void ajaxUserExisted(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = null;
        try {
            resp.setContentType("application/json;charset=utf-8");
            writer = resp.getWriter();
            // 获取用户名,并通过用户名查找数据库是否存在
            String username = req.getParameter("username");
            User existedUser = userService.getUser1(username);

            // 如果此用户名不存在,则允许添加
            if (existedUser == null) {
                writer.write(JsonUtil.objectToJson(new ResultBean<>().success()));
            } else {
                writer.write(JsonUtil.objectToJson(new ResultBean<>().fail("用户已存在")));
            }
        } catch (RuntimeException e) {
            writer.write(JsonUtil.objectToJson(new ResultBean<>().fail(e.getMessage())));
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
            String password = MD5Utils.md5(req.getParameter("password"));
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
        String password = MD5Utils.md5(req.getParameter("password"));

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
        // 将密码加密为md5字符串
        String password = MD5Utils.md5(req.getParameter("password"));

        // 构造用户对象,并写入数据库
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
        String password = req.getParameter("password");

        if (StringUtil.isNotEmpty(name) && StringUtil.isNotEmpty(signature)) {
            user.setName(name);
            user.setSignature(signature);
            userService.updateUser(user);
        } else if (StringUtil.isNotEmpty(password)) {
            String oldPassword = MD5Utils.md5(req.getParameter("oldPassword"));
            // 与原密码不同则不允许修改
            if (!oldPassword.equals(user.getPassword())) {
                resp.getWriter().print("<script>alert('原密错误');history.go('-1');</script>");
                return;
            }

            // 与原密码相同则更改
            user.setPassword(MD5Utils.md5(password));
            userService.updateUser(user);
        }
        // 更新Session
        req.getSession().setAttribute("user", user);

        req.getRequestDispatcher("UserServlet?op=toMyArticle").forward(req, resp);
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 销毁Session
        req.getSession().invalidate();
        // 跳转到首页
        resp.sendRedirect("index");
    }
}
