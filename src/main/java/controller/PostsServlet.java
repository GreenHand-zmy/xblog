package controller;

import bean.vo.PostVo;
import dao.ChannelDao;
import dao.Impl.ChannelDaoImpl;
import dao.Impl.PostDaoImpl;
import dao.Impl.UserDaoImpl;
import dao.PostDao;
import dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;
import service.ChannelService;
import service.CommentService;
import service.Impl.ChannelServiceImpl;
import service.Impl.CommentServiceImpl;
import service.Impl.PostsServiceImpl;
import service.Impl.UserServiceImpl;
import service.PostsService;
import service.UserService;
import bean.Channel;
import bean.Post;
import bean.User;
import utils.JsonUtil;
import utils.ResultBean;
import bean.vo.CommentVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
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
    private UserService userService = new UserServiceImpl();
    private PostDao postDao = new PostDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private ChannelDao channelDao = new ChannelDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        /*List<Post> postList = new ArrayList<Post>();
        int LIMIT = 5;*/
        /*if ("selectAuthorId".equals(op)) {
            PrintWriter out = resp.getWriter();
            long authorId = Integer.parseInt(req.getParameter("authorId"));
            postList = ps.getPostAuthorId(authorId);
        } else if ("selectAll".equals(op)) {
            postList = ps.getAllPosts();
        } else if ("selectByTime".equals(op)) {
            postList = ps.findNewPostsLimit(LIMIT);
        } else if ("selectByFavors".equals(op)) {
            postList = ps.findNewPostsLimit2(LIMIT);
        } else if ("selectByComments".equals(op)) {
            postList = ps.findNewPostsLimit3(LIMIT);
        }*/
        if ("toUpdatePostPage".equals(op)) {
            Long id = Long.parseLong(req.getParameter("id"));
            Post post = postDao.getPost(id);
            req.setAttribute("post", post);
            req.getRequestDispatcher("WEB-INF/jsps/default/channel/update.jsp").forward(req, resp);
        } else if ("updatePost".equals(op)) {
            updatePost(req, resp);
        } else if ("updatePostFavors".equals(op)) {
            updatePostFavors(req, resp);
        } else if ("updatePostViews".equals(op)) {
            updatePostViews(req, resp);
        } else if ("updatePostComments".equals(op)) {
            updatePostComments(req, resp);
        } else if ("toAddPostPage".equals(op)) {
            req.getRequestDispatcher("WEB-INF/jsps/default/channel/editing.jsp").forward(req, resp);
        } else if ("addPost".equals(op)) {
            // 添加文章
            addPost(req, resp);
        } else if ("getPost".equals(op)) {
            getPost(req, resp);
        } else if ("ajaxGetNewPosts".equals(op)) {
            // ajax获取最新的文章
            getNewPosts(req, resp);
        } else if ("ajaxGetHostPosts".equals(op)) {
            getHostPosts(req, resp);
        } else if ("delPost".equals(op)) {
            long postId = Integer.parseInt(req.getParameter("postId"));
            postsService.deletePost(postId);
        }
        // 根据文章编号查询到文章
        else if ("toPostView".equals(op)) {
            toPostView(req, resp);
        }
        // 后台修改文章
        else if ("toUpPoRootPage".equals(op)) {
            // 通过文章编号获取文章
            long id = Integer.parseInt(req.getParameter("id"));
            Post post = postDao.getPost(id);
            req.setAttribute("post", post);
            req.getRequestDispatcher("WEB-INF/jsps/admin/post/update.jsp").forward(req, resp);
        } else if ("toUpUserRootPage".equals(op)) {
            // 通过作者编号获取文章，改角色
            long id = Integer.parseInt(req.getParameter("userId"));
            User user = userDao.getUser(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("WEB-INF/jsps/admin/user/view.jsp").forward(req, resp);
        } else if ("toUpUserPwdPage".equals(op)) {
            // 通过作者编号获取文章，改密码
            long id = Integer.parseInt(req.getParameter("userId"));
            User user = userDao.getUser(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("WEB-INF/jsps/admin/user/pwd.jsp").forward(req, resp);
        } else if ("toUpChannelPage".equals(op)) {
            // 通过栏目编号获取文章
            long id = Integer.parseInt(req.getParameter("channelId"));
            Channel channel = channelDao.findById(id);
            req.setAttribute("channel", channel);
            req.getRequestDispatcher("WEB-INF/jsps/admin/channel/view.jsp").forward(req, resp);
        }
    }

    private void getPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Post post = new Post();
        PrintWriter out = resp.getWriter();
        long id = Integer.parseInt(req.getParameter("id"));
        post = postsService.getPost(id);
        resp.sendRedirect("WEB-INF/jsps/default/auth/view.jsp");
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
        Post post = new Post();
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
        Post post = postsService.getPost(id);
        // 修改文章属性
        post.setContent(content);
        // 提交到数据库中
        postsService.updatePost(post);
        resp.sendRedirect("WEB-INF/jsps/default/auth/view.jsp?id=" + post.getId());
    }

    private void updatePostViews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Post post = new Post();
        PrintWriter out = resp.getWriter();
        long id = Integer.parseInt(req.getParameter("id"));
        post = postsService.getPost(id);
        int views = post.getViews() + 1;
        post.setViews(views);
        postsService.updatePost(post);
        resp.sendRedirect("WEB-INF/jsps/default/auth/view.jsp?id=" + post.getId());
    }

    private void updatePostComments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Post post = new Post();
        PrintWriter out = resp.getWriter();
        long id = Integer.parseInt(req.getParameter("id"));
        post = postsService.getPost(id);
        int comments = post.getComments() + 1;
        post.setComments(comments);
        postsService.updatePost(post);
        resp.sendRedirect("WEB-INF/jsps/default/auth/view.jsp?id=" + post.getId());
    }

    private void updatePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过文章编号获取文章
        long id = Integer.parseInt(req.getParameter("id"));
        Post post = postDao.getPost(id);

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
        resp.sendRedirect("UserServlet?op=toMyArticle");
    }

    private void toPostView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取文章编号
        long postId = Long.parseLong(req.getParameter("postId"));

        // 获取文章实体数据
        Post post = postsService.getPost(postId);

        // 将文章阅读数+1,并写入数据库
        post.setViews(post.getViews() + 1);
        postDao.updatePostViews(post);

        // 将文章实体放入请求中
        req.setAttribute("post", post);

        // 获取文章作者编号
        Long id = post.getAuthorId();
        // 获取文章作者实体
        User user = userService.getUser(id);
        req.setAttribute("user", user);

        // 获取文章作者总发布数
        int postedNumber = postsService.countByAuthorId(id);
        req.setAttribute("postedNumber", postedNumber);

        // 获取文章作者总评论数
        int commentNumber = commentService.getCount1(id);
        req.setAttribute("commentNumber", commentNumber);


        // 获取到该文章的所有评论
        List<CommentVo> commentVoList = commentService.getCommentVoByPostId(postId);
        // 将评论按照时间升序排序
        commentVoList.sort(Comparator.comparing(commentVo -> commentVo.getComment().getCreated()));
        req.setAttribute("commentVoList", commentVoList);

        // 转发到展示页面
        req.getRequestDispatcher("WEB-INF/jsps/default/channel/view.jsp").forward(req, resp);
    }

    private void getHostPosts(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = null;
        try {
            int limit = Integer.parseInt(req.getParameter("limit"));
            List<Post> postList = postsService.findNewPostsLimit3(limit);
            List<PostVo> postVoList = new ArrayList<>();
            // 构造为vo
            for (Post post : postList) {
                PostVo postVo = new PostVo();
                BeanUtils.copyProperties(postVo, post);
                postVoList.add(postVo);
            }
            resp.setContentType("application/json;charset=utf-8");
            writer = resp.getWriter();
            writer.write(JsonUtil.objectToJson(new ResultBean<>().success(postVoList)));
        } catch (RuntimeException e) {
            writer.write(JsonUtil.objectToJson(new ResultBean<>().fail(e.getMessage())));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void getNewPosts(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = null;
        try {
            int limit = Integer.parseInt(req.getParameter("limit"));
            List<Post> postList = postsService.findNewPostsLimit(limit);
            List<PostVo> postVoList = new ArrayList<>();

            // 构造为vo
            for (Post post : postList) {
                PostVo postVo = new PostVo();
                BeanUtils.copyProperties(postVo, post);
                postVoList.add(postVo);
            }
            resp.setContentType("application/json;charset=utf-8");
            writer = resp.getWriter();
            writer.write(JsonUtil.objectToJson(new ResultBean<>().success(postVoList)));
        } catch (RuntimeException e) {
            writer.write(JsonUtil.objectToJson(new ResultBean<>().fail(e.getMessage())));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
