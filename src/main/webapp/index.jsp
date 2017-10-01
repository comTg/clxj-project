<%--
  Created by IntelliJ IDEA.
  User: tg
  Date: 17-9-26
  Time: 上午8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
    <title>Hello world</title>
    <jsp:include page="/WEB-INF/jsp/common/webnavigation.jsp" flush="true" />
</head>
<body>
<!--滚动轮播图片栏-->
<div class="scroll-picture">
    <div id="banner_tabs" class="flexslider">
        <ul class="slides">
            <li>
                <a title="" target="_blank" href="#">
                    <img
                            alt="" style="background: url(resources/images/banner1.png) no-repeat center;background-size:cover;"
                            src="/resources/images/alpha.png">
                </a>
            </li>
            <li>
                <a title="" href="#">
                    <img
                            alt="" style="background: url(/resources/images/banner2.png) no-repeat center;background-size:cover;"
                            src="/resources/images/alpha.png">
                </a>
            </li>
            <li>
                <a title="" href="#">
                    <img
                            alt="" style="background: url(/resources/images/banner3.png) no-repeat center;background-size:cover;"
                            src="/resources/images/alpha.png">
                </a>
            </li>
        </ul>
        <ul class="flex-direction-nav">
            <li><a class="flex-prev" href="javascript:;">Previous</a></li>
            <li><a class="flex-next" href="javascript:;">Next</a></li>
        </ul>
        <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
            <li><a>1</a></li>
            <li><a>2</a></li>
            <li><a>2</a></li>
        </ol>
    </div>
    <script src="/resources/js/slider.js"></script>
    <script type="text/javascript">
        $(function() {
            var bannerSlider = new Slider($('#banner_tabs'), {
                time: 5000,
                delay: 400,
                event: 'hover',
                auto: true,
                mode: 'fade',
                controller: $('#bannerCtrl'),
                activeControllerCls: 'active'
            });
            $('#banner_tabs .flex-prev').click(function() {
                bannerSlider.prev();
            });
            $('#banner_tabs .flex-next').click(function() {
                bannerSlider.next();
            });
        });
    </script>
</div>
</body>
<script type="text/javascript">
    $(function () {
        location.href = "/clxj/index";
    })
</script>
</html>
