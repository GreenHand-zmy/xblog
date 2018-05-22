package controller;

import Service.ChannelService;
import Service.Impl.ChannelServiceImpl;
import bean.Channel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private ChannelService channelService = new ChannelServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Channel> channelList = channelService.findAll();

        req.setAttribute("channelList", channelList);
        req.getRequestDispatcher("jsps/default/index.jsp").forward(req, resp);
    }
}
