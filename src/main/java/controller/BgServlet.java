package controller;

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
        }
    }
}
