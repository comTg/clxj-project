<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>后台管理系统</title>
    <%@include file="../common/head.jsp"%>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="/resources/css/dashboard.css" rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">丛林闲居</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">用户管理</a></li>
                <li><a href="#">设置</a></li>
                <li><a href="#">详情</a></li>
                <li><a href="#">关于</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">注册用户管理 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">后台用户管理</a></li>
                <li><a href="#">丛林审核</a></li>
                <li><a href="#">闲居审核</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">丛林加盟管理</a></li>
                <li><a href="">闲居加盟管理</a></li>
                <li><a href="">广告管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">丛林订单查询</a></li>
                <li><a href="">闲居订单查询</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">用户管理</h1>
            <h2 class="sub-header">注册用户</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>姓名</th>
                        <th>密码</th>
                        <th>手机</th>
                        <th>邮件</th>
                        <th>真实姓名</th>
                        <th>性别</th>
                        <th>证件号码</th>
                        <th>注册时间</th>
                        <th>是否启用</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>sit</td>
                        <td>sit</td>
                        <td>sit</td>
                        <td>sit</td>
                        <td><button class="btn btn-default btn-sm">是</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="/resources/js/holder.min.js"></script>
</body>
</html>

