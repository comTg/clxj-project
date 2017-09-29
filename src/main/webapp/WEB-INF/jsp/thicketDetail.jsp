<%--
  Created by IntelliJ IDEA.
  User: tg
  Date: 17-9-26
  Time: 上午8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>
<head>
    <title>所有${addressType}</title>
    <jsp:include page="/WEB-INF/jsp/common/webnavigation.jsp" flush="true" />
</head>
<body>
</body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron">
                <h1 class="text-info">
                    ${addressType}推荐
                </h1>
                <p class="text-info">
                    国庆中秋大特价,现在订购${addressType}还有半价优惠哦!
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">了解更多</a>
                </p>
            </div>
            <div class="row">
                <c:forEach items="${thicket_list}" var="thicket">
                    <div class="col-md-4">
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
            <div class="row clearfix">
                <div class="col-md-5 column">
                </div>
                <div class="col-md-4 column">
                    <ul class="pagination">
                        <li>
                            <a href="#">Prev</a>
                        </li>
                        <li class="${activateState}">
                            <a href="/clxj/${urlType}/list">1</a>
                        </li>
                        <c:forEach items="${pageCode_list}" var="pageCode">
                            <li class="${pageCode.classType}">
                                <a href="/clxj/${urlType}/list/page=${pageCode.page}">${pageCode.page}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href="#">Next</a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-3 column">
                </div>
            </div>
        </div>
    </div>
</div>

</html>
