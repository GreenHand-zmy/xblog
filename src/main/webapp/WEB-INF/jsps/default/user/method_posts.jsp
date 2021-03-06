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
        <div class="row users-show">
            <div class="col-xs-12 col-md-3 side-left">
                <%@include file="left.jsp" %>
            </div>
            <div class="col-xs-12 col-md-9 side-right">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        我的文章
                    </div>
                    <div class="panel-body">
                        <ul class="list-group">
                            <c:choose>
                                <c:when test="${postList!=null && fn:length(postList) > 0}">
                                    <c:forEach items="${postList}" var="post">
                                        <c:if test="${post.status == NORMAL_STATUS}">
                                            <li class="list-group-item">
                                                <a href="${ctx}/PostsServlet?op=toPostView&postId=${post.id}"
                                                   class="remove-padding-left">${post.title}</a>
                                                <span class="meta">
                                                ${post.comments} 回复
                                                <span> ⋅ </span>
                                                    ${post.views} 阅读数
								                <span class="timeago"><fmt:formatDate value="${post.created}"/></span>
      						                </span>

                                                <div class="pull-right hidden-xs">
                                                    <a class="act_edit" href="javascript:void(0);" data-evt="edit"
                                                       data-id="${post.id}"
                                                       data-toggle="tooltip" title="编辑文章">
                                                        <i class="icon icon-note"></i>
                                                    </a>
                                                    <a class="act_delete" href="javascript:void(0);" data-evt="trash"
                                                       data-id="${post.id}"
                                                       data-toggle="tooltip" title="删除文章">
                                                        <i class="icon icon-close"></i>
                                                    </a>
                                                </div>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <li class="list-group-item ">
                                        <div class="infos">
                                            <div class="media-heading">该目录下还没有内容!</div>
                                        </div>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                    <div class="panel-footer">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<%@include file="../include/footer.jsp" %>

<script type="text/javascript">
    $(function () {
        // delete
        $('a[data-evt=trash]').click(function () {
            var id = $(this).attr('data-id');

            layer.confirm('确定删除此项吗?', {
                btn: ['确定', '取消'], //按钮
                shade: false //不显示遮罩
            }, function () {
                $.post("${ctx}/PostsServlet?op=delPost", {postId: id}, function () {
                    window.location.reload();
                });
            });
        });

        // edit
        $('a[data-evt=edit]').click(function () {
            var id = $(this).attr('data-id');
            window.location.href = '${ctx}/PostsServlet?op=toUpdatePostPage&id=' + id;
        });
    })
</script>
</html>