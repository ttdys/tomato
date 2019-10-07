<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>

    <title>Tomato Admin</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body  background="${pageContext.request.contextPath}/static/image/2.png">

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">登录</h3>
                    </div>
                    <div class="panel-body">
                        <form  action="${pageContext.request.contextPath}/system/user/loginUser.do" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="用户名" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="密码" name="password" type="password" >
                                </div>
                                <div class="form-group">
                                    <label><input class="form-control"  name="verificationCode" type="text" placeholder="请输入验证码" >
                                    </label>
                                    <label> <img id="verifyCode" src="${pageContext.request.contextPath}/getVerifyCode.do"  onclick="changeCode()" height="34px" width="130px"></label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="rememberMe" type="checkbox" >记住我
                                    </label>
                                </div>
   <!-- Change this to a button or input when using this as a form -->
                                <input type="submit" class="btn btn-lg btn-success btn-block" value="登录" />
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        function changeCode(){
            var src = "${pageContext.request.contextPath}/getVerifyCode.do?"+new Date().getTime(); //加时间戳，防止浏览器利用缓存

            $("#verifyCode").attr('src',src);                  //jQuery写法
        }
    </script>


    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/static/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/static/dist/js/sb-admin-2.js"></script>

</body>

</html>
