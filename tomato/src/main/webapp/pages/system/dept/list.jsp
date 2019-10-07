<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Tomato Admin</title>
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
</head>
<body>
<div id="wrapper">
    <%@include file="/pages/main/aside.jsp" %>


    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">

                        <!--	<button type="button" class="btn btn-default">Default</button>
                            <button type="button" class="btn btn-primary">Primary</button>
                            <button type="button" class="btn btn-success">Success</button>

                            <button type="button" class="btn btn-warning">����</button>
                            <button type="button" class="btn btn-danger">ɾ��</button>
                            <button type="button" class="btn btn-link">Link</button>-->

                        <h3>角色列表</h3>
                        <shiro:hasPermission name="system:role:add">
                            <div align="right" style="width: 80%;">
                                <button id="btn" type="button" class="btn btn-info" onclick="show_add()">新建+</button>
                            </div>
                        </shiro:hasPermission>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>上级ID</th>
                                    <th>部门名称</th>
                                    <th>序号</th>
                                    <th>状态</th>
                                    <th>操作者</th>
                                    <th>操作时间</th>
                                    <th>备注</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${allDept}" var="dept" varStatus="status">
                                    <tr>
                                        <td>${status.index}</td>
                                        <td>${dept.parentId}</td>
                                        <td>${dept.deptName}</td>
                                        <td>${dept.deptSort}</td>
                                        <td>${dept.status}</td>
                                        <td>${dept.operator}</td>
                                        <td>${dept.operateTime}</td>
                                        <td>${dept.remark}</td>
                                     <td>
                                            <shiro:hasPermission name="system:role:edit">
                                                <a href="${pageContext.request.contextPath}/system/role/updatePage/{role.roleId}.do">
                                                    <button type="button" class="btn btn-warning">更新</button>
                                                </a>
                                            </shiro:hasPermission>
                                            <shiro:hasPermission name="system:role:remove">
                                                <a href="${pageContext.request.contextPath}/system/role/remove/{role.roleId}.do">
                                                    <button type="button" class="btn btn-danger">删除</button>
                                                </a>
                                            </shiro:hasPermission>
                                        </td>
                                    </tr>
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

        </div>
    </div>

</div>


<script>
    $(document).ready(function () {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });

    function show_add() {
        window.open("${pageContext.request.contextPath}/pages/system/role/add.jsp", "target_parent", 'top=50,left=100,width=800,height=580,menubar=no,location=no,toolbar=no');
    }


</script>


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

<!-- Page-Level Demo Scripts - Tables - Use for reference -->

</body>
</html>
   
  