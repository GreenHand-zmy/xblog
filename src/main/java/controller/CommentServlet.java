package controller;

import Service.CommentService;
import Service.Impl.CommentServiceImpl;
import bean.Comment;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
    private CommentService commentService = new CommentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if ("addComment".equals(op)) {
            addComment(req, resp);
        } else if ("deleteComment".equals(op)) {
            deleteComment(req, resp);
        }
    }

    private void deleteComment(HttpServletRequest req, HttpServletResponse resp) {
        long commentId = Long.parseLong(req.getParameter("commentId"));
        commentService.delComment(commentId);
    }

    private void addComment(HttpServletRequest req, HttpServletResponse resp) {
        // 获取当前评论用户
        User user = (User) req.getSession().getAttribute("user");

        // 获取评论参数

        // 评论内容
        String content = req.getParameter("content");
        // 评论了哪篇文章
        long toId = Long.parseLong(req.getParameter("toId"));

        // 构造评论对象
        Comment comment = new Comment();
        comment.setAuthorId(user.getId());
        comment.setContent(content);
        comment.setToId(toId);
        comment.setCreated(new Date());
        // 调用服务添加到数据库中
        commentService.addComment(comment);
    }
}
