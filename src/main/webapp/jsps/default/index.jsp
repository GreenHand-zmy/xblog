<%@ page import="bean.Posts" %>
<%@ page import="Dao.PostDao" %>
<%@ page import="Dao.Impl.PostDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'/>

    <jsp:include page="include/include.jsp"/>
</head>
<!-- header -->
<jsp:include page="include/header.jsp"/>
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
                                <a href="?order=newest" class="active">最近</a>
                            </li>
                            <li data-toggle="tooltip" title="点赞数排序">
                                <a href="?order=favors"
                                   class="active">投票</a>
                            </li>
                            <li data-toggle="tooltip" title="评论次数排序">
                                <a href="?order=hottest" class="active">热门</a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>

                    <div class="panel-body remove-padding-horizontal">

                        <ul class="list-group row topic-list">
                            <c:forEach items="${postsList}" var="post">
                                <li class="list-group-item ">
                                    <a class="reply_count_area hidden-xs pull-right" href="#">
                                        <div class="count_set">
                                            <span class="count_of_votes" data-toggle="tooltip"
                                                  title="阅读数">${post.views}</span>
                                            <span class="count_seperator">/</span>
                                            <span class="count_of_replies" data-toggle="tooltip"
                                                  title="回复数">${post.comments}</span>
                                            <span class="count_seperator">/</span>
                                            <span class="count_of_visits" data-toggle="tooltip"
                                                  title="点赞数">${post.favors}</span>
                                            <span class="count_seperator">|</span>
                                            <abbr class="timeago">${0}</abbr>
                                        </div>
                                    </a>
                                    <div class="avatar pull-left">
                                        <a href="${base}/users/${row.author.id}">
                                            <img class="media-object img-thumbnail avatar avatar-middle"
                                                 src="${base + row.author.avatar}">
                                        </a>
                                    </div>
                                    <div class="infos">
                                        <div class="media-heading">
                                               <a href="${ctx}/PostsServlet?op=toPostView&postId=${post.id}"> ${post.title}</a>
                                                <%--<@classify row/><a href="${base}/view/${row.id}">${row.title}</a>--%>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                            <c:if test="${postsList == null}">
                                <li class="list-group-item ">
                                    <div class="infos">
                                        <div class="media-heading">该目录下还没有内容!

                                        </div>
                                    </div>
                                </li>
                            </c:if>
                        </ul>
                    </div>

                    <div class="panel-footer text-right remove-padding-horizontal pager-footer">
                        <!-- Pager -->
                        <%--<@pager request.requestURI!"", results, 5/>--%>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-3 side-right">
                <jsp:include page="include/right.jsp"/>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<jsp:include page="include/footer.jsp"/>
</html>