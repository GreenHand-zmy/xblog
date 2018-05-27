package controller;

import utils.JsonUtil;
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
import java.io.PrintWriter;

/**
 * Created by ZH on 2018/5/23.
 */
@WebServlet("/editor/upload")
@MultipartConfig(maxFileSize = 3L * 1024 * 1024)
public class EditorUploadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        String path = this.getServletContext().getRealPath("/upload/editor");
        File paths = new File(path);
        Part part = req.getPart("file");

        // 获取文件名
        String fileName = part.getSubmittedFileName();
        // 重命名文件名
        fileName = UUIDUtils.getId() + fileName.substring(fileName.indexOf("."), fileName.length());
        // 写入到目标位置
        part.write(paths + "/" + fileName);

        UploadResult uploadResult = new UploadResult();
        uploadResult.ok("success");
        uploadResult.setName(fileName);
        uploadResult.setType(getSuffix(fileName));
        uploadResult.setPath("/upload/editor/" + fileName);
        writer.write(JsonUtil.objectToJson(uploadResult));
    }

    protected String getSuffix(String name) {
        int pos = name.lastIndexOf(".");
        return name.substring(pos);
    }

    static class UploadResult {
        public static int OK = 200;
        public static int ERROR = 400;

        /**
         * 上传状态
         */
        private int status;

        /**
         * 提示文字
         */
        private String message;

        /**
         * 文件名
         */
        private String name;

        /**
         * 文件大小
         */
        private long size;

        /**
         * 文件类型
         */
        private String type;

        /**
         * 文件存放路径
         */
        private String path;

        public UploadResult ok(String message) {
            this.status = OK;
            this.message = message;
            return this;
        }

        public UploadResult error(String message) {
            this.status = ERROR;
            this.message = message;
            return this;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

    }
}
