<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
    <title>忘记密码</title>
    <jsp:include page="/WEB-INF/jsp/common/webnavigation.jsp" flush="true" />
</head>
<body>
</body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-3 column">

        </div>
        <div class="col-md-4 column">
            <form role="form" action="/clxj/alterPasswd" method="post">
                <div class="form-group row">
                    <div class="col-lg-12">
                        <label for="phone">输入手机号码</label>
                        <span id="loginTips" class="glyphicon">${error}</span>
                        <input type="text" name="phone" class="form-control" id="phone" onblur="clxj.is_exists_phone()" />
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-4">
                        <label for="validatecode">输入验证码</label><input type="text" name="validatecode" class="form-control" id="validatecode" />
                    </div>
                </div>
                <button type="submit" class="btn btn-default" id="btnSubmit">确认</button>
            </form>
        </div>
        <div class="col-md-5 column">
            <button class="btn btn-default btn-info" style="position:absolute;top:25px;" id="btnvalidate" onclick="clxj.getcode()">获得验证码</button>
        </div>
    </div>
</div>
<script src="/resources/js/jquery.countdown.min.js"></script>
<script type="text/javascript">
    $(function () {

    })
</script>
</html>