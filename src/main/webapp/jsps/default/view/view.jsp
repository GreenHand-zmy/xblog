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
                            <a href="#">
                                <%--<@showAva user.avatar "img-circle"/>--%>
                            </a>
                        </div>
                        <div class="user-info">
                            <div class="nk mb10">小豆丁</div>
                            <div class="mb6">
                                <a class="btn btn-success btn-xs" href="javascript:void(0);" data-id=""
                                   rel="follow">+ 关注</a>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                <span>
                    <%--<#if user.signature?? && (user.signature?length > 0) >
                    ${user.signature}
                    <#else>
                        什么都没留下
                    </#if>--%>
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
                            <%--<#list results.content as row>--%>
                            <li class="list-group-item">
                                <a href="#" class="remove-padding-left"></a>
                                <span class="meta">
								${0} 点赞
								<span> ⋅ </span>
                                ${0} 回复
								<span> ⋅ </span>
								<span class="timeago">${0}</span>
      						</span>
                            </li>
                            <%--</#list>--%>

                            <%--<#if results.content?size == 0>--%>
                            <li class="list-group-item ">
                                <div class="infos">
                                    <div class="media-heading">该目录下还没有内容!</div>
                                </div>
                            </li>
                            <%--</#if>--%>
                        </ul>
                    </div>
                    <div class="panel-footer">
                        <%--<@pager request.requestURI!"", results, 5/>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<%@include file="../include/footer.jsp" %>
</html>