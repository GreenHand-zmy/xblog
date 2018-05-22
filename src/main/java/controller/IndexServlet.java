package controller;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//设置编码格式与MIME类型
        resp.setContentType("text/html; charset=UTF-8");

        //首页新闻列表路径
        String indexPath = req.getServletContext().getRealPath("/index.html");

        //文件是否存在
        File file = new File(indexPath);
        if (!file.exists()) {
            //如果新闻列表不存在，生成新闻列表

            //创建一个freemarker.template.Configuration实例，它是存储 FreeMarker 应用级设置的核心部分
            //指定版本号
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
            //获得模板文件路径
            String templatePath = this.getClass().getClassLoader().getResource("/templates").getPath();
            //设置模板目录
            cfg.setDirectoryForTemplateLoading(new File(templatePath));
            //设置默认编码格式
            cfg.setDefaultEncoding("UTF-8");


            //从设置的目录中获得模板
            Template template = cfg.getTemplate("default/index.jsp");

            //合并模板和数据模型
        }
        //如果新闻单页下存在，生成新闻单页
        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
