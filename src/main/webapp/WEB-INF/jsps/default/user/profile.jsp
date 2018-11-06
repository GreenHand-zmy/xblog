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
                    <li class="active"><a href="${ctx}/UserServlet?op=toUpdate">基本信息</a></li>
                    <li><a href="${ctx}/UserServlet?op=toUpdateAvatar">修改头像</a></li>
                    <li><a href="${ctx}/UserServlet?op=toUpdatePassword">修改密码</a></li>
                </ul>
            </div>
            <div class="panel-body">
                <div id="message">
                </div>
                <div class="tab-pane active" id="profile">
                    <form id="pf" action="${ctx}/UserServlet?op=update&id=${sessionScope.user.id}" method="post" class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="nickname">昵称</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" name="name" value="${sessionScope.user.name}" maxlength="7" data-required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="nickname">个性签名</label>
                            <div class="col-lg-6">
                                <textarea name="signature" class="form-control" rows="3" maxlength="128">${sessionScope.user.signature}</textarea>
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
                $('#pf').validate({
                    onKeyup : true,
                    onChange : true,
                    eachValidField : function() {
                        $(this).closest('div').removeClass('has-error').addClass('has-success');
                    },
                    eachInvalidField : function() {
                        $(this).closest('div').removeClass('has-success').addClass('has-error');
                    }
                });
            });
        </script>
    </div>
</div>
<!-- footer -->
<jsp:include page="../include/footer.jsp"/>
</html>