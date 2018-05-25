<%--<#include "/admin/utils/ui.ftl"/>
<@layout>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsps/admin/utils/ui.jsp"/>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>用户管理</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
            </div>
        </div>
        <div class="x_content">
            <form id="qForm" class="form-inline">
                <input type="hidden" name="op" value="getUser"/>
                <div class="form-group">
                    <input type="text" name="name" class="form-control" value="${key}" placeholder="请输入关键字">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>
        <div class="x_content">
            <table id="dataGrid" class="table table-striped table-bordered b-t">
                <thead>
                <tr>
                    <th width="80">#</th>
                    <th>用户名</th>
                    <th>昵称</th>
                    <th>邮箱</th>
                    <th>角色</th>
                    <th>状态</th>
                    <th width="300"></th>
                </tr>
                </thead>
                <tbody>
                <#list page.content as row>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td class="text-center">${user.id}</td>
                            <td>
                                <a href="${ctx}/UserServlet?op=toOtherUser&antherId=${user.id}">${user.username}</a>
                            </td>
                            <td>${user.name}</td>
                            <td>${user.mobile}</td>
                            <td>
                                <#list row.roles as role>
                                        ${user.name}
                                </#list>
                            </td>
                            <td>
                                <#if (user.status == 0)>
                                    <span class="label label-success">启用</span>
                                    <#else>
                                        <span class="label label-default">禁用</span>
                                </#if>
                            </td>
                            <td class="text-center">
                                <#if user.id != 1>
                                    <#if user.status == 0>
                                        <a href="${ctx}/PostsServlet?op=delUser&id=${user.id}"
                                           class="btn btn-xs btn-default" data-id="${user.id}"
                                           data-action="close">
                                            <i class="fa fa-close"></i> 关闭
                                        </a>
                                        <#else>
                                            <a href="javascript:void(0);" class="btn btn-xs btn-success""
                                            data-id="${user.id}" data-action="open">
                                            <i class="fa fa-check"></i> 激活
                                            </a>
                                    </#if>
                                    <a href="${ctx}/PostsServlet?op=toUpUserPwdPage&userId=${user.id}"
                                       class="btn btn-xs btn-white">
                                        <i class="fa fa-unlock-alt"></i> 修改密码
                                    </a>

                                    <a href="${ctx}/PostsServlet?op=toUpUserRootPage&userId=${1}"
                                       class="btn btn-xs btn-primary">
                                        <i class="fa fa-check-square-o"></i> 修改角色
                                    </a>
                                    <#else>
                                        <a href="javascript:void(0);" class="btn btn-xs disabled"><i
                                                class="fa fa-check-square-o"></i> 不可编辑</a>
                                </#if>
                            </td>
                        </tr>
                    </c:forEach>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="x_content">
            <@pager "list" page 5 />
        </div>
    </div>
</div>

<script type="text/javascript">
    var J = jQuery;

    function ajaxReload(json) {
        if (json.code >= 0) {
            if (json.message != null && json.message != '') {
                layer.msg(json.message, {icon: 1});
            }
            $('#qForm').submit();
        } else {
            layer.msg(json.message, {icon: 2});
        }
    }

    $(function () {
        // 停用
        $('#dataGrid a[data-action="close"]').bind('click', function () {
            var that = $(this);
            layer.confirm('该账号停用后，将不能登录系统，确定要停用?', {
                btn: ['确定', '取消'], //按钮
                shade: false //不显示遮罩
            }, function () {
                J.getJSON('${base}/admin/user/close', {id: that.attr('data-id'), active: false}, ajaxReload);
            }, function () {
            });
            return false;
        });

        // 激活
        $('#dataGrid a[data-action="open"]').bind('click', function () {
            var that = $(this);
            layer.confirm('该账号激活后，将可访问系统中的已授权功能，确定要激活?', {
                btn: ['确定', '取消'], //按钮
                shade: false //不显示遮罩
            }, function () {
                J.getJSON('${base}/admin/user/open', {id: that.attr('data-id'), active: true}, ajaxReload);
            }, function () {
            });
            return false;
        });
    })
</script>
<%--
</@layout>--%>
