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
                                <c:when test="${postsList!=null}">
                                    <c:forEach items="${postsList}" var="posts">
                                        <li class="list-group-item" el="loop-${0}">
                                            <a href="${base}/view/${0}" class="remove-padding-left">${posts.title}</a>
                                            <span class="meta">
								${posts.favors} 点赞
								<span> ⋅ </span>
                                ${posts.comments} 回复
								<span> ⋅ </span>
								<span class="timeago">${0}</span>
      						</span>

                                            <div class="pull-right hidden-xs">
                                                <a class="act_edit" href="javascript:void(0);" data-evt="edit"
                                                   data-id="${posts.id}"
                                                   data-toggle="tooltip" title="编辑文章">
                                                    <i class="icon icon-note"></i>
                                                </a>
                                                <a class="act_delete" href="javascript:void(0);" data-evt="trash"
                                                   data-id="${posts.id}"
                                                   data-toggle="tooltip" title="删除文章">
                                                    <i class="icon icon-close"></i>
                                                </a>
                                            </div>
                                        </li>
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
                jQuery.getJSON('${ctx}/PostsServlet?op=delPost&id=' + id, function (ret) {
                    layer.msg(ret.message, {icon: 1});
                    if (ret.code >= 0) {
                        location.reload();
                    }
                });

            }, function () {

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