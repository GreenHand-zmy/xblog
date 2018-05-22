<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-default corner-radius panel-hot-topics">
	<div class="panel-heading">
		<h3 class="panel-title"><i class="fa fa-area-chart"></i> 热门文章</h3>
	</div>
	<div class="panel-body">
		<ul class="list" id="hots">
            <img src="${ctx}/static/dist/images/spinner.gif">
		</ul>
	</div>
</div>

<div class="panel panel-default corner-radius panel-hot-topics">
	<div class="panel-heading">
		<h3 class="panel-title"><i class="fa fa-bars"></i> 最新发布</h3>
	</div>
	<div class="panel-body">
		<ul class="list" id="latests">
			<img src="${ctx}/static/dist/images/spinner.gif">
		</ul>
	</div>
</div>

<div class="panel panel-default corner-radius panel-hot-topics">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-users "></i> 热门用户</h3>
    </div>
    <div class="panel-body remove-padding-horizontal">
        <ul class="hotusers" id="hotuser">
            <img src="${ctx}/static/dist/images/spinner.gif">
        </ul>
    </div>
</div>

<script type="text/javascript">

var li_template = '<li>{0}. <a href="${ctx}/view/{1}">{2}</a></li>';

var hotUser_li_template = '<li><a href="{1}"><img src="${ctx}{0}" class="avatar avatar-small"/></a></li>'

seajs.use('sidebox', function (sidebox) {
	sidebox.init({
        latestUrl : '${ctx}/api/latests',
    	hotUrl : '${ctx}/api/hots',
		hotTagUrl : '${ctx}/api/hot_tags',
		hotUserUrl:'${ctx}/api/hotusers',

        size :10,
        // callback
        onLoadHot : function (i, data) {
      		return jQuery.format(li_template, i + 1, data.id, data.title);
        },
        onLoadLatest : function (i, data) {
      		return jQuery.format(li_template, i + 1, data.id, data.title);
        },
        onLoadHotUser : function (i, data) {
        var url = '${ctx}/users/' + data.id;
      		var item = jQuery.format(hotUser_li_template,data.avatar,url,data.name, data.fans);
      		return item;
        }
	});
});
</script>