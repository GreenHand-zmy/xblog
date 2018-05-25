package controller;

import Dao.ChannelDao;
import Dao.Impl.ChannelDaoImpl;
import Dao.Impl.PostDaoImpl;
import Dao.Impl.UserDaoImpl;
import Dao.PostDao;
import Dao.UserDao;
import Service.ChannelService;
import Service.CommentService;
import Service.Impl.ChannelServiceImpl;
import Service.Impl.CommentServiceImpl;
import Service.Impl.PostsServiceImpl;
import Service.Impl.UserServiceImpl;
import Service.PostsService;
import Service.UserService;
import bean.Channel;
import bean.Comment;
import bean.Post;
import bean.Post;
import bean.User;

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
    PostsService postsService =new PostsServiceImpl();
    UserService userService = new UserServiceImpl();
    CommentService commentService = new CommentServiceImpl();
    ChannelService channelService = new ChannelServiceImpl();
    PostDao postDao = new PostDaoImpl();
    ChannelDao channelDao = new ChannelDaoImpl();
    UserDao userDao =new UserDaoImpl();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        List<Post> postsList= postsService.getAllPosts();
        List<User> userList = userService.getAll();
        List<Channel> channelList = channelService.findAll();
        List<Comment> commentList = commentService.getAllComments();
        if ("comment".equals(op)) {
            req.setAttribute("commentList",commentList);
            req.getRequestDispatcher("jsps/admin/comment/list.jsp").forward(req,resp);
        }else if("channel".equals(op)){
            req.setAttribute("channelList",channelList);
            req.getRequestDispatcher("jsps/admin/channel/list.jsp").forward(req,resp);
        }else if("posts".equals(op)){
            req.setAttribute("postsList",postsList);
            req.getRequestDispatcher("jsps/admin/post/list.jsp").forward(req,resp);
        }else if("user".equals(op)){
            req.setAttribute("userList",userList);
            req.getRequestDispatcher("jsps/admin/user/list.jsp").forward(req,resp);
        }else if("index".equals(op)){
            req.getRequestDispatcher("jsps/admin/index.jsp").forward(req,resp);
        }else if("updatePost".equals(op)){
            // 通过文章编号获取文章
            long id = Integer.parseInt(req.getParameter("id"));
            Post post = postDao.getPost(id);

            // 获取修改后的属性

            // 文章标题
            String title = req.getParameter("title");
            // 文章频道
            int channelId = Integer.parseInt(req.getParameter("channelId"));
            // 设置到对象中
            post.setTitle(title);
            post.setChannelId(channelId);
            // 写入到数据库中
            postsService.updatePost(post);
       /* resp.sendRedirect("ChannelServlet?id=" + post.getChannelId());*/
            req.getRequestDispatcher("jsps/admin/post/list.jsp").forward(req,resp);
        }else if ("delPost".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            postsService.deletePost(id);
            req.getRequestDispatcher("jsps/admin/post/list.jsp").forward(req, resp);
        }else if ("updateChannel".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Channel channel = channelDao.findById(id);
            String name = req.getParameter("name");
            String key = req.getParameter("key");
            channel.setName(name);
            channel.setKey(key);
            channelService.update(channel);
            req.getRequestDispatcher("jsps/admin/channel/list.jsp").forward(req, resp);
        }else if ("delChannel".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            channelService.deleteChannel(id);
            req.getRequestDispatcher("jsps/admin/channel/list.jsp").forward(req, resp);
        }else if ("updatePwsUser".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            User user = userDao.getUser(id);
            String password = req.getParameter("password");
            user.setPassword(password);
            userService.updateUser(user);
            req.getRequestDispatcher("jsps/admin/user/list.jsp").forward(req, resp);
        }
    }
}
