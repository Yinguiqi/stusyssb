<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>学生管理系统</title>
    <link rel="stylesheet" href="../../css/bootstrap/bootstrap.min.css"/>
    <!--导入layui包-->
    <link rel="stylesheet" href="../../css/layui/layui/css/layui.css"/>
    <!--引入css文件-->
    <link rel="stylesheet" href="../../css/css/LoginCss.css" />
    <!--导入jquery包-->
    <script src="../../css/jQuery/jquery-1.11.2.js"></script>
    <%--导入layer包--%>
    <script src="../../css/layer/layer/layer.js"></script>
    <script src="../../css/layui/layui/layui.js"></script>
    <!--不能引入的样式-->
    <style>
        body{
            background-image: url("../../css/img/qg.jpg");
            width: 100%;
            height: 100%;
            background-repeat:no-repeat;
            background-size: cover;
            background-attachment: fixed;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            $("#buts").click(function(){
                var other=$(this),anim=other.data("anim");
                other.removeClass(anim);
                setTimeout(function(){
                    other.addClass(anim);
                });
                //判断登录账号或者密码是否符合不为空
                if ($("#id1").val()=="" || $("#id1").val()==null){
                    layer.tips("<span style='color: grey'>输入的账号不能为空</span>",'#id1',{tips:[2,"white"]});
                }else if ($("#id2").val()=="" || $("#id2").val()==null){
                    layer.tips("<span style='color: grey'>输入的密码不能为空</span>",'#id2',{tips:[2,"white"]});
                }else{
                    //通过阿贾克斯发送数据，并且接收回应信息
                    $.ajax({
                        type:"POST",
                        url:"/StudentLogin",//方法的类型
                        data:{"userName":$("#id1").val(),"passWord":$("#id2").val(),"checkcode":$("#checkcode").val()},
                        /*datatype:"application/json",*/
                        success:function(data){
                            //对发送过来的json字符串进行解析
                            //data=$.parseJSON(data);
                            if (data=="ok"){
                                top.location.href="/listStudent";
                            }else if(data=="no"){
                                $("#hint").text("您输入的账号或密码错误");
                            }else {
                                $("#hint").text("验证码错误");
                                $("#codeimg").prop("src","/CheckCodeServlet?now="+(new Date().getTime()));
                            }
                        }
                    });
                }
            });
            //点击刷新图片
            $("#codeimg").click(function () {
                $("#codeimg").prop("src","/CheckCodeServlet?now="+(new Date().getTime()));

            });
        });
    </script>
</head>
<body>

    <div class="container-fluid">
        <div  class="row">
            <div id="login" class="col-sm-12">
                <%--        <h1>登录</h1>--%>
                <form action="#" method="post" class="site-doc-icon site-doc-anim" id="loginForm">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-12">
                                <input type="text" id="id1" required="required" value="" placeholder="用户名" name="u"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <input type="password" id="id2" required="required" value="" placeholder="密码" name="p"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <input id="checkcode" type="text" placeholder="点击刷新验证码" required="required" name="c"/>
                            </div>
                            <div class="col-sm-6">
                                <img id="codeimg" src="/CheckCodeServlet?now=${requestScope.get("time")}" title="看不清点击刷新" width="120px" height="45px">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div style="width: 200px;height: 20px;position: relative;bottom: 20px;color: red;" id="hint"></div>
                            </div>
                        </div>
                    </div>

                    <input class="layui-anim" style="position: relative;bottom: 20px;"  data-anim="layui-anim-scaleSpring"  type="button" value="登录" id="buts" />
                </form>
            </div>
        </div>
        <div class="row">
            <div id="footer" class="col-sm-12">
                问题不大
            </div>
        </div>
    </div>

</body>
</html>
