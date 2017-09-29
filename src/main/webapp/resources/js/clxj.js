// 存放主要交互逻辑的js代码
// javascript 模块化(package.类.方法)

var clxj = {
    // 封装丛林闲居相关的url
    URL: {
        login: function () {
            return "/clxj/loginUser";
        },
        validationPhone: function (phone) {
            return "/clxj/" + phone + "/judge"
        },
        getcodeurl:function (phone) {
            return "/clxj/"+phone+"/getcode";
        },
    },
    //验证手机号
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;//直接判断对象会看对象是否为空,空就是undefine就是false; isNaN 非数字返回true
        } else {
            return false;
        }
    },
    // 判断登录页面表格手机号是否已注册
    interceptform: function (node) {
        $('form').submit(function (e) {
            var phone = $('#phone').val();
            var password = $('#password').val();
            console.log("inputphone:" + phone + ";inputpasswd:" + password);
            if (!clxj.validatePhone(phone)) {
                node.hide().html('<label class="label label-danger">手机号码格式错误</label>').show(300);
                e.preventDefault();
            } else {
                console.log("手机号验证通过");
                var phoneUrl = clxj.URL.validationPhone(phone);
                var phonestate = $.ajax({
                    url:phoneUrl,
                    async:false,
                    type:"post",
                    dataType:"json",
                    success:function (result) {
                        console.log(result);
                        if (result && result['success']) {
                            console.log(result['error']);
                        } else {
                            // 不能在数据库中找到手机号码记录
                            console.log(result['error']);
                        }
                    }
                });
                var state = phonestate['responseJSON']['success'];
                if (!state) {
                    node.hide().html('<label class="label label-danger">手机号未注册</label>').show(300);
                    e.preventDefault();
                }else{
                    // 写入用户的手机号码用作cookie
                }
            }
        });
    },
    // 判断手机号码是否存在
    is_exists_phone: function () {
        var phone = $('#phone').val();
        var submitbtn = $('#btnSubmit');
        if (!clxj.validatePhone(phone)) {
            submitbtn.addClass('disabled');
            $('#loginTips').hide().html('<label class="label label-danger">手机号码格式错误</label>').show(300);
        } else {
            console.log("手机号验证通过");
            submitbtn.removeClass('disabled');
            var phoneUrl = clxj.URL.validationPhone(phone);
            $.post(phoneUrl, {}, function (result) {
                console.log(result);
                if (result && result['success']) {
                    console.log(result['error']);
                    $('#loginTips').hide();
                } else {
                    $('#loginTips').hide().html('<label class="label label-danger">手机号未注册</label>').show(300);
                }
            });
        }
    },
    login_success:function(phone,state,url) {
        console.log("登录手机:"+phone);
        if(state){
            $.cookie('userPhone',phone,{expires: 7, path: '/clxj'});
        }
        var timeBox = $('#time-box');
        var now = new Date().getTime();
        var to_time = new Date(now+2000);
        timeBox.countdown(to_time,function (event) {
            //时间格式
            var format = event.strftime("跳转倒计时: %S 秒");
            timeBox.html(format);
        }).on('finish.countdown',function () {
            // 时间完成后,执行跳转操作
            console.log('______fininsh.countdown');
            location.href = url;
        });
    },
    judge_login:function(){
        // 判断浏览器中是否保存了cookie
        var userPhone = $.cookie('userPhone');
        if(clxj.validatePhone(userPhone)){
            $('#per-center').removeClass("hidden");
            $('#need-login').addClass("hidden");
        }else{
            $('#need-login').removeClass("hidden");
            $('#per-center').addClass("hidden");
        }
    },
    logout:function () {
        if($.cookie('userPhone')){
            $.removeCookie('userPhone',{path:'/clxj'});
            // window.location.reload();
            // $.cookies.del('userPhone');
        }
    },
    getcode:function () {
        var phone = $('#phone').val();
        var getcode_url = clxj.URL.getcodeurl(phone);
        var btn = $('#btnvalidate');
        var result = $.ajax({
            url:getcode_url,
            async:false,
            type:"post",
            dataType:"json",
            success:function (result) {
                console.log(result);
                if (result && result['success']) {
                    console.log(result['error']);
                } else {
                    // 手机号码不存在
                    console.log(result['error']);
                }
            }
        });
        var state = result['responseJSON']['success'];
        if(state){
            // 先禁用按钮
            btn.addClass('disabled');
            btn.disabled=true;
            // 倒计时恢复按钮
            var now = new Date().getTime();
            var to_time = new Date(now+59000);
            $('#loginTips').hide().html('<label class="label label-danger">验证码已发送</label>').show(300);
            btn.countdown(to_time,function (event) {
                //时间格式
                var format = event.strftime("%S 秒");
                btn.html(format);
            }).on('finish.countdown',function () {
                // 时间完成后,执行跳转操作
                console.log('______fininsh.countdown');
                btn.removeClass('disabled');
                btn.html("获得验证码")
                btn.disabled=false;
            });
        }
    },
}