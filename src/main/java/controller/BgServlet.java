package controller;

import Dao.ChannelDao;
import Dao.CommentDao;
import Dao.Impl.ChannelDaoImpl;
import Dao.Impl.CommentDaoImpl;
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
import constant.ChannelStatusConstant;
import constant.CommentStatusConstant;
import constant.PostStatusConstant;
import constant.UserStatusConstant;

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
    CommentDao commentDao = new CommentDaoImpl();

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
            long id = Integer.parseInt(req.getParameter("id"));
            Post post = postDao.getPost(id);
            String title = req.getParameter("title");
            int channelId = Integer.parseInt(req.getParameter("channelId"));
            post.setTitle(title);
            post.setChannelId(channelId);
            postsService.updatePost(post);
            req.getRequestDispatcher("jsps/admin/index.jsp").forward(req,resp);
        }else if ("delPost".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Post post = postDao.getPost(id);
            post.setStatus(PostStatusConstant.DELETED_STATUS);
            req.getRequestDispatcher("jsps/admin/index.jsp").forward(req, resp);
        }else if ("updateChannel".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Channel channel = channelDao.findById(id);
            String name = req.getParameter("name");
            String key = req.getParameter("key");
            channel.setName(name);
            channel.setKey(key);
            channelService.update(channel);
            req.getRequestDispatcher("jsps/admin/index.jsp").forward(req, resp);
        }else if ("delChannel".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Channel channel = channelDao.findById(id);
            channel.setStatus(ChannelStatusConstant.CLOSED_STATUS);
            req.getRequestDispatcher("jsps/admin/index.jsp").forward(req, resp);
        }else if ("updatePwsUser".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            User user = userDao.getUser(id);
            String password = req.getParameter("password");
            user.setPassword(password);
            userService.updateUser(user);
            req.getRequestDispatcher("jsps/admin/index.jsp").forward(req, resp);
        }else if ("delUser".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            User user = userDao.getUser(id);
            user.setStatus(UserStatusConstant.DELETED_STATUS);
            req.getRequestDispatcher("jsps/admin/index.jsp").forward(req, resp);
        }else if ("delComment".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            Comment comment = commentDao.getCommentById(id);
            comment.setStatus(CommentStatusConstant.DELETED_STATUS);
            req.getRequestDispatcher("jsps/admin/index.jsp").forward(req, resp);
        }else if("getUser".equals(op)){
            String name = req.getParameter("name");
            List<User> userList2 = userDao.getUsername(name);
            req.setAttribute("userList", userList2);
            req.getRequestDispatcher("jsps/admin/user/list.jsp").forward(req, resp);
        }else if("getPost".equals(op)){
            String title = req.getParameter("title");
           List<Post> postsList2 = postDao.getPostTitle(title);
            req.setAttribute("postsList", postsList2);
            req.getRequestDispatcher("jsps/admin/post/list.jsp").forward(req, resp);
        }else if("getComment".equals(op)){
            String content = req.getParameter("content");
            List<Comment> commentList2 = commentDao.getCommentContent(content);
            req.setAttribute("commentList", commentList2);
            req.getRequestDispatcher("jsps/admin/comment/list.jsp").forward(req, resp);
        }
    }
}
