<%--
  Created by IntelliJ IDEA.
  User: 804743542
  Date: 2020/10/10
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<html>
<head>

    <title>Title</title>

    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/login.css">

    <script>


        $(document).ready(function () {
            //登录按钮事件
            $("#bt_login").click(function () {
                    var np = {"stuName": $("#stuName").val(), "stuPwd": $("#stuPwd").val()}
                console.log(np)

                    $.ajax({
                        type: "post",//方法类型
                        //contentType:"application/json;charset=UTF-8",
                        contentType: "application/x-www-form-urlencoded",
                        dataType: "json",//预期服务器返回的数据类型
                        url: "user/login",//url
                        data: np,
                        success: function (data) {

                            console.log(data)//在控制台查看打印的值

                            if (data.code == "1") {
                                //验证成功 跳转至主页
                                window.location.href = "user/loginToHome"
                            } else if (data.code = "0") {
                                //验证失败，刷新提示
                                //return log_status=false;
                                $("#p1").show(),
                                    $("#user_errMsg").css(color, "red"),
                                    $("#pwd_errMsg").css(color, "red");
                            }

                        },
                        error: function (error) {
                            console.info(error)
                        }
                    })
                    //alert("hello");
                }
            )
            //注册按钮事件
            $("#bt_rst").click(function () {
               window.location.href="user/loginToRegist"
            })

        })

    </script>

</head>
<body >

<div class="box">
    <h2>Login</h2>
    <form  id="logForm">
        <div class="item">
            <input type="text"  id="stuName">

        </div>
        <div class="item">
            <input type="password"  id="stuPwd">
        </div>
        <input type="button" class="btn" id="bt_login" value="登录"/>


    </form>
</div>
</body>
<%--<body>--%>
<%--<div id="login">--%>
<%--    <h1>Login</h1>--%>
<%--    <form method="post"  id="logForm" action="" >--%>
<%--        <span id="user_errMsg"><input type="text"  placeholder="用户名" name="stuName" id="stuName" value="" /></span><br/>--%>
<%--        <span id="pwd_errMsg"><input type="password"  placeholder="密码" name="stuPwd" id="stuPwd" value=""  /></span><br/>--%>
<%--         <p id="p1" style="color: crimson" hidden="hidden">密码或账号错误！！</p>--%>
<%--    &lt;%&ndash;解决：使用input标签 button类型 使用Ajax提交就不会刷新页面&ndash;%&gt;--%>
<%--        <input type="button" value="登录" id="bt_login"/>--%>
<%--        <input type="button" value="注册" id="bt_rst" >--%>


<%--    </form>--%>
<%--</div>--%>

<%--</body>--%>
</html>
