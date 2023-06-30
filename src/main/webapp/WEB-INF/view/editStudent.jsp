<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/15
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <%-- 引入JQ和Bootstrap --%>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../jQuery/jquery-1.11.2.js"></script>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="../bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../js/bootstrap.min.js"></script>

    <title>学生管理页面 - 编辑页面</title>
</head>

<body>

<div class="editDIV" style="width:300px;margin:0 auto;">

    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">修改学生</h3>
        </div>
        <div class="panel-body">

            <form method="post" action="${pageContext.request.contextPath}/LoginController/updateStudent" role="form">
                <table class="addTable">
                    <tr>
                        <td>学号：</td>
                        <td><input type="text" name="student_id" id="student_id" value="${student.student_id}"></td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="name" id="name" value="${student.name}"></td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input type="text" name="age" id="age" value="${student.age}"></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input type="radio" class="radio radio-inline" name="sex" value="男"> 男
                            <input type="radio" class="radio radio-inline" name="sex" value="女"> 女
                        </td>
                    </tr>
                    <tr>
                        <td>出生日期：</td>
                        <td><input type="date" name="birthday" id="birthday" value="${student.birthday}" placeholder="请在这里输入出生日期"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <%--设置隐藏域，根据 id 进行发送数据--%>
                            <input type="hidden" name = "id" value = ${student.id}>
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>
