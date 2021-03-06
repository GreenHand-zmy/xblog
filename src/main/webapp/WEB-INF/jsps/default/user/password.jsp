<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'/>

    <jsp:include page="../include/include.jsp"/>
</head>
<!-- header -->
<jsp:include page="../include/header.jsp"/>
<!-- content -->
<div class="wrap">
    <!-- Main -->
    <div class="container">
        <div class="panel panel-default stacked">
            <div class="panel-heading">
                <ul class="nav nav-pills account-tab">
                    <li><a href="${ctx}/UserServlet?op=toUpdate">基本信息</a></li>
                    <li><a href="${ctx}/UserServlet?op=toUpdateAvatar">修改头像</a></li>
                    <li class="active"><a href="${ctx}/UserServlet?op=toUpdatePassword">修改密码</a></li>
                </ul>
            </div>
            <div class="panel-body">
                <div id="message">
                </div>
                <div class="tab-pane active" id="passwd">
                    <form id="pw" action="${ctx}/UserServlet?op=update&id=${sessionScope.user.id}" method="post" class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="password">当前密码</label>
                            <div class="col-lg-4">
                                <input type="password" class="form-control" name="oldPassword" maxlength="18"
                                       placeholder="请输入当前密码" data-required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="password">新密码</label>
                            <div class="col-lg-4">
                                <input type="password" class="form-control" id="password" name="password"
                                       placeholder="请输入新密码" maxlength="18" data-required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="password2">确认密码</label>
                            <div class="col-lg-4">
                                <input type="password" class="form-control" name="password2" data-required
                                       placeholder="请再输入一遍新密码" maxlength="18" data-conditional="confirm"
                                       data-describedby="message" data-description="passwd">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </div><!-- /form-actions -->
                    </form>
                </div>
            </div><!-- /panel-content -->
        </div><!-- /panel -->

        <script type="text/javascript">
            $(function () {
                $('#pw').validate({
                    onKeyup: true,
                    onChange: true,
                    eachValidField: function () {
                        $(this).closest('div').removeClass('has-error').addClass('has-success');
                    },
                    eachInvalidField: function () {
                        $(this).closest('div').removeClass('has-success').addClass('has-error');
                    },
                    conditional: {
                        confirm: function () {
                            return $(this).val() == $('#password').val();
                        }
                    },
                    description: {
                        passwd: {
                            conditional: '<div class="alert alert-danger">两次输入的密码不一致</div>'
                        }
                    }
                });
            });
        </script>
    </div>
</div>
<!-- footer -->
<jsp:include page="../include/footer.jsp"/>
</html>