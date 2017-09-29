<%--
  Created by IntelliJ IDEA.
  User: tg
  Date: 17-9-26
  Time: 上午8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!Doctype html>
<head>
    <title>加盟${addressType}</title>
    <jsp:include page="/WEB-INF/jsp/common/webnavigation.jsp" flush="true" />
</head>
<body>
</body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="breadcrumb">
                <li>
                    <a href="/clxj/index">首页</a>
                </li>
                <li class="active">
                    加盟${addressType}
                </li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-6 column">
            <form role="form" action="/clxj/league" method="post">
                <div class="form-group">
                    <label for="name">${addressType}名
                        <span id="loginTips" class="glyphicon"><label class="label label-danger">${error}</label></span>
                    </label><input type="text" class="form-control" id="name" name="name" />
                </div>
                <div class="form-group">
                    <label for="siteType">地址类型</label>
                    <select class="form-control" id="siteType" name="siteType">
                        <option value="国内">国内</option>
                        <option value="国外">国外</option>
                    </select>
                </div>
                <input type="hidden" name="addressType" value="${addressType}" />
                <div class="form-group">
                    <label for="address">地址</label><input type="text" class="form-control" id="address" name="address" />
                </div>
                <div class="form-group">
                    <label for="price">价格</label><input type="number" class="form-control" id="price" name="price" />
                </div>
                <input type="hidden" name="type" value="${type}">
                <div class="form-group">
                    <label for="thicketAdmin.name">姓名</label><input type="text" class="form-control" id="thicketAdmin.name" name="thicketAdmin.name" />
                </div>
                <div class="form-group">
                    <label for="thicketAdmin.phone">联系手机</label><input type="text" class="form-control" id="thicketAdmin.phone" name="thicketAdmin.phone" />
                </div>
                <div class="form-group">
                    <label for="thicketAdmin.password">密码</label><input type="text" class="form-control" id="thicketAdmin.password" name="thicketAdmin.password" />
                </div>
                <div class="form-group">
                    <label for="thicketAdmin.password1">确认密码</label><input type="text" class="form-control" id="thicketAdmin.password1" />
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</html>
