$(function(){
    $('body').keyup(function(event){

        if(event.keyCode ==13){
            $("#buts").trigger("click");
        }
    });

    //添加登录按钮的点击事件
    $("#buts").click(function(){
        //为点击添加动态效果
        var other=$(this),anim=other.data("anim");
        other.removeClass(anim);
        setTimeout(function(){
            other.addClass(anim);
        });
        //判断登录账号或者密码是否符合不为空
        if ($("#id1").val()=="" || $("#id1").val()==null || $("#id2").val()=="" || $("#id2").val()==null){
        }else{
            //通过阿贾克斯发送数据，并且接收回应信息
            $.ajax({
                type:"post",
                url:"../LoginServlet?method=teacherLogin",
                data:"userName="+$("#id1").val()+"&password="+$("#id2").val(),
                success:function(data){
                    if (data=="ok"){
                        window.location.href="TeacherHome.jsp";
                    }else{
                        layer.msg("账号或密码错误");
                    }
                }
            });
            //window.location.href="TeacherHome.jsp";
        }
    });
});
