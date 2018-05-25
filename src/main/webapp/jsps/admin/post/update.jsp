<%--<#include "/admin/utils/ui.ftl"/>
<@layout>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/jsps/admin/utils/ui.jsp"/>
<link rel='stylesheet' media='all' href='${base}/dist/css/plugins.css'/>
<script type="text/javascript" src="${base}/dist/js/plugins.js"></script>

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>文章编辑</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br>
				<#include "/admin/message.ftl">
                <form id="qForm" class="form-horizontal form-label-left" method="post" action="${ctx}/BgServlet?op=updatePost&id=${post.id}">
                    <input type="hidden" name="type" value="${view.type}"/>
                    <input type="hidden" name="id" value="${view.id}"/>
                    <input type="hidden" name="author.id" value="${view.author.id}"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right">标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="title" value="${post.title}" maxlength="64" data-required >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label no-padding-right">发布到</label>
                        <div class="col-sm-3">
                            <select class="form-control" name="channelId">
                                <c:forEach items="${sessionScope.channelList}" var="channel">
                                    <c:choose>
                                        <c:when test="${channel.id == post.channelId}">
                                            <option value="${channel.id}" selected="selected">${channel.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${channel.id}">${channel.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="desc" class="col-sm-2 control-label no-padding-right">内容:</label>
                        <div class="col-sm-10">
							<#include "/admin/editor/ueditor.ftl"/>
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
$(function() {
	$('#tags').tagit({
		singleField: true,
		singleFieldNode: $('#fieldTags')
	});

	$('form').validate({
		onKeyup : true,
		onChange : true,
		eachValidField : function() {
			$(this).closest('div').removeClass('has-error').addClass('has-success');
		},
		eachInvalidField : function() {
			$(this).closest('div').removeClass('has-success').addClass('has-error');
		},
		conditional : {
			content : function() {
				return $(this).val().trim().length > 0;
			}
		},
		description : {
			content : {
				required : '<div class="alert alert-danger"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span></button>写点内容吧</div>'
			}
		}
	});
});
</script>
<%--</@layout>--%>
