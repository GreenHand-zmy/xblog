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
                                <h2>评论管理</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <form id="qForm" class="form-inline">
                                    <input type="hidden" name="op" value="getComment"/>
                                    <div class="form-group">
                                        <input type="text" name="content" class="form-control" value="${key}"
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
                                        <th>内容</th>
                                        <th>目标文章</th>
                                        <th>作者</th>
                                        <th>发表日期</th>
                                        <th width="200"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${commentList}" var="comment">
                                        <c:if test="${comment.status == NORMAL_STATUS}">
                                            <tr>
                                                <td>${comment.id}</td>
                                                <td class="text-center">${comment.content}</td>
                                                <td>${comment.toId}</td>
                                                <td>${comment.authorId}</td>
                                                <td><fmt:formatDate value="${comment.created}" type="both"/></td>
                                                <td class="text-center" align="left">
                                                    <a href="javascript:void(0);"
                                                       class="btn btn-xs btn-white" data-id="${comment.id}"
                                                       data-action="delete">
                                                        <i class="fa fa-bitbucket"></i> 删除
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:if>
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
                    $.post("${ctx}/BgServlet?op=delComment", {id: that.attr('data-id')}, function () {
                        window.location.reload();
                    });
                });
                return false;
            });
        })
    </script>
</body>
</html>


