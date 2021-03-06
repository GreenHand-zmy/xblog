package controller;

import service.Impl.PostsServiceImpl;
import service.Impl.UserServiceImpl;
import service.PostsService;
import service.UserService;
import bean.Post;
import bean.User;
import utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ZH on 2018/5/23.
 */
@WebServlet("/upload")
@MultipartConfig(maxFileSize = 3L * 1024 * 1024)
public class UploadServlet extends HttpServlet {
    UserService userservice = new UserServiceImpl();
    private PostsService postsService = new PostsServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/upload/avatar");
        File paths = new File(path);
        Part part = req.getPart("file");
        String fileName = part.getSubmittedFileName();
        String file = UUIDUtils.getId() + fileName.substring(fileName.indexOf("."), fileName.length());
        User user = (User) req.getSession().getAttribute("user");
        user.setAvatar(file);
        userservice.updateUser(user);
        part.write(paths + "/" + file);
        List<Post> postsList = postsService.getPostAuthorId(user.getId());
        req.setAttribute("postsList", postsList);
        req.getRequestDispatcher("WEB-INF/jsps/default/user/method_posts.jsp").forward(req, resp);
    }
}
