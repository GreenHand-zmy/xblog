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
<!-- content -->
<div class="wrap">
    <!-- Main -->
    <div class="container">
        <div class="col-xs-12 col-md-8">
            <div id="message"></div>
            <form class="form-horizontal" action="${ctx}/PostsServlet?op=addPost" method="post">
                <input type="hidden" name="authorId" value="${sessionScope.user.id}"/>
                <div class="form-group">
                    <input type="text" class="form-control" name="title" maxlength="128" data-required value="${title}"
                           placeholder="请输入标题">
                </div>
                <div class="form-group">
                    <select class="form-control" name="channelId" data-required>
                        <option value="">请选择栏目</option>
                        <c:forEach items="${sessionScope.channelList}" var="channel">
                            <option value="${channel.id}">${channel.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <%@include file="editor/ueditor.jsp" %>
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
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default corner-radius help-box">
                <div class="panel-heading text-center">
                    <h3 class="panel-title">构建高品质的社区</h3>
                </div>
                <div class="panel-body">
                    <ul class="list">
                        <li>请传播美好的事物，这里拒绝低俗、诋毁、谩骂等相关信息</li>
                        <li>请尽量分享技术相关的话题，谢绝发布社会, 政治等相关新闻</li>
                        <li>这里绝对不讨论任何有关盗版软件、音乐、电影如何获得的问题</li>
                    </ul>
                </div>
            </div>

            <div class="panel panel-default corner-radius help-box">
                <div class="panel-heading text-center">
                    <h3 class="panel-title">在高质量优秀社区的我们</h3>
                </div>
                <div class="panel-body">
                    <ul class="list">
                        <li>分享生活见闻, 分享知识</li>
                        <li>接触新技术, 讨论技术解决方案</li>
                        <li>为自己的创业项目找合伙人, 遇见志同道合的人</li>
                        <li>自发线下聚会, 加强社交</li>
                        <li>发现更好工作机会</li>
                        <li>甚至是开始另一个神奇的开源项目</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<%@include file="../include/footer.jsp" %>
<script type="text/javascript">
    seajs.use('post', function (post) {
        post.init();
    });
</script>
</html>