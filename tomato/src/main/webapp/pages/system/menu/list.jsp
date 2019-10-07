<%--
      Created by IntelliJ IDEA.
      User: zjh
      Date: 2019/10/3
      Time: 21:51
      To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
	<head>
		<title>Title</title>
	</head>
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
	<body>

		<div id="wrapper">

			<!-- Navigation -->
			<%@include file="/pages/main/aside.jsp" %>

			<div id="page-wrapper">

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								菜单列表
	<shiro:hasPermission name="system:menu:add">
		<div align="right" style="width: 80%;">
		<button id="btn" type="button" class="btn btn-info" onclick="show_add()">新建+</button>
		</div>
	</shiro:hasPermission>
							</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover" id="treetable">
										<thead>
											<tr>
												<th></th>
												<th>名称</th>
												<th>链接</th>
												<th>类型</th>
												<th>排序</th>
												<th>权限</th>
												<th>备注</th>
											</tr>
										</thead>
										<tbody>

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
	$(document).ready(function () {
	$('#dataTables-example').DataTable({
	responsive: true
	});
	});

	function show_add() {
	window.open("${pageContext.request.contextPath}/pages/system/menu/add.jsp", "target_parent", 'top=50,left=100,width=800,height=580,menubar=no,location=no,toolbar=no');
	}


	</script>
		<script type="text/javascript">


			var dataTable;
			$(function() {
				dataTable = $('#treetable').DataTable({
					/**
					l - Length changing 改变每页显示多少条数据的控件
					f - Filtering input 即时搜索框控件
					t - The Table 表格本身
					i - Information 表格相关信息控件
					p - Pagination 分页控件
					r - pRocessing 加载等待显示信息
					**/
					"dom": "tr",
					"ordering": false, //禁用排序
					"processing": true,
					"serverSide": true,
					"ajax": {
						"url": "${pageContext.request.contextPath}/system/menu/menuJson.do"
					},
					'treeGrid': {
						'left': 15,
						'expandAll': true, //是否默认展开 true 是
						'expandIcon': '<span class="fa fa-angle-right"> </span>',
						'collapseIcon': '<span class="fa fa-angle-down"> </span>'
					},

					"columns": [{
							className: 'treegrid-control',
							data: function(item) {
								if (item.children.length > 0) {
									return '<span class="fa fa-angle-right"></span>';
								}
								return '';
							}
						},
						{
							"data": "menuName"
						},
						{
							"data": "url"
						},

						{
							data: function(item) {
									/*M目录 C菜单 F按钮*/
									if ("M" == item.menuType) {
									return "目录";
									}
									if ("C"== item.menuType) {
									return "菜单";
									}
									if ("F"== item.menuType) {
									return "按钮";
									}
									return  null;
							}

						},


						{
							data: function(item) {
								var html = '<input name="menuSort" type="text" value="' + item.menuSort + '" class="form-control sorts" style ="width:70px;margin:0;padding:0;text-align:center;" > ';
								html = html + '<input name="menuSortId" type="hidden" value="' + item.menuId + '">';
								return html;
							}
						},



						{
							"data": "perms"
						},
						{
							"data": "remark"
						}

						/* 	{
								data: function(item) {
									if (item.menuStatus == true) {
										return "<button type='button' class='btn btn-primary btn-xs' onclick=\"updateStatus('" + item.menuId +
											"','false');\"><i class='fa fa-refresh'></i> 启用</button>";
									} else {
										return "<button type='button' class='btn btn-danger btn-xs' onclick=\"updateStatus('" + item.menuId +
											"','true');\"><i class='fa fa-refresh'></i> 禁用</button>";
									}
								}
							}, */
						/*{
							data: function(item) {
								var html = "<a onclick=\"edit('" + item.menuId + "');\" class='btn btn-success btn-xs' ><i class='fa
								fa - edit '></i> 编辑</a> ";
								html = html + "<a onclick=\"add('" + item.menuId + "');\" class='btn btn-primary btn-xs' ><i class='fa
								fa - plus '></i> 添加下级菜单</a> ";
								html = html + "<a onclick=\"deleteObject('" + item.menuId +
									"');\" class='btn btn-danger btn-xs' ><i class='fa
								fa - trash - o '></i> 删除</a> ";
								return html;
							}
						}*/
					]
				});
			});
		</script>


	</body>
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../../../static/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="${pageContext.request.contextPath}/static/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/vendor/datatables-responsive/dataTables.responsive.js"></script>
	<script src="${pageContext.request.contextPath}/static/vendor/treegrid/dataTables.treeGrid.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/static/dist/js/sb-admin-2.js"></script>

</html>
