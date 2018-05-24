package controller;

import Service.ChannelService;
import Service.Impl.ChannelServiceImpl;
import Service.Impl.PostsServiceImpl;
import Service.Impl.UserServiceImpl;
import Service.PostsService;
import Service.UserService;
import bean.Channel;
import bean.Posts;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/index"})
public class IndexServlet extends HttpServlet {
    private ChannelService channelService = new ChannelServiceImpl();
    private PostsService postsService = new PostsServiceImpl();
    private UserService userservice = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Channel> channelList = channelService.findAll();
        List<Posts> postsList = postsService.getAllPosts();
        List<User> usersList = userservice.getAll();
        req.setAttribute("usersList",usersList);
        req.setAttribute("postsList", postsList);
        req.getSession().setAttribute("channelList", channelList);
        req.getRequestDispatcher("jsps/default/index.jsp").forward(req, resp);
    }
}
