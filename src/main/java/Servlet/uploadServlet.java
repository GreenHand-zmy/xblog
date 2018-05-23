package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Created by ZH on 2018/5/23.
 */
@WebServlet("/upload")
@MultipartConfig
public class uploadServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=this.getServletContext().getRealPath("/upload");
        File paths= new File(path);
        Part part = req.getPart("file");
        String fileName = part.getSubmittedFileName();
        part.write(paths+fileName);
    }
}
