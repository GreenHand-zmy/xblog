<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'/>

    <%@include file="../include/include.jsp" %>
</head>
<!-- header -->
<%@include file="../include/header.jsp" %>
<div class="wrap">
    <!-- Main -->
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4 floating-box">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">请登录</h3>
                    </div>
                    <div class="panel-body">
                        <form method="POST" action="${ctx}/UserServlet?op=login" accept-charset="UTF-8">
                            <div class="form-group ">
                                <label class="control-label" for="username">账号</label>
                                <input class="form-control" name="username" type="text" required>
                            </div>
                            <div class="form-group ">
                                <label class="control-label" for="password">密码</label>
                                <input class="form-control" name="password" type="password" required>
                            </div>
                            <div class="form-group ">
                                <label>
                                    <input type="checkbox" name="rememberMe" value="1"> 记住登录？
                                </label>
                            </div>
                            <button type="submit" class="btn btn-success btn-block">
                                登录 Use it
                            </button>

                            <hr>

                            <fieldset class="form-group">
                                <div class="alert alert-info">
                                    使用以下方法注册或者登录（<a class="forget-password" href="#">忘记密码？</a>）
                                </div>
                                <a class="btn btn-default btn-block" href="#">
                                    <i class="fa fa-weibo"></i> 微博帐号登录
                                </a>
                                <a class="btn btn-default btn-block" href="#">
                                    <i class="fa fa-qq"></i> QQ帐号登录
                                </a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<%@include file="../include/footer.jsp" %>
</html>

