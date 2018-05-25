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
        <div class="row main">
            <div class="col-xs-12 col-md-9 side-left topics-show">
                <!-- view show -->
                <div class="topic panel panel-default">
                    <div class="infos panel-heading">

                        <h1 class="panel-title topic-title">${post.title}</h1>

                        <div class="meta inline-block">

                            <a class="author" href="${base}/users/${view.author.id}">
                                ${view.author.name}
                            </a>
                            <abbr class="timeago">${0}</abbr>
                            ${post.views} 阅读数

                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="content-body entry-content panel-body ">
                        <div class="markdown-body">
                            ${post.content}
                        </div>
                    </div>
                    <div class="panel-footer operate">
                        本文章不得转载，否则后果自负
                    </div>
                    <div class="panel-footer operate">
                        <div class="hidden-xs">
                            <div class="social-share"
                                 data-sites="weibo, wechat, facebook, twitter, google, qzone, qq"></div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <!-- Comments -->
                <div id="chat" class="chats shadow-box">
                    <div class="chat_other">
                        <h4>全部评论: <i id="chat_count">0</i> 条</h4>
                    </div>
                    <%--评论展示区--%>
                    <ul id="chat_container" class="its">
                        <li id="chat1">
                            <%--用户头像--%>
                            <a class="avt fl" target="_blank" href="/users/2">
                                <img src="/dist/images/ava/default.png">
                            </a>
                            <div class="chat_body">
                                <%--用户姓名--%>
                                <h5>
                                    <div class="fl">
                                        <a class="chat_name" href="/users/2">jiu</a>
                                        <span>2018-05-23</span>
                                    </div>
                                    <div class="clear"></div>
                                </h5>
                                <%--回复内容--%>
                                <div class="chat_p">
                                    <div class="chat_pct">111</div>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </li>
                    </ul>
                    <div id="pager" class="text-center"></div>
                    <div class="cbox-wrap">
                        <div class="cbox-title">我有话说: <span id="chat_reply" style="display:none;">@<i
                                id="chat_to"></i></span>
                        </div>
                        <div class="cbox-post">
                            <div class="cbox-input">
                                <textarea id="chat_text" rows="3" placeholder="请输入评论内容"></textarea>
                                <input type="hidden" value="0" name="chat_pid" id="chat_pid"/>
                            </div>
                            <div class="cbox-ats clearfix">
                                <div class="ats-func">
                                    <ul class="func-list">
                                        <li class="list-b">
                                            <a href="javascript:void(0);" class="join" id="c-btn"><i
                                                    class="fa fa-smile-o fa-2"></i></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="ats-issue">
                                    <button id="btn-chat" class="btn btn-success btn-sm bt">发送</button>
                                </div>
                            </div>
                        </div>
                        <div class="phiz-box" id="c-phiz" style="display:none">
                            <div class="phiz-list" view="c-phizs"></div>
                        </div>
                    </div>
                </div>
                <!-- /view show -->
            </div>
            <div class="col-xs-12 col-md-3 side-right hidden-xs hidden-sm">
                <ul class="list-group about-user">
                    <li class="list-group-item user-card">
                        <div class="ava">
                            <a href="${ctx}/UserServlet?op=toOtherUser&antherId=${post.authorId}">
                                <img class="img-circle"
                                     src="${ctx}/UserServlet?op=showUserAvatar&authorId=${post.authorId}">
                            </a>
                        </div>
                        <div class="user-info">
                            <div class="nk mb10">${user.name}</div>
                            <div class="mb6">
                                <a class="btn btn-default btn-xs" href="javascript:void(0);" data-id="${view.author.id}"
                                   rel="follow"><i class="icon icon-user-follow"></i> 关注</a>
                            </div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="user-datas">
                            <ul>
                                <li><strong>${posts}</strong><span>发布</span></li>
                                <li class="noborder"><strong>${comment}</strong><span>评论</span></li>
                            </ul>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="text-center padding-md">
                            <a class="btn btn-default btn-sm" href="javascript:void(0);" data-id="${view.id}"
                               rel="favor">
                                <i class="icon icon-like"></i> 喜欢
                            </a>
                            <strong id="favors">${view.favors}</strong> 喜欢
                        </div>
                    </li>
                </ul>
                <jsp:include page="../include/right.jsp"/>
            </div>
        </div>

        <%--<script type="text/plain" id="chat_template">
    <li id="chat{5}">
        <a class="avt fl" target="_blank" href="${base}/users/{0}">
            <img src="${base}{1}">
        </a>
        <div class="chat_body">
            <h5>
                <div class="fl"><a class="chat_name" href="${base}/users/{0}">{2}</a><span>{3}</span></div>
                <div class="fr reply_this"><a href="javascript:void(0);" onclick="goto('{5}', '{2}')">[回复]</a></div>
                <div class="clear"></div>
            </h5>
            <div class="chat_p">
                <div class="chat_pct">{4}</div> {6}
            </div>
        </div>
        <div class="clear"></div>
        <div class="chat_reply"></div>
    </li>
</script>--%>

        <%--<script type="text/javascript">
            function goto(pid, user) {
                document.getElementById('chat_text').scrollIntoView();
                $('#chat_text').focus();
                $('#chat_text').val('');
                $('#chat_to').text(user);
                $('#chat_pid').val(pid);

                $('#chat_reply').show();
            }
            var container = $("#chat_container");
            var template = $('#chat_template')[0].text;

            seajs.use('comment', function (comment) {
                comment.init({
                    load_url: '${base}/comment/list/${view.id}',
                    post_url: '${base}/comment/submit',
                    toId: '${view.id}',
                    onLoad: function (i, data) {

                        var content = ContentRender.wrapItem(data.content);

                        var quoto = '';
                        if (data.pid > 0 && !(data.parent === null)) {
                            var pat = data.parent;
                            var pcontent = ContentRender.wrapItem(pat.content);
                            quoto = '<div class="quote"><a href="${base}/users/' + pat.author.id + '">@' + pat.author.name + '</a>: ' + pcontent + '</div>';
                        }
                        var item = jQuery.format(template,
                            data.author.id,
                            data.author.avatar,
                            data.author.name,
                            data.created,
                            content,
                            data.id, quoto);
                        return item;
                    }
                });
            });

            seajs.use(['phiz', 'view'], function (phiz) {
                $("#c-btn").jphiz({
                    base: '${ctx}/static/dist',
                    textId: 'chat_text',
                    lnkBoxId: 'c-lnk',
                    phizBoxId: 'c-phiz'
                });
            });

        </script>--%>
        <script>
            var Authc = {
                isAuthced: function () {
                    return (typeof(window.app.LOGIN_TOKEN) != 'undefined' && window.app.LOGIN_TOKEN.length > 0);
                },
                showLogin: function () {
                    var that = this;
                    $('#login_alert').modal();

                    $('#ajax_login_submit').unbind().click(function () {
                        that.doPostLogin();
                    });
                },
                doPostLogin: function () {
                    var un = $('#ajax_login_username').val();
                    var pw = $('#ajax_login_password').val();
                    jQuery.post(app.base + '/UserServlet?op=ajaxLogin', {
                        'username': un,
                        'password': pw
                    }, function (ret) {
                        console.log(ret);
                        if (ret && ret.code == 0) {
                            window.location.reload();
                        } else {
                            ret = JSON.parse(ret);
                            $('#ajax_login_message').text(ret.message).show();
                        }
                    });
                }
            };
        </script>
        <script>
            $(function () {
                // 给按钮绑定事件
                var btn = $("#btn-chat");
                btn.click(function () {
                    if (!Authc.isAuthced()) {
                        Authc.showLogin();
                    }
                });

                seajs.use(['phiz', 'view'], function (phiz) {
                    $("#c-btn").jphiz({
                        base: '${ctx}/static/dist',
                        textId: 'chat_text',
                        lnkBoxId: 'c-lnk',
                        phizBoxId: 'c-phiz'
                    });
                });
            });
        </script>
    </div>
</div>
<!-- footer -->
<jsp:include page="../include/footer.jsp"/>
</html>