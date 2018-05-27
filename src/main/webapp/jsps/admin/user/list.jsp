<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <jsp:include page="../include/header.jsp"/>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <jsp:include page="../include/left.jsp"/>

        <div class="right_col" role="main">
            <div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>用户管理</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                            </div>
                        </div>
                        <div class="x_content">
                            <form id="qForm" class="form-inline">
                                <input type="hidden" name="op" value="getUser"/>
                                <div class="form-group">
                                    <input type="text" name="name" class="form-control" value="${key}"
                                           placeholder="请输入关键字">
                                </div>
                                <button type="submit" class="btn btn-default">查询</button>
                            </form>
                        </div>
                        <div class="x_content">
                            <table id="dataGrid" class="table table-striped table-bordered b-t">
                                <thead>
                                <tr>
                                    <th width="80">#</th>
                                    <th>用户名</th>
                                    <th>昵称</th>
                                    <th>状态</th>
                                    <th width="300"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList}" var="user">
                                    <tr>
                                        <td class="text-center">${user.id}</td>
                                        <td>
                                            <a href="${ctx}/UserServlet?op=toOtherUser&antherId=${user.id}">${user.username}</a>
                                        </td>
                                        <td>${user.name}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${user.status == ADMIN_STATUS}">
                                                    <span class="label label-success">管理员</span>
                                                </c:when>
                                                <c:when test="${user.status == NORMAL_STATUS}">
                                                    <span class="label label-success">启用</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="label label-default">禁用</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="text-center">
                                            <c:choose>
                                                <c:when test="${user.status != ADMIN_STATUS}">
                                                    <c:if test="${user.status == NORMAL_STATUS}">
                                                        <a href="${ctx}/PostsServlet?op=delUser&id=${user.id}"
                                                           class="btn btn-xs btn-default" data-id="${user.id}"
                                                           data-action="close">
                                                            <i class="fa fa-close"></i> 关闭
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${user.status == USER_DELETED_STATUS}">
                                                        <a href="javascript:void(0);" class="btn btn-xs btn-success"
                                                           data-id="${user.id}" data-action="open">
                                                            <i class="fa fa-check"></i> 激活
                                                        </a>
                                                    </c:if>
                                                    <a href="${ctx}/PostsServlet?op=toUpUserPwdPage&userId=${user.id}"
                                                       class="btn btn-xs btn-white">
                                                        <i class="fa fa-unlock-alt"></i> 修改密码
                                                    </a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="javascript:void(0);" class="btn btn-xs disabled"><i
                                                            class="fa fa-check-square-o"></i> 不可编辑
                                                    </a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="x_content">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../include/footer.jsp"/>
    </div>
    <!-- Custom Theme Scripts -->
    <script src="${ctx}/static/theme/admin/js/custom.min.js"></script>
    <script src="${ctx}/static/theme/admin/js/app.data.js"></script>
    <script type="text/javascript">

        $(function () {
            // 停用
            $('#dataGrid a[data-action="close"]').bind('click', function () {
                var that = $(this);
                layer.confirm('该账号停用后，将不能登录系统，确定要停用?', {
                    btn: ['确定', '取消'], //按钮
                    shade: false //不显示遮罩
                }, function () {
                    $.post("${ctx}/BgServlet?op=delUser", {id: that.attr('data-id')}, function () {
                        window.location.reload();
                    });
                });
                return false;
            });

            // 激活
            $('#dataGrid a[data-action="open"]').bind('click', function () {
                var that = $(this);
                layer.confirm('该账号激活后，将可访问系统中的已授权功能，确定要激活?', {
                    btn: ['确定', '取消'], //按钮
                    shade: false //不显示遮罩
                }, function () {
                    $.post("${ctx}/BgServlet?op=activeUser", {id: that.attr('data-id')}, function () {
                        window.location.reload();
                    });
                });
                return false;
            });
        })
    </script>
</body>
</html>


