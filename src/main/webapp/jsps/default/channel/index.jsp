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
        <div class="row streams">
            <div class="col-xs-12 col-md-9 side-left">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <ul class="list-inline topic-filter">
                            <li data-toggle="tooltip" title="发布时间排序">
                                <a href="${ctx}/ChannelServlet?op=toChannelPage&channelId=${channelId}&orderBy=created">最近</a>
                            </li>
                            <li data-toggle="tooltip" title="阅读数排序">
                                <a href="${ctx}/ChannelServlet?op=toChannelPage&channelId=${channelId}&orderBy=views">阅读</a>
                            </li>
                            <li data-toggle="tooltip" title="评论次数排序">
                                <a href="${ctx}/ChannelServlet?op=toChannelPage&channelId=${channelId}&orderBy=comments">热门</a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>

                    <div class="panel-body remove-padding-horizontal">

                        <ul class="list-group row topic-list">
                            <c:choose>
                                <c:when test="${pageBean.data != null && fn:length(pageBean.data) > 0}">
                                    <c:forEach var="post" items="${pageBean.data}">
                                        <li class="list-group-item ">
                                            <a class="reply_count_area hidden-xs pull-right" href="#">
                                                <div class="count_set">
                                            <span class="count_of_votes" data-toggle="tooltip"
                                                  title="阅读数">${post.views}</span>
                                                    <span class="count_seperator">/</span>
                                                    <span class="count_of_replies" data-toggle="tooltip"
                                                          title="回复数">${post.comments}</span>
                                                    <span class="count_seperator">|</span>
                                                    <abbr class="timeago"><fmt:formatDate value="${post.created}"/></abbr>
                                                </div>
                                            </a>
                                            <div class="avatar pull-left">
                                                <a href="${ctx}/UserServlet?op=toOtherUser&antherId=${post.authorId}">
                                                    <img class="img-circle"
                                                         src="${ctx}/UserServlet?op=showUserAvatar&authorId=${post.authorId}"
                                                         width="36px" height="36px">
                                                </a>
                                            </div>
                                            <div class="infos">
                                                <div class="media-heading">
                                                    <a href="${ctx}/PostsServlet?op=toPostView&postId=${post.id}">${post.title}</a>
                                                </div>
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

                    <div class="panel-footer text-right remove-padding-horizontal pager-footer">
                        <!-- Pager -->
                        <ul class="pagination">
                            <%-- 如果有上一页则显示可用的按钮,否则显示不可用的按钮--%>
                            <c:choose>
                                <c:when test="${pageBean.havePrePage}">
                                    <li>
                                        <a href="${ctx}/ChannelServlet?op=toChannelPageWithPageIndex&channelId=${channelId}&orderBy=${orderBy}&pageIndex=${pageBean.pageIndex - 1}"
                                           pageNo="${0}" class="prev">上一页</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="disabled"><span>上一页</span></li>
                                </c:otherwise>
                            </c:choose>

                            <%--打印页码--%>
                            <c:forEach var="i" begin="1" step="1" end="${totalPages}">

                                <li <c:if test="${i == pageBean.pageIndex}">class="active"</c:if>>
                                    <a href="${ctx}/ChannelServlet?op=toChannelPageWithPageIndex&channelId=${channelId}&orderBy=${orderBy}&pageIndex=${i}">${i}</a>
                                </li>
                            </c:forEach>

                            <%-- 如果有下一页则显示可用的按钮,否则显示不可用的按钮--%>
                            <c:choose>
                                <c:when test="${pageBean.haveNextPage}">
                                    <li>
                                        <a href="${ctx}/ChannelServlet?op=toChannelPageWithPageIndex&channelId=${channelId}&orderBy=${orderBy}&pageIndex=${pageBean.pageIndex + 1}"
                                           pageNo="${0}" class="next">下一页</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="disabled"><span>下一页</span></li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </div>

            </div>

            <div class="col-xs-12 col-md-3 side-right">
                <jsp:include page="../include/right.jsp"/>
            </div>

        </div>
    </div>
</div>
<!-- footer -->
<jsp:include page="../include/footer.jsp"/>
</html>
