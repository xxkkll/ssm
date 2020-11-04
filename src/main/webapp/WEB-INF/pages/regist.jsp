
<%--
  Created by IntelliJ IDEA.
  User: 804743542
  Date: 2020/10/10
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" %>
<html>
<head>
    <%--之前错误路径--%>
   <%-- <script src="/js/http_s3.pstatp.com_cdn_expire-1-M_jquery_3.2.1_jquery.js"></script>--%>
        <%--正确路径--%>
    <script src="../js/http_s3.pstatp.com_cdn_expire-1-M_jquery_3.2.1_jquery.js"></script>
    <title>Title</title>
    <script>
        $(document).ready(function () {
            var phone=$("#rgs_phoneNum").val();
            //验证昵称
            $("#rgs_phoneNum").onfocus=function(){
                if (phone.length==11){
                    $("#rgs_o1").show();
                }
            }

            //提交事件
            $("#rgs").click(function () {

                var date={
                    "stuName":$("#rgs_userName").val(),
                    "stuNum":$("#rgs_phoneNum").val(),
                    "stuPwd":$("#rgs_pwd").val()
                }

                $.ajax({
                    type:"post",
                    url:"regist",
                    contentType:"application/json;charset=UTF-8",
                    data:JSON.stringify(date),
                    dataType:"json",
                    success:function (data) {
                        console.log(data)//在控制台查看打印的值
                        if (data.code==1){
                            console.log(data)
                            alert("注册成功！")
                            window.location.href="/ssm/index.jsp"
                        }
                        else {
                            alert(data.msg)
                        }

                    }
                })
            })
   /* alert("nnnnnnnnnnn")*/
        })
    </script>
</head>
<body>
<h1>注册</h1>
<div>
    <h1 id="h_rgs">注册</h1>
    <form id="rgs_form" method="post" action="">
        <input type="text" placeholder="请输入昵称" id="rgs_userName"/><br/>
        <input type="text" placeholder="请输入11位手机号" id="rgs_phoneNum"/><br/>
        <input type="text" placeholder="情输入6位的密码" id="rgs_pwd"/><br/>
    </form>
</div>
<input type="button" value="注册" id="rgs"/>
</body>
</html>
