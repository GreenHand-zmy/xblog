package filter;

import bean.User;
import constant.UserStatusConstant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/*"})
public class Filter2_AccessControllerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        User user = (User) req.getSession().getAttribute("user");

        // 如果此用户被禁止登陆,则不允许他进行其他操作
        if (user != null && UserStatusConstant.DELETED_STATUS.equals(user.getStatus())) {
            // 销毁Session
            req.getSession().invalidate();
            // 提示用户
            resp.getWriter().write("<script>alert('您已经被禁止登陆该网站,请联系管理员');history.go('index');</script>");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
