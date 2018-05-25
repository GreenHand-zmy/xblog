/*
 +--------------------------------------------------------------------------
 |   Mblog [#RELEASE_VERSION#]
 |   ========================================
 |   Copyright (c) 2014, 2015 mtons. All Rights Reserved
 |   http://www.mtons.com
 |
 +---------------------------------------------------------------------------
 */

define(function(require, exports, module) {
    J = jQuery;

    var Authc = {
        isAuthced: function () {
            return (typeof(window.app.LOGIN_TOKEN) != 'undefined' && window.app.LOGIN_TOKEN.length > 0);
        },
        showLogin : function () {
            var that = this;
            $('#login_alert').modal();

            $('#ajax_login_submit').unbind().click(function () {
                that.doPostLogin();
            });
        },
        doPostLogin: function () {
            var un = $('#ajax_login_username').val();
            var pw = $('#ajax_login_password').val();
            jQuery.post(app.base + '/UserServlet?op=ajaxLogin', {'username': un, 'password': pw}, function (ret) {
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

    module.exports = Authc;
});