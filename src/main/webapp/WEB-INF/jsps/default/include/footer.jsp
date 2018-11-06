<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer class="footer">
    <div class="container">
        <div class="footer-col footer-col-logo hidden-xs hidden-sm">
            <img src="${ctx}/static/theme/default/images/logo1.png" alt="XBlog" width="150" height="42"/>
        </div>
        <div class="footer-col footer-col-copy">
            <ul class="footer-nav hidden-xs">
                <li class="menu-item"><a href="${ctx}/about">关于我们</a></li>
                <li class="menu-item"><a href="${ctx}/joinus">联系我们</a></li>
                <li class="menu-item"><a href="${ctx}/faqs">常见问题</a></li>
                <li>
                    <script>
                        var _hmt = _hmt || [];
                        (function() {
                            var hm = document.createElement("script");
                            hm.src = "//hm.baidu.com/hm.js?a029e6c6dddf427f4cbfb2b00d7d5311";
                            var s = document.getElementsByTagName("script")[0];
                            s.parentNode.insertBefore(hm, s);
                        })();
                    </script>
                </li>
            </ul>
            <div class="copyright">
				<span>Copyright © XBlog</span>
			</div>
        </div>
        <div class="footer-col footer-col-sns hidden-xs hidden-sm">
            <div class="footer-sns">
                <span>Powered By <a href="#" target="_blank">XBlog</a></span>
            </div>
        </div>
    </div>
</footer>

<a href="#" class="site-scroll-top"></a>

<script type="text/javascript">
    seajs.use('main', function (main) {
        main.init();
    });
</script>