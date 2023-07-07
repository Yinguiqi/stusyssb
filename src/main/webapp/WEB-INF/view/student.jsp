<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/7/6
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="cn"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang="cn"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang="cn"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="cn"> <!--<![endif]-->
<head>
    <%-- 引入JQ和Bootstrap --%>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../css/jQuery/jquery-1.11.2.js"></script>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="../../css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../css/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function validateForm() {
            var studentId = document.getElementById('student_id1').value;
            var name = document.getElementById('name1').value;
            var dormitoryId = document.getElementById('dormitory_id1').value;

            if (studentId === '' && name === '' && dormitoryId === '') {
                alert('请至少输入一个查询条件');
                return false; // 阻止表单提交
            }

            return true; // 允许表单提交
        }
    </script>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="../../css/assets/js/main.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ela Admin - HTML5 Admin Template</title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
    <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../../css/assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="../../css/assets/css/style.css">
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
</head>
<body>
<!-- Left Panel -->

<aside id="left-panel" class="left-panel">
    <nav class="navbar navbar-expand-sm navbar-default">

        <div id="main-menu" class="main-menu collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="index.html"><i class="menu-icon fa fa-laptop"></i>Dashboard </a>
                </li>
                <li class="menu-title">UI elements</li><!-- /.menu-title -->
                <li class="menu-item-has-children dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Components</a>
                    <ul class="sub-menu children dropdown-menu">
                        <li><i class="fa fa-bars"></i><a href="ui-tabs.html">Tabs</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </nav>
</aside><!-- /#left-panel -->
<!-- Left Panel -->
<!-- Left Panel -->

<!-- Right Panel -->

<div id="right-panel" class="right-panel">

    <!-- Header-->
    <header id="header" class="header">
        <div class="top-left">
            <div class="navbar-header">
                <a class="navbar-brand" href=".."><img src="../../css/images/logo.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href=".."><img src="../../css/images/logo2.png" alt="Logo"></a>
                <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
            </div>
        </div>
        <div class="top-right">
            <div class="header-menu">
                <div class="header-left">
                    <button class="search-trigger"><i class="fa fa-search"></i></button>
                    <div class="form-inline">
                        <form class="search-form">
                            <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                            <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                        </form>
                    </div>

                    <div class="dropdown for-notification">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="notification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-bell"></i>
                            <span class="count bg-danger">3</span>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="notification">
                            <p class="red">You have 3 Notification</p>
                            <a class="dropdown-item media" href="#">
                                <i class="fa fa-check"></i>
                                <p>Server #1 overloaded.</p>
                            </a>
                            <a class="dropdown-item media" href="#">
                                <i class="fa fa-info"></i>
                                <p>Server #2 overloaded.</p>
                            </a>
                            <a class="dropdown-item media" href="#">
                                <i class="fa fa-warning"></i>
                                <p>Server #3 overloaded.</p>
                            </a>
                        </div>
                    </div>

                    <div class="dropdown for-message">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="message" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-envelope"></i>
                            <span class="count bg-primary">4</span>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="message">
                            <p class="red">You have 4 Mails</p>
                            <a class="dropdown-item media" href="#">
                                <span class="photo media-left"><img alt="avatar" src="../../css/images/avatar/1.jpg"></span>
                                <div class="message media-body">
                                    <span class="name float-left">Jonathan Smith</span>
                                    <span class="time float-right">Just now</span>
                                    <p>Hello, this is an example msg</p>
                                </div>
                            </a>
                            <a class="dropdown-item media" href="#">
                                <span class="photo media-left"><img alt="avatar" src="../../css/images/avatar/2.jpg"></span>
                                <div class="message media-body">
                                    <span class="name float-left">Jack Sanders</span>
                                    <span class="time float-right">5 minutes ago</span>
                                    <p>Lorem ipsum dolor sit amet, consectetur</p>
                                </div>
                            </a>
                            <a class="dropdown-item media" href="#">
                                <span class="photo media-left"><img alt="avatar" src="../../css/images/avatar/3.jpg"></span>
                                <div class="message media-body">
                                    <span class="name float-left">Cheryl Wheeler</span>
                                    <span class="time float-right">10 minutes ago</span>
                                    <p>Hello, this is an example msg</p>
                                </div>
                            </a>
                            <a class="dropdown-item media" href="#">
                                <span class="photo media-left"><img alt="avatar" src="../../css/images/avatar/4.jpg"></span>
                                <div class="message media-body">
                                    <span class="name float-left">Rachel Santos</span>
                                    <span class="time float-right">15 minutes ago</span>
                                    <p>Lorem ipsum dolor sit amet, consectetur</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="user-area dropdown float-right">
                    <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img class="user-avatar rounded-circle" src="../../css/images/admin.jpg" alt="User Avatar">
                    </a>

                    <div class="user-menu dropdown-menu">
                        <a class="nav-link" href="#"><i class="fa fa-user"></i>My Profile</a>

                        <a class="nav-link" href="#"><i class="fa fa-bell-o"></i>Notifications <span class="count">13</span></a>

                        <a class="nav-link" href="#"><i class="fa fa-cog"></i>Settings</a>

                        <a class="nav-link" href="#"><i class="fa fa-power-off"></i>Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </header><!-- /header -->
    <!-- Header-->
    <div class="breadcrumbs">
        <div class="breadcrumbs-inner">
            <div class="row m-0">
                <div class="col-sm-4">
                    <div class="page-header float-left">
                        <div class="page-title">
                            <h1>学生管理</h1>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="page-header float-right">
                        <div class="page-title">
                            <ol class="breadcrumb text-right">
                                <li><a href="#">Dashboard</a></li>
                                <li class="active">学生</li>
                                <li><a href="#">管理员</a></li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="content">
        <div class="animated fadeIn">
            <div class="row">

                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">学生列表</strong>
                        </div>
                        <div class="card-body" >
                            <a href="/student"><button>返 回</button></a>
                            <form method="post" action="/retrieveStudent" role="form" onsubmit="return validateForm()">
                                <table class="retrieveTable" style="margin-left: auto; margin-right: 0;">
                                    <tr>
                                        <td>学号：</td>
                                        <td><input type="text" name="student_id" id="student_id1" placeholder="请在这里输入学号"></td>
                                        <td>姓名：</td>
                                        <td><input type="text" name="name" id="name1" placeholder="请在这里输入名字"></td>
                                        <td>宿舍号：</td>
                                        <td><input type="text" name="dormitory_id" id="dormitory_id1" placeholder="请在这里输入宿舍号"></td>
                                        <td colspan="2" align="center">
                                            <button type="submit" class="btn btn-success">查 询</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                            <!--table-striped是条形表格-->
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">学号</th>
                                    <th scope="col">姓名</th>
                                    <th scope="col">宿舍号</th>
                                    <th scope="col">年龄</th>
                                    <th scope="col">性别</th>
                                    <th scope="col">出生日期</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${students}" var="s" varStatus="status">
                                    <tr>
                                        <td>${s.student_id}</td>
                                        <td>${s.name}</td>
                                        <td>${s.dormitory_id}</td>
                                        <td>${s.age}</td>
                                        <td>${s.sex}</td>
                                        <td>${s.birthday}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                            <nav class="pageDIV" style="text-align:center;">
                                <ul class="pagination" >
                                    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
                                        <a href="?page.start=0">
                                            <span>«</span>
                                        </a>
                                    </li>

                                    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
                                        <a href="?page.start=${page.start-page.count}">
                                            <span>‹</span>
                                        </a>
                                    </li>

                                    <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">

                                        <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                                            <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                                                <a href="?page.start=${status.index*page.count}"
                                                   <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                                                >${status.count}</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>

                                    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                                        <a href="?page.start=${page.start+page.count}">
                                            <span>›</span>
                                        </a>
                                    </li>
                                    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                                        <a href="?page.start=${page.last}">
                                            <span>»</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>

            </div>
        </div><!-- .animated -->
    </div><!-- .content -->

    <div class="clearfix"></div>

    <footer class="site-footer">
        <div class="footer-inner bg-white">
            <div class="row">
                <div class="col-sm-6">
                    Copyright &copy; 2018 Ela Admin
                </div>
                <div class="col-sm-6 text-right">
                    Designed by <a href="https://colorlib.com">Colorlib</a>
                </div>
            </div>
        </div>
    </footer>

</div><!-- /#right-panel -->

</div>
</body>
</html>
