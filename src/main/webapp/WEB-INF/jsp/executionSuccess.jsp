<%--
  Created by IntelliJ IDEA.
  User: tg
  Date: 17-9-27
  Time: 下午11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
    <title>登录成功</title>
    <jsp:include page="common/webnavigation.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                ${tips},<a href="${url}">正在跳转</a>
            </h3>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h2 class="text-danger text-center">
                    <%--显示time图标--%>
                    <span class="glyphicon glyphicon-time"></span>
                    <%--展示倒计时--%>
                    <span class="glyphicon" id="time-box"></span>
                </h2>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/resources/js/jquery.countdown.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var phone = ${user.phone};
        var jump_url = "${url}";
        console.log(phone);
        clxj.login_success(phone,jump_url);
    });
//    $(function () {
//        // 获取手机号码
//
//    })
</script>
</html>
