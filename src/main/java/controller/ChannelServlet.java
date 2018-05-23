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



import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lfy on 2018/5/22.
 */
@WebServlet("/ChannelServlet")
public class ChannelServlet extends HttpServlet{
    PostsService postsService =new PostsServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id=Long.parseLong(req.getParameter("id"));
        List<Posts> postsList= postsService.getChannelPosts(id);
        String order=req.getParameter("order");
        if("newest".equals(order)){
            Collections.sort(postsList, new Comparator<Posts>() {
                @Override
                public int compare(Posts o1, Posts o2) {
                    return o1.getCreated().compareTo(o2.getCreated());
                }
            });
        }else if ("favors".equals(order)){
            Collections.sort(postsList, new Comparator<Posts>() {
                @Override
                public int compare(Posts o1, Posts o2) {
                    return o1.getFavors()-o2.getFavors();
                }
            });
        }else if("hottest".equals(order)){
            Collections.sort(postsList, new Comparator<Posts>() {
                @Override
                public int compare(Posts o1, Posts o2) {
                    return o1.getComments()-o2.getComments();
                }
            });
        }
        req.setAttribute("postsList",postsList);
        req.getRequestDispatcher("jsps/default/channel/index.jsp").forward(req,resp);
    }
}
