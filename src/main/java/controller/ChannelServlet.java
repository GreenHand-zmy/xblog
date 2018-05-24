package controller;


import Service.Impl.PostsServiceImpl;
import Service.PostsService;
import bean.Post;
import utils.PageBean;

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
public class ChannelServlet extends HttpServlet {
    PostsService postsService = new PostsServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到所选频道的内容并按需求排序
//        long id = Long.parseLong(req.getParameter("id"));
        long id = 1;
        String order = req.getParameter("order");
        String op = req.getParameter("op");

        if ("newest".equals(order)) {
            List<Post> postList = postsService.getChannelPosts(id);
            Collections.sort(postList, new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    return o2.getCreated().compareTo(o1.getCreated());
                }
            });
            req.setAttribute("postList", postList);
            req.setAttribute("id", id);
            req.getRequestDispatcher("jsps/default/channel/index.jsp").forward(req, resp);
        } else if ("favors".equals(order)) {
            List<Post> postList = postsService.getChannelPosts(id);
            Collections.sort(postList, new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    return o2.getFavors() - o1.getFavors();
                }
            });
            req.setAttribute("postList", postList);
            req.setAttribute("id", id);
            req.getRequestDispatcher("jsps/default/channel/index.jsp").forward(req, resp);
        } else if ("hottest".equals(order)) {
            List<Post> postList = postsService.getChannelPosts(id);
            Collections.sort(postList, new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    return o2.getComments() - o1.getComments();
                }
            });
            req.setAttribute("postList", postList);
            req.setAttribute("id", id);
            req.getRequestDispatcher("jsps/default/channel/index.jsp").forward(req, resp);
        } else if ("toPage".equals(op)) {
            int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
            PageBean<Post> pageBean = postsService.findByPage(pageIndex, 10, id);
            req.setAttribute("pageBean", pageBean);
            req.getRequestDispatcher("jsps/default/channel/index.jsp").forward(req, resp);
        } else if ("toChannelPage".equals(op)) {
            // /ChannelServlet?op=toChannelPage&channelId=${channel.id}&orderBy=date
            // 获取频道编号
            long channelId = Long.parseLong(req.getParameter("channelId"));

            // 获取分页对象
            PageBean<Post> pageBean = postsService.findByPage(1, channelId);

            // 根据orderBy字段排序
            String orderBy = req.getParameter("orderBy");
            orderBy(pageBean.getData(), orderBy);

            // 将需要的字段再次转发出去
            req.setAttribute("channelId", channelId);
            req.setAttribute("orderBy", orderBy);
            req.setAttribute("pageBean", pageBean);
            req.setAttribute("totalPages", pageBean.getTotalPages());
            req.getRequestDispatcher("jsps/default/channel/index.jsp").forward(req, resp);
        } else if ("toChannelPageWithPageIndex".equals(op)) {
            // 获取频道编号
            long channelId = Long.parseLong(req.getParameter("channelId"));
            // 获取页码
            int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));

            // 获取分页对象
            PageBean<Post> pageBean = postsService.findByPage(pageIndex, channelId);

            // 根据orderBy字段排序
            String orderBy = req.getParameter("orderBy");
            orderBy(pageBean.getData(), orderBy);

            // 将需要的字段再次转发出去
            req.setAttribute("channelId", channelId);
            req.setAttribute("orderBy", orderBy);
            req.setAttribute("pageBean", pageBean);
            req.getRequestDispatcher("jsps/default/channel/index.jsp").forward(req, resp);
        }
    }

    private void orderBy(List<Post> postList, String order) {
        if ("date".equals(order)) {
            // 根据日期降序排序
            postList.sort((post1, post2) -> post2.getCreated().compareTo(post1.getCreated()));
        } else if ("favors".equals(order)) {
            // 根据喜欢数降序排序
            postList.sort((post1, post2) -> post2.getFavors() - post1.getFavors());
        } else if ("comments".equals(order)) {
            // 根据评论数降序排序
            postList.sort((post1, post2) -> post2.getComments() - post1.getComments());
        }
    }
}
