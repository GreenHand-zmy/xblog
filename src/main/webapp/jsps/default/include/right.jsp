<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-default corner-radius panel-hot-topics">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-area-chart"></i> 热门文章</h3>
    </div>
    <div class="panel-body">
        <ul class="list" id="hots">
        </ul>
    </div>
</div>

<div class="panel panel-default corner-radius panel-hot-topics">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-bars"></i> 最新发布</h3>
    </div>
    <div class="panel-body">
        <ul class="list" id="latests">
        </ul>
    </div>
</div>

<div class="panel panel-default corner-radius panel-hot-topics">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-users "></i> 热门用户</h3>
    </div>
    <div class="panel-body remove-padding-horizontal">
        <ul class="hotusers" id="hotuser">
        </ul>
    </div>
</div>

<script>
    // 加载热门文章
    function loadHotPosts() {
        // url = http://localhost:8080/PostsServlet?op=ajaxGetNewPosts&limit=10
        var hotPostsContainer = $("#hots");
        $.ajax({
            url: "${ctx}/PostsServlet?op=ajaxGetHostPosts",
            method: "POST",
            data: {limit: ${hotPostLimit}},
            success: function (ret) {
                if (ret.code == 0) {
                    $.each(ret.data, function (i, hotPost) {
                        var hotPostLi = $('<li>' + (i + 1) + '. <a href="${ctx}/PostsServlet?op=toPostView&postId=' + hotPost.id + '">' + hotPost.title + '</a></li>');
                        hotPostsContainer.append(hotPostLi);
                    });
                }
            }
        });
    }

    // 加载最新的文章
    function loadLatestPosts() {
        // url = http://localhost:8080/PostsServlet?op=ajaxGetNewPosts&limit=10
        var latestsContainer = $("#latests");
        $.ajax({
            url: "${ctx}/PostsServlet?op=ajaxGetNewPosts",
            method: "POST",
            data: {limit: ${lastedPostLimit}},
            success: function (ret) {
                if (ret.code == 0) {
                    $.each(ret.data, function (i, lastedPost) {
                        var hotPostLi = $('<li>' + (i + 1) + '. <a href="${ctx}/PostsServlet?op=toPostView&postId=' + lastedPost.id + '">' + lastedPost.title + '</a></li>');
                        latestsContainer.append(hotPostLi);
                    });
                }
            }
        });
    }

    // 加载热门用户
    function loadHotUser() {
        var hotUserContainer = $("#hotuser");
        $.ajax({
            url: "${ctx}/UserServlet?op=ajaxGetHotUser",
            method: "POST",
            data: {limit: ${hotUserLimit}},
            success: function (ret) {
                if (ret.code == 0) {
                    $.each(ret.data, function (i, hotUser) {
                        var hotUserLi = $('<li><a href="${ctx}/UserServlet?op=toOtherUser&antherId=' + hotUser.id + '"><img src="${ctx}/UserServlet?op=showUserAvatar&authorId=' + hotUser.id + '" class="avatar avatar-small"></a></li>');
                        hotUserContainer.append(hotUserLi);
                    });
                }
            }
        });
    }

    $(function () {
        loadHotPosts();
        loadLatestPosts();
        loadHotUser();
    })
</script>