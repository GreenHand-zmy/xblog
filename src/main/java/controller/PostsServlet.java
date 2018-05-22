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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Fang on 2018/5/22.
 */
@WebServlet("/PostsServlet")
public class PostsServlet extends HttpServlet{
    PostsService ps=new PostsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;utf-8");
        PrintWriter out = resp.getWriter();
        long id=Integer.parseInt(req.getParameter("id"));
        long authorId=Integer.parseInt(req.getParameter("authorId"));
        String op=req.getParameter("op");
        List<Posts> postsList =new ArrayList<Posts>();
        int LIMIT = 5;
        if("selectAuthorId".equals(op)){
            postsList=ps.getPostAuthorId(authorId);
        }else if("selectAll".equals(op)){
            postsList=ps.getAllPosts();
        }else if("selectByTime".equals(op)){
            postsList=ps.findNewPostsLimit(LIMIT);
        }else if("selectByFavors".equals(op)){
            postsList=ps.findNewPostsLimit2(LIMIT);
        }else if("selectByComments".equals(op)){
            postsList=ps.findNewPostsLimit3(LIMIT);
        }
        req.setAttribute("postsList",postsList);
        req.getRequestDispatcher("").forward(req,resp);
    }
}
