    <%--
      Created by IntelliJ IDEA.
      User: zjh
      Date: 2019/10/3
      Time: 21:51
      To change this template use File | Settings | File Templates.
    --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>
        <head>
        <title>Title</title>
        </head>
            <!-- Bootstrap Core CSS -->
            <link href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

            <!-- MetisMenu CSS -->
            <link href="${pageContext.request.contextPath}/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

            <!-- DataTables CSS -->
            <link href="${pageContext.request.contextPath}/static/vendor/datatables-plugins/dataTables.bootstrap.css"
            rel="stylesheet">

            <!-- DataTables Responsive CSS -->
            <link href="${pageContext.request.contextPath}/static/vendor/datatables-responsive/dataTables.responsive.css"
            rel="stylesheet">

            <!-- Custom CSS -->
            <link href="${pageContext.request.contextPath}/static/dist/css/sb-admin-2.css" rel="stylesheet">

            <!-- Custom Fonts -->
            <link href="${pageContext.request.contextPath}/static/vendor/font-awesome/css/font-awesome.min.css"
            rel="stylesheet" type="text/css">
        <body>

            <div id="wrapper">

            <!-- Navigation -->
            <%@include file="/pages/main/aside.jsp"%>

            <div id="page-wrapper">

            <div class="row">
            <div class="col-lg-12">
                  <div class="panel panel-default">
                            <div class="panel-heading">
                           表
                                    </div>
                    <!-- /.panel-heading -->
                            <div class="panel-body">
                                    <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                            <thead>
                                                            <tr>
                                                            <th>#</th>
                                                            <th>名称</th>
                                                            <th>链接</th>
                                                            <th>类型</th>
                                                            <th>权限</th>
                                                            <th>备注</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
            <c:forEach items="${menusMax}" var="menu" varStatus="status">
                    <c:if test="${menu.parentId == 0}" >
                                                            <tr id="a${menu.menuId}" style="background-color: pink">
                                                            <td>${status.index}</td>
                            <td><p class="fa fa-angle-down">  </p>${menu.menuName}</td>
                                                            <td>${menu.url}</td>
                                                            <td>${menu.menuType}</td>
                                                            <td>${menu.perms}</td>
                                                            <td>${menu.remark}</td>
                                                            <td>删除/更新</td>
                                                            </tr>
                            <c:forEach items="${menusMax}" var="mm" varStatus="st">
                                    <c:if test="${menu.menuId==mm.parentId}" >
                                            <tr class="ab${menu.menuId}">
                                            <td>${st.index}</td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;${mm.menuName}</td>
                                            <td>${mm.url}</td>
                                            <td>${mm.menuType}</td>
                                            <td>${mm.perms}</td>
                                            <td>${mm.remark}</td>
                                            <td>删除/更新</td>
                                            </tr>
                                            <c:forEach items="${menusMax}" var="littleM" varStatus="lst">
                                                    <c:if test="${mm.menuId==littleM.parentId}" >
                                                            <tr class="abc${littleM.menuId}">
                                                            <td>${lst.index}</td>
                                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;${littleM.menuName}</td>
                                                            <td>${littleM.url}</td>
                                                            <td>${littleM.menuType}</td>
                                                            <td>${littleM.perms}</td>
                                                            <td>${littleM.remark}</td>
                                                            <td>删除/更新</td>
                                                            </tr>
                                                    </c:if>
                                            </c:forEach>



                                    </c:if>
                            </c:forEach>

                    </c:if>

            </c:forEach>
                                                            </tbody>
                                                    </table>
                                    </div>
                            <!-- /.table-responsive -->
                            </div>
                    <!-- /.panel-body -->
                    </div>
            <!-- /.panel -->
            </div>
            <!-- /.col-lg-6 -->

            </div>


            </div>
            <!-- /#page-wrapper -->

            </div>


            <script>

            $(function() {

            })
            var a=1;
            $("#a1").click(function(){
                 if( a%2==0) {
                         $(".ab1").hide();
                         a = a+1;
                    }else {
                   $(".ab1").show();
                   a = a+1;
                 }

            });
                var b=1;
            $("#a2").click(function(){
            if( b%2==0) {
            $(".ab2").hide();
            b= b+1;
            }else {
            $(".ab2").show();
            b = b+1;
            }
            });
            var c=1;
            $("#a3").click(function(){
            if( c%2==0) {
            $(".ab3").hide();
            c= c+1;
            }else {
            $(".ab3").show();
            c = c+1;
            }

            });
            </script>

        </body>
            <!-- jQuery -->
            <script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js"></script>

            <!-- Metis Menu Plugin JavaScript -->
            <script src="${pageContext.request.contextPath}/static/vendor/metisMenu/metisMenu.min.js"></script>

            <!-- DataTables JavaScript -->
            <script src="${pageContext.request.contextPath}/static/vendor/datatables/js/jquery.dataTables.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/static/vendor/datatables-responsive/dataTables.responsive.js"></script>

            <!-- Custom Theme JavaScript -->
            <script src="${pageContext.request.contextPath}/static/dist/js/sb-admin-2.js"></script>

            </html>
