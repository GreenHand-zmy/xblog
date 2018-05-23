package controller;

import Service.Impl.PostsServiceImpl;
import Service.PostsService;
import bean.Posts;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Fang on 2018/5/22.
 */
@WebServlet("/PostsServlet")
public class PostsServlet extends HttpServlet{
    private PostsService ps=new PostsServiceImpl();
    private PostsService postsService = new PostsServiceImpl();
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
        }else if("updatePost".equals(op)){
            updatePost(req, resp);
        }else if("addPost".equals(op)){
            addPost(req, resp);
        }else if("getPost".equals(op)){
            getPost(req,resp);
        }else if("delPost".equals(op)){
            postsService.deletePost(id);
        }
        req.setAttribute("postsList",postsList);
        req.getRequestDispatcher("").forward(req,resp);
    }

    private void delPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    }

    private void getPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Posts post = new Posts();
        PrintWriter out = resp.getWriter();
        long id=Integer.parseInt(req.getParameter("id"));
        post = postsService.getPost(id);
        resp.sendRedirect("jsps/default/auth/view.jsp");
    }

    private void addPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Posts post = new Posts();
        Date created = new Date();
        User user = (User) req.getSession().getAttribute("user");
        int channelId = Integer.parseInt(req.getParameter("channelId"));;
        String tags = req.getParameter("tags");
        String title = req.getParameter("title");
        String summary = req.getParameter("summary");
        post.setAuthorId(user.getId());
        post.setCreated(created);
        post.setTitle(title);
        post.setTags(tags);
        post.setChannelId(channelId);
        post.setComments(0);
        post.setFavors(0);
        post.setFeatured(0);
        post.setStatus(0);
        post.setSummary(summary);
        post.setViews(0);
        post.setWeight(0);
        postsService.addPost(post);
        resp.sendRedirect("jsps/default/auth/index.jsp");
    }
    private void updatePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Posts post = new Posts();
        PrintWriter out = resp.getWriter();
        long id=Integer.parseInt(req.getParameter("id"));
        post = postsService.getPost(id);
        int channelId = Integer.parseInt(req.getParameter("channelId"));
        String tags = req.getParameter("tags");
        String title = req.getParameter("title");
        String summary = req.getParameter("summary");
        int featured = Integer.parseInt(req.getParameter("featured"));
        int status = Integer.parseInt(req.getParameter("status"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        post.setTitle(title);
        post.setTags(tags);
        post.setChannelId(channelId);
        post.setSummary(summary);
        post.setFeatured(featured);
        post.setWeight(weight);
        post.setStatus(status);
        postsService.updatePost(post);
        resp.sendRedirect("jsps/default/auth/index.jsp");
    }
}
