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
                                <h2>文章管理</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <form id="qForm" class="form-inline">
                                    <input type="hidden" name="op" value="getPost"/>
                                    <div class="form-group">
                                        <input type="text" name="title" class="form-control" value="${title}"
                                               placeholder="请输入标题关键字">
                                    </div>
                                    <button type="submit" class="btn btn-default">查询</button>
                                </form>
                            </div>
                            <div class="x_content">
                                <table id="dataGrid" class="table table-striped table-bordered b-t">
                                    <thead>
                                    <tr>
                                        <th width="30"><input type="checkbox" class="checkall"></th>
                                        <th>文章标题</th>
                                        <th width="120">作者</th>
                                        <th width="90">发表日期</th>
                                        <th width="60">访问数</th>
                                        <th width="140"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${postsList}" var="post">
                                        <c:if test="${post.status == NORMAL_STATUS}">
                                            <tr>
                                                <td>
                                                    <input type="checkbox" name="id" value="${post.id}">
                                                </td>
                                                <td>
                                                    <a href="${ctx}/PostsServlet?op=toPostView&postId=${post.id}"
                                                       target="_blank">${post.title}</a>
                                                </td>
                                                <td>
                                                    <a href="${ctx}/UserServlet?op=toOtherUser&antherId=${post.authorId}">${post.authorId}</a>
                                                </td>
                                                <td>${post.created}</td>
                                                <td>${post.views}</td>

                                                <td class="text-center" align="left">
                                                    <a href="${ctx}/PostsServlet?op=toUpPoRootPage&id=${post.id}"
                                                       class="btn btn-xs btn-info">
                                                        <i class="fa fa-edit"></i>
                                                    </a>
                                                    <a href="${ctx}/PostsServlet?op=delPost&id=${post.id}"
                                                       class="btn btn-xs btn-default" data-id="${post.id}"
                                                       rel="delete">
                                                        <i class="fa fa-trash-o"></i>
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
        var J = jQuery;

        function ajaxReload(json) {
            if (json.code >= 0) {
                if (json.message != null && json.message != '') {
                    layer.msg(json.message, {icon: 1});
                }
                $('#qForm').submit();
            } else {
                layer.msg(json.message, {icon: 2});
            }
        }

        $(function () {
            // 删除
            $('#dataGrid a[rel="delete"]').bind('click', function () {
                var that = $(this);
                layer.confirm('确定删除此项吗?', {
                    btn: ['确定', '取消'], //按钮
                    shade: false //不显示遮罩
                }, function () {
                    $.post("${ctx}/PostsServlet?op=delPost", {postId: that.attr('data-id')}, function () {
                        window.location.reload();
                    });

                });
                return false;
            });
        })
    </script>
</body>
</html>


