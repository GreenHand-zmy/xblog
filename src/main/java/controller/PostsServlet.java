package controller;

import Dao.Impl.PostDaoImpl;
import Dao.PostDao;
import Service.ChannelService;
import Service.CommentService;
import Service.Impl.ChannelServiceImpl;
import Service.Impl.CommentServiceImpl;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Fang on 2018/5/22.
 */
@WebServlet("/PostsServlet")
public class PostsServlet extends HttpServlet {
    private PostsService ps = new PostsServiceImpl();
    private PostsService postsService = new PostsServiceImpl();
    private CommentService commentService = new CommentServiceImpl();
    private ChannelService channelService = new ChannelServiceImpl();
    private PostDao postDao = new PostDaoImpl();

    private void getPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Posts post = new Posts();
        PrintWriter out = resp.getWriter();
        long id = Integer.parseInt(req.getParameter("id"));
        post = postsService.getPost(id);
        resp.sendRedirect("jsps/default/auth/view.jsp");
    }

    private void addPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取必要参数
        // 从Session中获取user对象
        User user = (User) req.getSession().getAttribute("user");
        // 获取文章标题
        String title = req.getParameter("title");
        // 获取频道编号
        int channelId = Integer.parseInt(req.getParameter("channelId"));
        // 获取文章内容
        String content = req.getParameter("content");

        // 构造文章对象
        Posts post = new Posts();
        post.setAuthorId(user.getId());
        post.setTitle(title);
        post.setChannelId(channelId);
        post.setContent(content);
        post.setCreated(new Date());

        // 添加到数据库中
        postsService.addPost(post);
        resp.sendRedirect("index");
    }

    private void updatePostFavors(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Integer.parseInt(req.getParameter("id"));
        // 获取更新内容
        // 获取文章标题
        String title = req.getParameter("title");
        // 获取频道编号
        int channelId = Integer.parseInt(req.getParameter("channelId"));
        // 获取文章内容
        String content = req.getParameter("content");
        // 通过文章编号获取文章
        Posts post = postsService.getPost(id);
        // 修改文章属性
        post.setContent(content);
        // 提交到数据库中
        postsService.updatePost(post);
        resp.sendRedirect("jsps/default/auth/view.jsp?id=" + post.getId());
    }

    private void updatePostViews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Posts post = new Posts();
        PrintWriter out = resp.getWriter();
        long id = Integer.parseInt(req.getParameter("id"));
        post = postsService.getPost(id);
        int views = post.getViews() + 1;
        post.setViews(views);
        postsService.updatePost(post);
        resp.sendRedirect("jsps/default/auth/view.jsp?id=" + post.getId());
    }

    private void updatePostComments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Posts post = new Posts();
        PrintWriter out = resp.getWriter();
        long id = Integer.parseInt(req.getParameter("id"));
        post = postsService.getPost(id);
        int comments = post.getComments() + 1;
        post.setComments(comments);
        postsService.updatePost(post);
        resp.sendRedirect("jsps/default/auth/view.jsp?id=" + post.getId());
    }

    private void updatePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过文章编号获取文章
        long id = Integer.parseInt(req.getParameter("id"));
        Posts post = postDao.getPost(id);

        // 获取修改后的属性

        // 文章标题
        String title = req.getParameter("title");
        // 文章频道
        int channelId = Integer.parseInt(req.getParameter("channelId"));
        // 文章内容
        String content = req.getParameter("content");

        // 设置到对象中
        post.setTitle(title);
        post.setChannelId(channelId);
        post.setContent(content);
        // 写入到数据库中
        postsService.updatePost(post);
        resp.sendRedirect("ChannelServlet?id=" + post.getChannelId());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        List<Posts> postsList = new ArrayList<Posts>();
        int LIMIT = 5;
        if ("selectAuthorId".equals(op)) {
            PrintWriter out = resp.getWriter();
            long authorId = Integer.parseInt(req.getParameter("authorId"));
            postsList = ps.getPostAuthorId(authorId);
        } else if ("selectAll".equals(op)) {
            postsList = ps.getAllPosts();
        } else if ("selectByTime".equals(op)) {
            postsList = ps.findNewPostsLimit(LIMIT);
        } else if ("selectByFavors".equals(op)) {
            postsList = ps.findNewPostsLimit2(LIMIT);
        } else if ("selectByComments".equals(op)) {
            postsList = ps.findNewPostsLimit3(LIMIT);
        } else if ("toUpdatePostPage".equals(op)) {
            Long id = Long.parseLong(req.getParameter("id"));
            Posts post = postDao.getPost(id);
            req.setAttribute("post", post);
            req.getRequestDispatcher("jsps/default/channel/update.jsp").forward(req, resp);
        } else if ("updatePost".equals(op)) {
            updatePost(req, resp);
        } else if ("updatePostFavors".equals(op)) {
            updatePostFavors(req, resp);
        } else if ("updatePostViews".equals(op)) {
            updatePostViews(req, resp);
        } else if ("updatePostComments".equals(op)) {
            updatePostComments(req, resp);
        } else if ("toAddPostPage".equals(op)) {
            req.getRequestDispatcher("jsps/default/channel/editing.jsp").forward(req, resp);
        } else if ("addPost".equals(op)) {
            // 添加文章
            addPost(req, resp);
        } else if ("getPost".equals(op)) {
            getPost(req, resp);
        } else if ("delPost".equals(op)) {
            long id = Integer.parseInt(req.getParameter("id"));
            postsService.deletePost(id);
            req.getRequestDispatcher("jsps/default/user/method_posts.jsp").forward(req, resp);
        }
        // 根据文章编号查询到文章
        else if ("toPostView".equals(op)) {
            // 获取文章编号
            long postId = Long.parseLong(req.getParameter("postId"));
            // 获取文章实体数据
            Posts post = postsService.getPost(postId);
            post.setViews(post.getViews() + 1);
            req.setAttribute("post", post);
            Long id = post.getAuthorId();
            int comment = commentService.getCount1(id);
            int posts =0;
            postDao.updatePostViews(post);

            // 转发到展示页面
            req.getRequestDispatcher("jsps/default/channel/view.jsp").forward(req, resp);
        }
    }
}
