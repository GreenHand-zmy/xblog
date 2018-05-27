<%--<#-- layout -->
<#macro layout>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>XBlog - 后台管理</title>

    <!-- Bootstrap -->
    <link href="${ctx}/static/dist/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${ctx}/static/dist/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${ctx}/static/theme/admin/css/custom.min.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="${ctx}/static/dist/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${ctx}/static/dist/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script src='${ctx}/static/dist/vendors/validate/jquery-validate.js'></script>
    <!-- FastClick -->
    <script src="${ctx}/static/dist/vendors/fastclick/lib/fastclick.js"></script>

    <script src="${ctx}/static/dist/vendors/layer/layer.js"></script>

    <script type="text/javascript">
        window.UEDITOR_HOME_URL = '${ctx}/static/dist/vendors/ueditor/';
    </script>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
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
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div>
                <#nested/>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Mblog - Powered By <a href="http://mtons.com/?copyright" target="_blank">Mtons</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
    <!-- Custom Theme Scripts -->
    <script src="${ctx}/static/theme/admin/js/custom.min.js"></script>
    <script src="${ctx}/static/theme/admin/js/app.data.js"></script>
</body>
</html>
