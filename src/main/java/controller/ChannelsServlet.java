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


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
      String op=req.getParameter("op");
      if("sortByDate".equals(op)){
          Collections.sort(postsList, new Comparator<Posts>() {
              @Override
              public int compare(Posts o1, Posts o2) {
                  return o1.getCreated().compareTo(o2.getCreated());
              }
          });
      }else if ("sortByFavors".equals(op)){
          Collections.sort(postsList, new Comparator<Posts>() {
              @Override
              public int compare(Posts o1, Posts o2) {
                  return o1.getFavors()-o2.getFavors();
              }
          });
      }else if("sortByComments".equals(op)){
          Collections.sort(postsList, new Comparator<Posts>() {
              @Override
              public int compare(Posts o1, Posts o2) {
                  return o1.getComments()-o2.getComments();
              }
          });
        }
      req.setAttribute("postsList",postsList);
      req.getRequestDispatcher("").forward(req,resp);
    }
}
