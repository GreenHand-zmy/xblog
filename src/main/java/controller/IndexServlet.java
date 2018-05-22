package controller;

import Service.ChannelService;
import Service.Impl.ChannelServiceImpl;
import Service.Impl.PostsServiceImpl;
import Service.PostsService;
import bean.Channel;
import bean.Posts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/", "/index"})
public class IndexServlet extends HttpServlet {
    private ChannelService channelService = new ChannelServiceImpl();
    private PostsService postsService = new PostsServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Channel> channelList = channelService.findAll();
        List<Posts> postsList = postsService.getAllPosts();
        req.setAttribute("postsList", postsList);
        req.getSession().setAttribute("channelList", channelList);
        req.getRequestDispatcher("jsps/default/index.jsp").forward(req, resp);
    }
}
