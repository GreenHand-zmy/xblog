package filter;

import service.ChannelService;
import service.Impl.ChannelServiceImpl;
import bean.Channel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class Filter1_InitFilter implements Filter {
    private ChannelService channelService = new ChannelServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 将频道列表存入会话中
        List<Channel> channelList = channelService.findAll();
        req.getSession().setAttribute("channelList", channelList);

        // 放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
