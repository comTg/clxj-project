<%--
  Created by IntelliJ IDEA.
  User: tg
  Date: 17-9-30
  Time: 上午7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
    <title>${thicket.name}详情</title>
    <jsp:include page="common/webnavigation.jsp" flush="true" />
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-3 column">
                    <img alt="140x140" src="/resources/images/test.jpg" width="200px" height="133px" />
                </div>
                <div class="col-md-5 column">
                    <dl>
                        <dt>
                            丛林闲居名:
                        </dt>
                        <dd>
                            ${thicket.name}
                        </dd>
                        <dt>
                            地址类型:
                        </dt>
                        <dd>
                            ${thicket.siteType}
                        </dd>
                        <dt>
                            住址类型:
                        </dt>
                        <dd>
                            ${thicket.addressType}
                        </dd>
                        <dt>
                            详细地址:
                        </dt>
                        <dd>
                            ${thicket.address}
                        </dd>
                    </dl>
                </div>
                <div class="col-md-4 column">
                    <form role="form">
                        <div class="form-group">
                            <label for="totalprice">价格/元</label>
                            <input type="text" class="form-control" value="${thicket.price}" name="totalprice" id="totalprice" readonly>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">预订天数</label>
                            <input type="number" class="form-control" id="exampleInputEmail1" name="days" />
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">其它需求</label>
                            <textarea class="form-control" id="exampleInputPassword1" rows="5" cols="10"></textarea>
                        </div>
                        <button type="submit" class="btn btn-default btn-danger">预订</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
