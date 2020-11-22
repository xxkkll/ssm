<%--
  Created by IntelliJ IDEA.
  User: 804743542
  Date: 2020/10/12
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,
    initial-scale=1.0">
    <link rel = "stylesheet" href = "https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"   >

    <link rel="stylesheet" href="../css/index01.css">
    <script src="../js/jquery.min.js"></script>
    <title>智能安防</title>
</head>
<body class="index" style="background-image: url('../images/04.gif');">
<!-- 顶部开始 -->
<div class="top-nav">
    <div class="logo">
        <a href="#">智能安防WEB管理系统</a>
    </div>
    <!-- 打开/关闭左侧导航条 -->
    <div class="left-open">
        <a>
            <i title="展开左侧栏" class="fa fa-bars"></i>
        </a>
    </div>
</div>
<!-- 顶部结束 -->
<!-- 左侧导航条开始 -->
<div class="out-left-nav">
    <div class="left-nav">
        <ul class="top-menu">
            <li>
                <a href="#">用户管理</a>
            </li>
            <li>
                <a href="#">管理员管理</a>
            </li>
            <li class="open">
                <a href="#" class="active" id="open-eqmt">设备管理<i class="fa fa-angle-down"></i></a>
                <ul class="open-menu" style="display: none;">
                    <li>
                        <a href="../html/device.html" class="" target="ifram-a">设备信息总览</a>
                    </li>
                    <li>
                        <a href="../html/device-add.html" target="ifram-a">增添设备</a>
                    </li>
                    <li>
                        <a href="#" id="open-eqmtlst">设备列表<i class="fa fa-angle-down"></i></a>
                        <ul id="open-eqmtlst-menu" style="display: none;">
<%--                            <li><a href="../html/device-list.html" target="ifram-a">温湿度传感器</a></li>--%>
<%--                            <li><a href="../html/device-list.html" target="ifram-a">烟雾传感器</a></li>--%>
                        </ul>
                    </li>
                </ul>
            </li>


        </ul>
    </div>
</div>
<!-- 左侧导航条结束 -->
<!-- 右侧内容区开始 -->
<div class="page-content">
    <div class="layui-tab tab flag3"  lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li id="myHome" class="home" lay-id="Home">
                <i class="fa fa-television"></i>数据总览
            </li>

        </ul>
        <div class="layui-tab-content ">
            <div class="layui-tab-item layui-show layui-hide layui-anim layui-anim-fadein" id="showHome" >
                <iframe src='...........' id="hom" frameborder="0" style="width:100%;height:100%;overflow:scroll;overflow-x:hidden"
                        class="x-iframe" name="ifram-a"></iframe>
            </div>
        </div>
        <div id="tab_show"></div>
    </div>

</div>

<div class="page-content-bg"></div>
<style id="theme_style"></style>
</body>
<script>
    $(document).ready(function(){
        // 关闭/打开左侧导航栏
        $(".left-open").click(function(){

            $(".out-left-nav").slideToggle();

        })

        // 滑出设备管理列表
        $("#open-eqmt").click(function(){
            $(".open-menu").slideToggle()

        })
        var flag=0;
        //滑出设备列表菜单
        $("#open-eqmtlst").click(function(){
            console.log("执行选择前:"+flag)
            if(flag==0){
                //$("#open-eqmtlst-menu").slideToggle()
                $.ajax({
                    url:"../equipment/findEquipmentType",
                    type:"post",
                    contentType:"application/json;charset=UTF-8",
                    dataType:"json",
                    success:function (data) {
                        console.log(data)
                        var types=data.data

                        //获取ul
                        var ul=document.getElementById("open-eqmtlst-menu")
                        //创建li
                        for (var i=0;i<types.length;i++){
                            //创建li标签
                            var li=document.createElement("li")
                            //往ul添加li
                            ul.appendChild(li);
                            //创建a标签 建立超链接和目标
                            var a=document.createElement("a");
                            a.setAttribute('href','../html/device-list.html');
                            a.setAttribute('target','ifram-a');
                            //往li中添加a标签
                            li.appendChild(a);
                            //往a标签添加数据
                            a.innerHTML=types[i].equipment_type;
                        }

                    }

                })
                $("#open-eqmtlst-menu").slideToggle()
            }
                if(flag!=0) {
                $("#open-eqmtlst-menu").slideToggle();
                console.log("执行else选择:"+flag)
            }
            flag++;
            console.log("执行选择后:"+flag)

        })
    })
</script>

</html>
