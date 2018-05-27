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

        <!-- page content -->
        <div class="right_col" role="main">
            <div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>栏目管理</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li>
                                        <a href="${ctx}/BgServlet?op=toAddChannelPage">添加栏目</a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <form id="qForm" class="form-inline">
                                    <input type="hidden" name="pn" value="${page.pageNo}"/>
                                </form>
                            </div>
                            <div class="x_content">
                                <table id="dataGrid" class="table table-striped table-bordered b-t">
                                    <thead>
                                    <tr>
                                        <th width="80">#</th>
                                        <th>名称</th>
                                        <th>Key</th>
                                        <th>状态</th>
                                        <th width="200"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${channelList}" var="channel">
                                        <tr>
                                            <td class="text-center">
                                                    ${channel.id}
                                            </td>
                                            <td>
                                                <a href="${ctx}/ChannelServlet?op=toChannelPage&channelId=${channel.id}">
                                                        ${channel.name}
                                                </a>
                                            </td>
                                            <td>${channel.key}</td>
                                            <td>
                                                <c:if test="${channel.status == 0}">
                                                    显示
                                                </c:if>
                                                <c:if test="${channel.status != 0}">
                                                    隐藏
                                                </c:if>
                                            </td>
                                            <td class="text-center">
                                                <a href="${ctx}/PostsServlet?op=toUpChannelPage&channelId=${channel.id}"
                                                   class="btn btn-xs btn-success">
                                                    <i class="fa fa-edit"></i> 修改
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>

                                </table>
                            </div>
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
            // 删除
            $('#dataGrid a[data-action="delete"]').bind('click', function () {
                var that = $(this);

                layer.confirm('确定删除此项吗?', {
                    btn: ['确定', '取消'], //按钮
                    shade: false //不显示遮罩
                }, function () {
                    $.post("${ctx}/BgServlet?op=delChannel", {id: that.attr('data-id')}, function () {
                        window.location.reload();
                    });
                });
                return false;
            });

        })
    </script>
</body>
</html>

