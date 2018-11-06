<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <jsp:include page="../include/header.jsp"/>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <jsp:include page="../include/left.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>修改角色</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br>
                                <#include "/admin/message.ftl">
                                <form id="qForm" class="form-horizontal form-label-left" method="post"
                                      action="update_role">
                                    <input type="hidden" name="id" value="${user.id}"/>

                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">用户名</label>
                                        <div class="col-lg-8">
                                            <input class="form-control" type="text" value="${user.username}" disabled
                                                   style="width:200px;">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">角色</label>
                                        <div class="col-lg-8">
                                            <#--遍历所有角色和用户当前拥有的角色，如果用户当前拥有某个角色，则把checkbox设置为选中-->
                                            <#list roles as role>
                                            <#assign hasRole ="false">
                                            <label class="checkbox-inline">
                                                <#list view.roles as userRole>
                                                <#if userRole.id == role.id>
                                                <#assign hasRole ="true">
                                                <#break>
                                            </#if>
                                        </
                                        #list>
                                        <#if hasRole == "true">
                                        <input type="checkbox" name="roleIds" value="${role.id}"
                                               checked="checked"> ${role.name}
                                        <#else>
                                        <input type="checkbox" name="roleIds" value="${role.id}"> ${role.name}
                                    </
                                    #if>
                                    </label>
                                </
                                #list>

                            </div>
                        </div>

                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                <button type="submit" class="btn btn-success">提交</button>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="../include/footer.jsp"/>
</div>
<!-- Custom Theme Scripts -->
<script src="${ctx}/static/theme/admin/js/custom.min.js"></script>
<script src="${ctx}/static/theme/admin/js/app.data.js"></script>
<script type="text/javascript">
    var J = jQuery;

    $(function () {
    })
</script>
</body>
</html>




