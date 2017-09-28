<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
    <title>修改密码</title>
    <jsp:include page="/WEB-INF/jsp/common/webnavigation.jsp" flush="true" />
</head>
<body>
</body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-2 column">
                    <img alt="140x140" src="/resources/images/avatar-anzu.jpg" style="width:140px;height:140px"/>
                </div>
                <div class="col-md-6 column">
                    <form role="form">
                        <div class="form-group">
                            <label for="exampleInputEmail1">手机号码</label><input type="text" class="form-control" id="exampleInputEmail1" name="phone" value="<%=request.getAttribute("phone")%>" />
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">密码</label><input type="password" class="form-control" name="password" id="inputPassword" />
                        </div>
                        <div class="form-group">
                            <label for="valiPassword">确认密码</label><input type="password" class="form-control" id="valiPassword" />
                        </div>
                        <button type="submit" class="btn btn-default">确认</button>
                    </form>
                </div>
                <div class="col-md-4 column">
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    
</script>

</html>