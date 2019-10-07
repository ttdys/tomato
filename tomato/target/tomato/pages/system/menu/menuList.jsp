<%--
  Created by IntelliJ IDEA.
  User: zjh
  Date: 2019/10/3
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>
    <title>Tomato Admin</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/static/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

    <!-- /.navbar-header -->


    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu" style="align-self: center">
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="Search...">
                        <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                    </div>
                    <!-- /input-group -->
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/index.do">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 首页</a>
                </li>
                <c:forEach items="${menus}" var="menu" >
                <c:if test="${menu.menuType == '目录'}" >
                <li>
                    <a href="${menu.url}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${menu.menuName}<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <c:forEach items="${menus}" var="lm" >
                            <c:if test="${lm.parentId == menu.menuId}" >
                                <li><a href="${pageContext.request.contextPath}${lm.url}.do" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lm.menuName}</a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </li>
                </c:if>

                </c:forEach>

        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>
</body>

<!-- jQuery -->
<script src=".${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src=".${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src=".${pageContext.request.contextPath}/static/vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src=".${pageContext.request.contextPath}/static/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src=".${pageContext.request.contextPath}/static/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src=".${pageContext.request.contextPath}/static/vendor/datatables-responsive/dataTables.responsive.js"></script>

<!-- Custom Theme JavaScript -->
<script src=".${pageContext.request.contextPath}/static/dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->

</html>
