<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tg
  Date: 17-9-26
  Time: 下午8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
    <title>首页</title>
    <jsp:include page="common/webnavigation.jsp" flush="true" />
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="breadcrumb">
                <li>
                    <span class="glyphicon glyphicon-arrow-right"></span>
                </li>
                <li class="active">
                    <a href="/clxj/cl/list">丛林</a>
                </li>
            </ul>
            <div class="row">
                <c:forEach items="${cl_list}" var="thicket">
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <img alt="300x200" src="/resources/images/test.jpg" />
                            <div class="caption">
                                <h3>
                                    ${thicket.name}
                                </h3>
                                <p>
                                    ${thicket.address}
                                </p>
                                <p>
                                    <button class="btn btn-primary">${thicket.price}元</button> <a class="btn" href="#">查看详情</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="breadcrumb">
                <li>
                    <span class="glyphicon glyphicon-arrow-right"></span>
                </li>
                <li class="active">
                    <a href="/clxj/xj/list">闲居</a>
                </li>
            </ul>
            <div class="row">
                <c:forEach items="${xj_list}" var="thicket">
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <img alt="300x200" src="/resources/images/test.jpg" />
                            <div class="caption">
                                <h3>
                                        ${thicket.name}
                                </h3>
                                <p>
                                        ${thicket.address}
                                </p>
                                <p>
                                    <button class="btn btn-primary">${thicket.price}元</button> <a class="btn" href="#">查看详情</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>

</html>
