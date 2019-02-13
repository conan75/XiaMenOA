<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/bootstrap/bootstrap.min.css">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/bootstrap/bootstrap-theme.min.css">
    <script src="/bootstrap/jquery-1.11.0.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/bootstrap/bootstrap.min.js"></script>
</head>
<style type="text/css">
    html,body{
        overflow:hidden;
        height:100%;
    }
</style>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="margin: 380px 380px">
            <div class="login-panel panel panel-default"style="margin-top:-130px" >
                <div class="panel-heading">
                    <h3 class="panel-title" style="text-align: center;">登录</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="/login" method="post" id="login_form">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="用户名" name="username" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="password" type="password" value="">
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <%--<a href="javascript:void(0)" class="btn btn-lg btn-success btn-block" id='login_btn'>登录</a>--%>
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="登录">
                        </fieldset>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

//    $(function () {
//        $("#login_btn").click(function () {
//            $.ajax({
//                url:"/user/checkLogin.do",
//                type:"POST",
//                data:$("#login_form").serialize(),
//                success:function (result) {
//                    if(result){
//                        window.location.href= "/bug/findByPage.do";
//                    }else {
//                        alert("账号或密码错误!");
//                    }
//                }
//            });
//        });
//    });
</script>
</body>
</html>
