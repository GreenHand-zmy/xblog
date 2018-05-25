<%--<#include "/admin/utils/ui.ftl"/>
<@layout>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsps/admin/utils/ui.jsp"/>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>修改栏目</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
				<#include "/admin/message.ftl">
                <form id="qForm" class="form-horizontal form-label-left" method="post" action="${ctx}/BgServlet?op=updateChannel&id=${channel.id}">
                    <#if view??>
                    <input type="hidden" name="id" value="${channel.id}" />
                    </#if>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">名称：</label>
                        <div class="col-lg-4">
                            <input type="text" name="name" class="form-control" value="${channel.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">唯一标识：</label>
                        <div class="col-lg-4">
                            <input type="text" name="key" class="form-control" value="${channel.key}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">导航栏状态：</label>
                        <div class="col-lg-4">
                            <select name="status" class="form-control" data-select="${channel.status}">
                                <option value="0">显示</option>
                                <option value="1">隐藏</option>
                            </select>
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

<script type="text/javascript">
var J = jQuery;

$(function() {
})
</script>
<%--
</@layout>--%>
