<%--
  Created by IntelliJ IDEA.
  User: zjh
  Date: 2019/10/2
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
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
		<link href="${pageContext.request.contextPath}/static/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

		<!-- DataTables Responsive CSS -->
		<link href="${pageContext.request.contextPath}/static/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

		<!-- Custom CSS -->
		<link href="${pageContext.request.contextPath}/static/dist/css/sb-admin-2.css" rel="stylesheet">

		<!-- Custom Fonts -->
		<link href="${pageContext.request.contextPath}/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet"
		 type="text/css">
	</head>
	<body>


		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						角色表
					</div>

					<div class="panel-body">
						<form id="userAdd" action="${pageContext.request.contextPath}/system/menu/add.do" method="post">
							<div class="form-group">
								<label>菜单名称</label>
								<input name="menuName" class="form-control" placeholder="菜单名称" style="width: 30%;"></p>
							</div>
							<div class="form-group">
								<label>上级目录</label>
											<select   name="parentId" class="form-control"  placeholder="上级目录" style="width: 30%;">
											<c:forEach items="${menus}" var="menu" >
												<option value="${menu.menuId}">${menu.menuName}</option>
											</c:forEach>
											</select>
							</div>
							<div class="form-group">
								<label>显示顺序</label>
								<input name="menuSort" class="form-control" placeholder="显示顺序" style="width: 30%;">
							</div>

							<div class="form-group">
								<label>请求地址/路径</label>
								<input name="url" class="form-control" placeholder="请求路径" style="width: 30%;">
							</div>
							<div class="form-group">
								<label>打开方式:弹窗 / 父框架</label>
								<select class="form-control" name="target" style="width: 30%;">
									<option value="0">页签</option>
									<option value="1">新窗口</option>
								</select>
							</div>

							<div class="form-group">
								<label>菜单类型</label>
								<select class="form-control" name="menuType" style="width: 30%;">
									<option value="M">目录</option>
									<option value="F">菜单</option>
									<option value="C">按钮</option>
								</select>
							</div>
							<div class="form-group">
								<label>权限标识</label>
								<input name="perms" class="form-control" placeholder="请求路径" style="width: 30%;">
							</div>

							<!-- 	<div class="form-group">
								<label>状态</label>
								<select class="form-control" name="status" style="width: 30%;">
									<option value="0">开启</option>
									<option value="1">停用</option>
								</select>
							</div> -->
							<div class="form-group">
								<label>备注</label>
								<textarea name="remark" class="form-control" rows="3" style="width: 60%;"></textarea>
							</div>
							<input type="button" value="确认" onclick="page_close()" />
						</form>
					</div>
				</div>
			</div>
		</div>

		<script>
			$(document).ready(function() {
				$('#dataTables-example').DataTable({
					responsive: true
				});
			});

			function page_close() {
				$("#userAdd").submit();
				window.close();
			}
		/*	function showMenus() {
				$("#selectMenu").append("aaaa");
/!*
				window.open("${pageContext.request.contextPath}/pages/system/menu/menuList.jsp","target_parent", 'top=100,left=200,width=400,height=500,menubar=no,location=no,toolbar=no');
*!/

			}*/
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
