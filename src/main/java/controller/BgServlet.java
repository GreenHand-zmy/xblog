package controller;

import dao.ChannelDao;
import dao.CommentDao;
import dao.Impl.ChannelDaoImpl;
import dao.Impl.CommentDaoImpl;
import dao.Impl.PostDaoImpl;
import dao.Impl.UserDaoImpl;
import dao.PostDao;
import dao.UserDao;
import service.ChannelService;
import service.CommentService;
import service.Impl.ChannelServiceImpl;
import service.Impl.CommentServiceImpl;
import service.Impl.PostsServiceImpl;
import service.Impl.UserServiceImpl;
import service.PostsService;
import service.UserService;
import bean.Channel;
import bean.Comment;
import bean.Post;
import bean.User;
import constant.ChannelStatusConstant;
import constant.CommentStatusConstant;
import constant.PostStatusConstant;
import constant.UserStatusConstant;
import sun.security.provider.MD5;
import utils.MD5Utils;
import utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Fang on 2018/5/24.
 */
@WebServlet("/BgServlet")
public class BgServlet extends HttpServlet {
    PostsService postsService = new PostsServiceImpl();
    UserService userService = new UserServiceImpl();
    CommentService commentService = new CommentServiceImpl();
    ChannelService channelService = new ChannelServiceImpl();
    PostDao postDao = new PostDaoImpl();
    ChannelDao channelDao = new ChannelDaoImpl();
    UserDao userDao = new UserDaoImpl();
    CommentDao commentDao = new CommentDaoImpl();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        List<Post> postsList = postsService.getAllPosts();
        List<User> userList = userService.getAll();
        List<Channel> channelList = channelService.findAll();
        List<Comment> commentList = commentService.getAllComments();
        if ("comment".equals(op)) {
            req.setAttribute("commentList", commentList);
            req.getRequestDispatcher("WEB-INF/jsps/admin/comment/list.jsp").forward(req, resp);
        } else if ("channel".equals(op)) {
            req.setAttribute("channelList", channelList);
            req.getRequestDispatcher("WEB-INF/jsps/admin/channel/list.jsp").forward(req, resp);
        } else if ("posts".equals(op)) {
            req.setAttribute("postsList", postsList);
            req.getRequestDispatcher("WEB-INF/jsps/admin/post/list.jsp").forward(req, resp);
        } else if ("user".equals(op)) {
            req.setAttribute("userList", userList);
            req.getRequestDispatcher("WEB-INF/jsps/admin/user/list.jsp").forward(req, resp);
        } else if ("index".equals(op)) {
            req.getRequestDispatcher("WEB-INF/jsps/admin/index.jsp").forward(req, resp);
        } else if ("updatePost".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Post post = postDao.getPost(id);
            String title = req.getParameter("title");
            int channelId = Integer.parseInt(req.getParameter("channelId"));
            post.setTitle(title);
            post.setChannelId(channelId);
            postsService.updatePost(post);
            req.getRequestDispatcher("WEB-INF/jsps/admin/index.jsp").forward(req, resp);
        } else if ("delPost".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Post post = postDao.getPost(id);
            post.setStatus(PostStatusConstant.DELETED_STATUS);
            req.getRequestDispatcher("WEB-INF/jsps/admin/index.jsp").forward(req, resp);
        } else if ("updateChannel".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Channel channel = channelDao.findById(id);
            String name = req.getParameter("name");
            String key = req.getParameter("key");
            channel.setName(name);
            channel.setKey(key);
            channelService.update(channel);
            req.getRequestDispatcher("WEB-INF/jsps/admin/index.jsp").forward(req, resp);
        } else if ("delChannel".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Channel channel = channelDao.findById(id);
            channel.setStatus(ChannelStatusConstant.CLOSED_STATUS);
        } else if ("updatePwsUser".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            User user = userDao.getUser(id);
            String password = req.getParameter("password");
            user.setPassword(password);
            userService.updateUser(user);
            req.getRequestDispatcher("WEB-INF/jsps/admin/index.jsp").forward(req, resp);
        } else if ("delUser".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            User user = userDao.getUser(id);
            // 设置用户为被删除状态,并更新到数据库中
            user.setStatus(UserStatusConstant.DELETED_STATUS);
            userService.updateUser(user);
        } else if ("delComment".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Comment comment = commentDao.getCommentById(id);
            comment.setStatus(CommentStatusConstant.DELETED_STATUS);
            commentDao.update(comment);

        } else if ("getUser".equals(op)) {
            String name = req.getParameter("name");
            List<User> userList2 = userDao.getUsername(name);
            req.setAttribute("userList", userList2);
            req.getRequestDispatcher("WEB-INF/jsps/admin/user/list.jsp").forward(req, resp);
        } else if ("getPost".equals(op)) {
            String title = req.getParameter("title");
            List<Post> postsList2 = postDao.getPostTitle(title);
            req.setAttribute("postsList", postsList2);
            req.getRequestDispatcher("WEB-INF/jsps/admin/post/list.jsp").forward(req, resp);
        } else if ("getComment".equals(op)) {
            String content = req.getParameter("content");
            List<Comment> commentList2 = commentDao.getCommentContent(content);
            req.setAttribute("commentList", commentList2);
            req.getRequestDispatcher("WEB-INF/jsps/admin/comment/list.jsp").forward(req, resp);
        } else if ("toAdminPage".equals(op)) {
            User user = (User) req.getSession().getAttribute("user");
            if (!UserStatusConstant.ADMIN_STATUS.equals(user.getStatus())) {
                resp.getWriter().print("<script>alert('您不是管理员用户,无权进入后台页面');history.go('-1');</script>");
                return;
            }
            req.getRequestDispatcher("WEB-INF/jsps/admin/index.jsp").forward(req, resp);
        } else if ("activeUser".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            User user = userDao.getUser(id);

            // 设置用户为正常状态,并更新到数据库中
            user.setStatus(UserStatusConstant.NORMAL_STATUS);
            userService.updateUser(user);
        } else if ("updatePwdUser".equals(op)) {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = userService.getUser(id);

            // 设置新密码
            String newPassword = MD5Utils.md5(req.getParameter("newPassword"));
            user.setPassword(newPassword);
            userService.updateUser(user);

            resp.sendRedirect("BgServlet?op=user");
        } else if ("toAddChannelPage".equals(op)) {
            req.getRequestDispatcher("WEB-INF/jsps/admin/channel/view.jsp").forward(req, resp);
        } else if ("addChannel".equals(op)) {
            // 获取频道必须参数
            String channelName = req.getParameter("name");
            String key = req.getParameter("key");
            String channelId = req.getParameter("id");
            String status = req.getParameter("status");

            // 如果频道编号为空,则进行插入
            if (StringUtil.isEmpty(channelId)) {
                // 构造频道对象,并保存到数据库
                Channel channel = new Channel();
                channel.setName(channelName);
                channel.setKey(key);
                channel.setStatus(ChannelStatusConstant.NORMAL_STATUS);
                channelService.save(channel);
            } else {
                // 如果频道编号不为空,则进行更新
                long channelIdL = Long.parseLong(channelId);
                int lStatus = Integer.parseInt(status);
                Channel channel = channelService.findById(channelIdL);
                channel.setName(channelName);
                channel.setKey(key);
                channel.setStatus(lStatus);
                channelService.update(channel);
            }
            resp.sendRedirect("BgServlet?op=channel");
        }
    }
}
