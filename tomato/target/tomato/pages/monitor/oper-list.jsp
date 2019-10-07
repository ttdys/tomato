<%--
  Created by IntelliJ IDEA.
  User: zjh
  Date: 2019/10/4
  Time: 10:54
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

                        <h3>操作日志列表</h3>

                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>模块标题</th>
                                    <th>业务类型</th>
                                    <th>方法名称</th>
                                    <th>请求方式</th>
                                     <th>操作类型</th>
                                     <th>操作人员</th>
                                     <th>部门名称</th>
                                     <th>请求url</th>
                                     <th>主机地址</th>
                                     <th>操作地点</th>
                                     <th>请求参数</th>
                                     <th>返回参数</th>
                                     <th>操作状态</th>
                                     <th>操作时间</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="log" varStatus="status">
                                    <tr>
                                        <td>${status.index}</td>
                                        <td>${log.title}</td>
                                        <td>${log.businessType}</td>
                                        <td>${log.method}</td>
                                        <td>${log.requestMethod}</td>
                                        <td>${log.operatorType}</td>
                                        <td>${log.operName }</td>
                                        <td>${log.deptName}</td>
                                        <td>${log.operUrl}</td>
                                        <td>${log.operIp}</td>
                                        <td>${log.operLocation}</td>
                                        <td>${log.operParam}</td>
                                        <td>${log.jsonResult}</td>
                                        <td>${log.status}</td>
                                        <td>${log.operTime}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            <%--    ${pageInfo.pageNum}
                                ${pageInfo.total}
                                ${pageInfo.hasNextPage}是否有下一页
                                ${pageInfo.prePage}上一页
                                ${pageInfo.nextPage} 下一页
                                ${pageInfo.hasPreviousPage} 是否有上一页
                                ${pageInfo.navigateLastPage} 导航栏的最后一页
                                ${pageInfo.navigateFirstPage} 导航栏的第一页
                                ${pageInfo.navigatePages}  导航栏的当前页
                                ${pageInfo.navigatepageNums} 这个是所有的集合 1-8
                                ${pageInfo.isLastPage} 当前页是否是最后一页
                                ${pageInfo.isFirstPage} 当前页是否是第一页--%>

                            </table>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                    共${pageInfo.pages}页,第${pageInfo.pageNum}页 共${pageInfo.total}条
                    <nav aria-label="Page navigation" style="text-align: center">
                        <ul class="pagination">

                            <c:if test="${pageInfo.isFirstPage}">
                            <li><a href="#">首页</a></li>
                            <li>
                                <a href="#" class="disabled" aria-label="Previous">
                                    </c:if>
                                    <c:if test="${pageInfo.pageNum>1}">
                            <li><a href="${pageContext.request.contextPath}/monitor/operlog.do?page=1">首页</a></li>
                            <li>
                                <a href="${pageContext.request.contextPath}/monitor/operlog.do?page=${pageInfo.prePage}" aria-label="Previous">
                                    </c:if>
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>

                            <c:forEach items="${pageInfo.navigatepageNums}" var="num" >
                                <c:if test="${num == pageInfo.pageNum}" >
                                    <li class="active"><a href="#" class="disabled">${num}</a></li>
                                </c:if>
                                <c:if test="${num != pageInfo.pageNum}" >
                                    <li><a href="${pageContext.request.contextPath}/monitor/operlog.do?page=${num}">${num}</a></li>
                                </c:if>

                            </c:forEach>

                            <c:if test="${pageInfo.pageNum>=pageInfo.pages}">
                            <li>  <a href="#" class="disabled" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a> </li>
                            <li><a href="#">尾页</a>
                                </c:if>
                                <c:if test="${pageInfo.pageNum<pageInfo.pages-1}">

                            <li>   <a href="${pageContext.request.contextPath}/monitor/operlog.do?page=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a></li>
                            <li><a href="${pageContext.request.contextPath}/monitor/operlog.do?page=${pageInfo.pages}">尾页</a>
                                </c:if>


                            </li>

                        </ul>
                    </nav>



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

