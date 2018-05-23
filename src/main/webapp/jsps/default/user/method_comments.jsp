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
                                <c:when test="${commentsList!=null}">
                                    <c:forEach items="${commentsList}" var="comments">
                            <li class="list-group-item">
                                <a href="" class="remove-padding-left">${comments.content}</a>
                                <a href="javascript:;" class="remove-padding-left">文章已删除</a>
                            <span class="meta">
								<span class="timeago">${0}</span>
      						</span>

                            <div class="pull-right hidden-xs">
                                <a class="act" href="javascript:void(0);" data-evt="trash" data-id="${row.id}"
                                   data-toggle="tooltip" title="删除评论">
                                    <i class="icon icon-close"></i>
                                </a>
                            </div>

                            <div class="reply-body markdown-reply content-body">
                                <p>${row.content}</p>
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
                jQuery.getJSON('${base}/comment/delete', {'id': id}, function (ret) {
                    layer.msg(ret.message, {icon: 1});
                    if (ret.code >= 0) {
                        var el = $('li[el=loop-' + id + ']');
                        el.next().remove();
                        el.next().remove();
                        el.remove();
                    }
                });

            }, function () {

            });
        });
    })
</script>
</html>