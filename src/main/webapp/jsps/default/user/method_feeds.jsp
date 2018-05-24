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
                <%@include file="left.jsp" %>
            </div>
            <div class="col-xs-12 col-md-9 side-right">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        我的文章
                    </div>

                    <div class="panel-body remove-padding-horizontal">
                        <ul class="list-group topic-list">
                            <li class="list-group-item " style="padding: 0 15px;">
                                <a class="reply_count_area hidden-xs pull-right" href="#">
                                    <div class="count_set">
                                        <span class="count_of_votes" title="阅读数">${0}</span>
                                        <span class="count_seperator">/</span>
                                        <span class="count_of_replies" title="回复数">${0}</span>
                                        <span class="count_seperator">/</span>
                                        <span class="count_of_visits" title="点赞数">${0}</span>
                                        <span class="count_seperator">|</span>
                                        <abbr class="timeago">${0}</abbr>
                                    </div>
                                </a>
                                <div class="avatar pull-left">
                                    <%--&lt;%&ndash;<a href="${base}/users/${target.author.id}">&ndash;%&gt;--%>
                                        <%--<img class="media-object img-thumbnail avatar avatar-middle"--%>
                                             <%--&lt;%&ndash;src="${base + target.author.avatar}">&ndash;%&gt;--%>
                                    <%--</a>--%>
                                </div>
                                <div class="infos">
                                    <div class="media-heading">
                                        <%--<@classify target/><a href="${base}/view/${target.id}">${target.title}</a>--%>
                                    </div>
                                </div>
                            </li>


                            <li class="list-group-item ">
                                <div class="infos">
                                    <div>该目录下还没有内容!</div>
                                </div>
                            </li>
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
</html>