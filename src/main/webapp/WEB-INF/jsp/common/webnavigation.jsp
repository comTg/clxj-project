<%--
  Created by IntelliJ IDEA.
  User: tg
  Date: 17-9-26
  Time: 下午2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!Doctype html>
<head>
    <link href="/resources/css/index.css" rel="stylesheet"/>
    <%@include file="head.jsp" %>
    <%@include file="tag.jsp" %>

</head>
<body>
    <!-- 导航栏 -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/clxj/index">丛林闲居</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/clxj/index">首页</a></li>
                    <li><a href="/clxj/cl/list">丛林</a></li>
                    <li><a href="/clxj/xj/list">闲居</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">我的订单 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">所有订单</a></li>
                            <li><a href="#">丛林订单</a></li>
                            <li><a href="#">闲居订单</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">加盟 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/clxj/cl/add">加盟丛林</a></li>
                            <li><a href="/clxj/xj/add">加盟闲居</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right hidden" id="per-center">
                    <li><a href="#">个人中心</a></li>
                    <li>
                        <%--<button id="logout" type="button" class="btn btn-link" >退出</button>--%>
                        <a id="logout" type="button" href="" onclick="clxj.logout()">退出</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right" id="need-login">
                    <li><a href="/clxj/register">注册</a></li>
                    <li><a href="/clxj/login">登录</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <form class="navbar-form navbar-right">
                        <input type="text" class="form-control" placeholder="搜索丛林或闲居">
                    </form>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>
</body>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery.cookie.min.js"></script>
<script src="/resources/js/clxj.js"></script>
<script type="text/javascript">
    $(function () {
        // 判断是否登录
        clxj.judge_login();
    })
</script>
</html>
