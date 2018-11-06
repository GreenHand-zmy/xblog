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
        <div class="row users-show streams">
            <div class="col-xs-12 col-md-3 side-left">
                <ul class="list-group about-user">
                    <li class="list-group-item user-card">
                        <div class="ava">
                            <a>
                                <img class="img-circle" src="${ctx}/UserServlet?op=showUserAvatar&authorId=${user.id}" width="70px" height="60px"
                                     style="margin-top: 15px;">
                            </a>
                        </div>
                        <div class="user-info">
                            <div class="nk mb10">${user.name}</div>
                            <br>
                        </div>
                    </li>
                    <li class="list-group-item">
                <span>
                    <c:choose>
                        <c:when test="${user.signature!=null}">
                            ${user.signature}
                        </c:when>
                        <c:otherwise>
                            什么都没留下
                        </c:otherwise>
                    </c:choose>
                </span>
                    </li>
                </ul>
            </div>
            <div class="col-xs-12 col-md-9 side-right">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        他的文章
                    </div>

                    <div class="panel-body">
                        <ul class="list-group">
                            <c:choose>
                                <c:when test="${postList!=null && fn:length(postList) > 0}">
                                    <c:forEach items="${postList}" var="post">
                                        <li class="list-group-item">
                                            <a href="${ctx}/PostsServlet?op=toPostView&postId=${post.id}" class="remove-padding-left">${post.title}</a>
                                            <span class="meta">
                                            ${post.views} 阅读
                                            <span> ⋅ </span>
                                            ${post.comments} 回复
                                            <span> ⋅ </span>
                                            <span class="timeago"><fmt:formatDate value="${post.created}"/></span>
      						            </span>
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
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<%@include file="../include/footer.jsp" %>
</html>