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
        //得到所选频道的内容并按需求排序
        long id=Long.parseLong(req.getParameter("id"));
        List<Posts> postsList= postsService.getChannelPosts(id);
        String order=req.getParameter("order");

        if("newest".equals(order)){
            Collections.sort(postsList, new Comparator<Posts>() {
                @Override
                public int compare(Posts o1, Posts o2) {
                    return o2.getCreated().compareTo(o1.getCreated());
                }
            });
        }else if ("favors".equals(order)){
            Collections.sort(postsList, new Comparator<Posts>() {
                @Override
                public int compare(Posts o1, Posts o2) {
                    return o2.getFavors()-o1.getFavors();
                }
            });
        }else if("hottest".equals(order)){
            Collections.sort(postsList, new Comparator<Posts>() {
                @Override
                public int compare(Posts o1, Posts o2) {
                    return o2.getComments()-o1.getComments();
                }
            });
        }
        req.setAttribute("postsList",postsList);

        req.setAttribute("id",id);
        req.getRequestDispatcher("jsps/default/channel/index.jsp").forward(req,resp);

    }
}
