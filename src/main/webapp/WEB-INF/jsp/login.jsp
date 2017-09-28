<%--
  Created by IntelliJ IDEA.
  User: tg
  Date: 17-9-26
  Time: 下午3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
    <title>登录</title>
    <jsp:include page="common/webnavigation.jsp" flush="true"/>
    <link href="/resources/css/register.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="signin-page center-block">
        <form class="pull-right" action="/clxj/loginUser" method="post">
            <h3>
                Sign in
            </h3>
            <p class="slogan">
                Quick Start
                <%--验证信息--%>
                <span id="loginTips" class="glyphicon">${error}</span>
            </p>
            <div class="input-prepend">
                <span class="glyphicon glyphicon-user"></span>
                <input type="text" placeholder="手机号码" name="phone" id="phone" onblur="clxj.is_exists_phone()">
            </div>
            <br>
            <div class="input-prepend">
                <span class="glyphicon glyphicon-lock"></span>
                <input type="password" placeholder="******" name="password" id="password">
            </div>
            <br>
            <span id="control-group">
              <label>
                <input type="checkbox" value="option1">
                Remember Me |
              </label>
              <a href="/clxj/forgetpasswd">Forgot Password?</a>
            </span>
            <br>
            <%--<input type="submit" class="btn btn-danger btn-lg btn-block" id="loginSubmit" value="登录">--%>
            
            <button class="btn btn-lg btn-danger btn-block" id="loginSubmit">
                <span>登陆</span>
            </button>
        </form>
    </div>

</div>
</body>
<script type="text/javascript">
    $(function () {
       // 开启表单验证
        var node = $('#loginTips');
        clxj.interceptform(node);
    })
</script>
</html>
