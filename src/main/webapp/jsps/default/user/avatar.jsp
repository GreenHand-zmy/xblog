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
                    <li class="active"><a href="${ctx}/UserServlet?op=toUpdateAvatar">修改头像</a></li>
                    <li><a href="${ctx}/UserServlet?op=toUpdatePassword">修改密码</a></li>
                </ul>
            </div>
            <div class="panel-body">
                <div id="message">

                </div>
                <form class="form-horizontal" enctype="multipart/form-data" action="${ctx}/upload" method="post">
                    <input type="hidden" id="x" name="x" value=""/>
                    <input type="hidden" id="y" name="y" value=""/>
                    <input type="hidden" id="width" name="width" value=""/>
                    <input type="hidden" id="height" name="height" value=""/>
                    <input type="hidden" id="path" name="path" value=""/>

                    <div class="upload-btn">
                        <label>
                            <span>点击选择一张图片</span>
                            <input id="upload_btn" type="file" name="file" accept="image/*" title="点击添加图片">
                        </label>
                    </div>
                    <div class="update_ava">
                        <img src="${ctx}/UserServlet?op=showUserAvatar&authorId=${sessionScope.user.id}" id="target"
                             alt="[Example]" width="180" height="180"/>
                    </div>

                    <div class="form-group">
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <script type="text/javascript">
            seajs.use('avatar');
        </script>
    </div>
</div>
<!-- footer -->
<jsp:include page="../include/footer.jsp"/>
</html>