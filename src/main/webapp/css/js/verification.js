function versession(type) {
    $.ajax({
        url:"../LoginServlet?method=versession",
        type:"post",
        data:{"loginType":type},
        success:function (data) {
            console.log(data);
          if(data=="out"){
              window.location.href="adminlogin.jsp";
          }
        }
    });
}