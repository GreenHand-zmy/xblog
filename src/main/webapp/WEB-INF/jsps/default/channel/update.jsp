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
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="icon icon-pencil"></i> 编辑文章
            </div>
            <div class="panel-body">
                <div id="message"></div>
                <form class="form-horizontal" action="${ctx}/PostsServlet?op=updatePost&id=${post.id}" method="post">
                    <%--<input type="hidden" name="id" value="${view.id}"/>--%>
                    <%--<input type="hidden" name="authorId" value="${view.authorId}"/>--%>
                        <input type="hidden" name="authorId" value="${post.featured}"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right">标题</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="title" maxlength="128" data-required
                                   value="${post.title}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right">发布到</label>
                        <div class="col-sm-3">
                            <select class="form-control" name="channelId">
                                <c:forEach items="${sessionScope.channelList}" var="channel">
                                    <c:choose>
                                        <c:when test="${channel.id == post.channelId}">
                                            <option value="${channel.id}" selected="selected">${channel.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${channel.id}">${channel.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="desc" class="col-sm-2 control-label no-padding-right">内容</label>
                        <div class="col-sm-8">
                            <jsp:include page="editor/ueditor.jsp"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </div>
                    </div>
                </form>
                <!-- /form-actions -->
            </div>
        </div>
        <script type="text/javascript">
            seajs.use('post', function (post) {
                post.init();
            });
        </script>
    </div>
</div>
<!-- footer -->
<jsp:include page="../include/footer.jsp"/>
</html>
