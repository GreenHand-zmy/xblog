<%--
  Created by IntelliJ IDEA.
  User: zmy
  Date: 2018/5/27
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="${ctx}/index" class="site_title"><span>XBlog</span></a>
        </div>

        <div class="clearfix"></div>

        <br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>系统菜单</h3>
                <ul class="nav side-menu">
                    <li>
                        <a href="${ctx}/BgServlet?op=index">
                            <i class="fa fa-home"></i> Home
                        </a>
                    </li>
                    <li><a href="${ctx}/BgServlet?op=posts"><i class="fa fa-home"></i> 文章管理</a></li>
                    <li><a href="${ctx}/BgServlet?op=user"><i class="fa fa-home"></i> 用户管理</a></li>
                    <li><a href="${ctx}/BgServlet?op=comment"><i class="fa fa-home"></i> 评论管理</a></li>
                    <li><a href="${ctx}/BgServlet?op=channel"><i class="fa fa-home"></i> 栏目管理</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                       aria-expanded="false">
                        <img src="${ctx}/UserServlet?op=showUserAvatar&authorId=${sessionScope.user.id}" alt="">${sessionScope.user.name}
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="${ctx}/UserServlet?op=logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>
