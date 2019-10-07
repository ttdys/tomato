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
						个人信息中心
					</div>

					<div class="panel-body" style="padding-left: 30%;">
						<form id="userAdd" action="${pageContext.request.contextPath}/system/user/add.do" method="post">
							<div class="form-group">
								<label>登录名</label>
								<input name="loginName" class="form-control" style="width: 30%;" value="${sysUser.loginName}"/>
							</div>
							<div class="form-group">
									<label>用户名</label>
									<input name="username" class="form-control" style="width: 30%;" value="${sysUser.username}" />
							</div>
							<div class="form-group" >
									<label>密码</label>
									<input name="password" type="password" class="form-control" style="width: 30%;" value="${sysUser.password}" />
							</div>

								<div class="form-group">
									<label>用户类型</label>
									<input name="userType" class="form-control" style="width: 30%;" value="${sysUser.userType}"/>
								</div>
							<div class="form-group">
								<label>邮箱</label>
								<input name="email" class="form-control" style="width: 30%;" value="${sysUser.email}">
							</div>
							<div class="form-group">
								<label>电话</label>
								<input name="phone" class="form-control" style="width: 30%;" value="${sysUser.phone}">
							</div>

							<div class="form-group">
								<label>性别</label>
								<select class="form-control" name="sex" style="width: 30%;">
									<c:if test="${sysUser.sex == 0}">
										<option value="0" selected="selected">男</option>
										<option value="1">女</option>
									</c:if>
									<c:if test="${sysUser.sex == 1}">
										<option value="0">男</option>
										<option value="1" selected="selected">女</option>
									</c:if>
								</select>
							</div>

							<div class="form-group">
								<label>状态</label>
								<select class="form-control" name="status" style="width: 30%;">
									<c:if test="${sysUser.status == 0}">
										<option value="0" selected="selected">开启</option>
										<option value="1">停用</option>
									</c:if>
									<c:if test="${sysUser.status == 1}">
										<option value="0">开启</option>
										<option value="1" selected="selected">停用</option>
									</c:if>
								</select>
							</div>
							<div class="form-group">
								<label>备注</label>
								<textarea name="remark" class="form-control" rows="3" style="width: 60%;">${sysUser.remark}</textarea>
							</div>
							<button type="submit"  class="btn btn-info">提交</button>
						</form>
					</div>
					
				</div>
			</div>
		</div>
	


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
