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
                                <h2>修改栏目</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br>
                                <form id="qForm" class="form-horizontal form-label-left" method="post"
                                      action="${ctx}/BgServlet?op=addChannel">
                                    <c:if test="${channel != null}">
                                        <input type="hidden" name="id" value="${channel.id}"/>
                                    </c:if>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">名称：</label>
                                        <div class="col-lg-4">
                                            <input type="text" name="name" class="form-control" value="${channel.name}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">唯一标识：</label>
                                        <div class="col-lg-4">
                                            <input type="text" name="key" class="form-control" value="${channel.key}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">导航栏状态：</label>
                                        <div class="col-lg-4">
                                            <select name="status" class="form-control" data-select="${channel.status}">
                                                <option value="0">显示</option>
                                                <option value="1">隐藏</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                            <button type="submit" class="btn btn-success">提交</button>
                                        </div>
                                    </div>
                                </form>
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

        $(function () {
        })
    </script>
</body>
</html>

