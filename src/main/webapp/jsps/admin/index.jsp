<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <jsp:include page="include/header.jsp"/>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <jsp:include page="include/left.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div>
                <div class="page-title">
                    <div class="title_left">
                        <h3>${sessionScope.user.username}
                            <small> 欢迎使用XBlog</small>
                        </h3>
                    </div>
                </div>
                <div class="clearfix">
                </div>
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>系统状态</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content" style="height: 231px;">
                                <table class="table table-bordered">
                                    <tr>
                                        <td>内存消耗:</td>
                                        <td>
                                            ${64.42}M / ${189}M
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width:120px;">操作系统:</td>
                                        <td>${"Windows 10"}</td>
                                    </tr>
                                    <tr>
                                        <td style="width:120px;">JDK版本:</td>
                                        <td>${"1.8.0_144"}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>内存使用情况</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <canvas id="canvas"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp"/>

<!-- Custom Theme Scripts -->
<script src="${ctx}/static/theme/admin/js/custom.min.js"></script>
<script src="${ctx}/static/theme/admin/js/app.data.js"></script>
<script type='text/javascript' src='${ctx}/static/dist/vendors/Chart.js/dist/Chart.min.js'></script>
<script>
    $(function () {
        var ctx = document.getElementById("canvas");
        var data = {
            labels: [
                "可用",
                "已用"
            ],
            datasets: [{
                data: [${59}, 100 - ${59}],
                backgroundColor: [
                    "#455C73",
                    "#9B59B6"
                ],
                hoverBackgroundColor: [
                    "#34495E",
                    "#B370CF"
                ]
            }]
        };

        var canvasDoughnut = new Chart(ctx, {
            type: 'doughnut',
            tooltipFillColor: "rgba(51, 51, 51, 0.55)",
            data: data
        });
    })
</script>
</body>
</html>














