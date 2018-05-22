package controller;


import Service.Impl.PostsServiceImpl;
import Service.PostsService;
import bean.Posts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lfy on 2018/5/22.
 */
@WebServlet("/ChannelsServlet")
public class ChannelsServlet extends HttpServlet{
    PostsService ps=new PostsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("utf-8");
      resp.setContentType("text/html;utf-8");
      PrintWriter out=resp.getWriter();
      long id=Integer.parseInt(req.getParameter("id"));
      List<Posts> postsList=ps.getChannelPosts(id);
      req.setAttribute("postsList",postsList);
      req.getRequestDispatcher("").forward(req,resp);
    }
}
