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
                        我的评论
                    </div>

                    <div class="panel-body">
                        <ul class="list-group">
                            <c:choose>
                                <c:when test="${postCommentVoList!=null && fn:length(postCommentVoList) > 0}">
                                    <c:forEach items="${postCommentVoList}" var="postComment">
                                        <li class="list-group-item">
                                        <c:choose>
                                            <c:when test="${postComment.post.status == NORMAL_STATUS}">
                                                <a href="${ctx}/PostsServlet?op=toPostView&postId=${postComment.post.id}"
                                                   class="remove-padding-left">${postComment.post.title}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="javascript:;" class="remove-padding-left">文章已删除</a>
                                            </c:otherwise>
                                        </c:choose>

                                        <span class="meta">
								            <span class="timeago"><fmt:formatDate
                                                    value="${postComment.post.created}"/></span>
                                        </span>

                                        <div class="pull-right hidden-xs">
                                            <a class="act" href="javascript:void(0);" data-evt="trash"
                                               data-id="${postComment.comment.id}"
                                               data-toggle="tooltip" title="删除评论">
                                                <i class="icon icon-close"></i>
                                            </a>
                                        </div>

                                        <div class="reply-body markdown-reply content-body">
                                            <p>${postComment.comment.content}</p>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    </li>
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
        $('a[data-evt=trash]').click(function () {
            var id = $(this).attr('data-id');

            layer.confirm('确定删除此项吗?', {
                btn: ['确定', '取消'], //按钮
                shade: false //不显示遮罩
            }, function () {
                $.post("${ctx}/CommentServlet?op=deleteComment", {commentId: id}, function () {
                    window.location.reload();
                });
            });
        });
    })
</script>
</html>