<%--
  Created by IntelliJ IDEA.
  User: tg
  Date: 17-9-26
  Time: 下午3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
    <title>注册页面</title>
    <jsp:include page="common/webnavigation.jsp" flush="true"/>
    <link href="/resources/css/register.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="navbar-USF">
        <div class="dropdown">
            <a href="/">
                <span class="glyphicon glyphicon-home"></span>
            </a>
            <a href="/">
                <span class="glyphicon glyphicon-th"></span>
            </a>
        </div>
    </div>
            <form action="/clxj/registerUser" method="post">
                <h3>
                    Sign up with Phone
                </h3>
                <p class="slogan">
                    Join us, start working
                    <span id="loginTips" class="glyphicon">${error}</span>
                </p>
                <div class="input-prepend">
                    <span class="glyphicon glyphicon-user"></span>
                    <input type="text" placeholder="用户名" name="name">
                </div>
                <div class="input-prepend">
                    <span class="glyphicon glyphicon-earphone"></span>
                    <input type="text" placeholder="手机号码" id="phone" name="phone" onblur="clxj.is_exists_phone()">
                </div>
                <br>
                <br>
                <div class="input-prepend">
                    <span class="glyphicon glyphicon-envelope"></span>
                    <input type="text" placeholder="Email" name="email">
                </div>
                <br>
                <div class="input-prepend">
                    <span class="glyphicon glyphicon-lock"></span>
                    <input type="password" placeholder="输入密码" name="password">
                </div>
                <br>
                <div class="input-prepend">
                    <span class="glyphicon glyphicon-lock"></span>
                    <input type="password" placeholder="确认密码">
                </div>
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit" id="btnSubmit">
                    <span>注册</span>
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
