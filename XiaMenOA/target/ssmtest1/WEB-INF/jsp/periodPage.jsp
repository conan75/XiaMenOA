<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>阶段管理页面</title>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>

    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>

        <!-- 中间员工表格信息展示内容 -->
        <div class="emp_info col-sm-10">

            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="#">阶段管理</a></li>
                        <li class="active">阶段信息</li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="emp_table">
                    <thead>
                        <th>阶段编号</th>
                        <th>阶段名称</th>
                        <th>是否可用</th>
                        <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${periods.list}" var="period">
                            <tr>
                                <td>${period.periodId}</td>
                                <td>${period.periodName}</td>
                                <td>${period.usableFlag==0?"可用":"不可用"}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary period_edit_btn" value="${period.periodId}" data-toggle="modal" data-target=".period-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger period_edit_btn" value="${period.periodId}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <!--显示分页信息-->
                <div class="row">
                    <!--文字信息-->
                    <div class="col-md-6">
                        当前第 ${bugMsgs.pageNum} 页.总共 ${bugMsgs.pages} 页.一共 ${bugMsgs.total} 条记录
                    </div>

                    <!--点击分页-->
                    <div class="col-md-6">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">

                                <li><a href="${pageContext.request.contextPath}/bug/findByPage.do">首页</a></li>

                                <!--上一页-->
                                <li>
                                    <c:if test="${bugMsgs.hasPreviousPage}">
                                        <a href="${pageContext.request.contextPath}/bug/findByPage.do?pn=${bugMsgs.pageNum-1}" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                    </c:if>
                                </li>

                                <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                                <c:forEach items="${bugMsgs.navigatepageNums}" var="page_num">
                                    <c:if test="${page_num == bugMsgs.pageNum}">
                                        <li class="active"><a href="#">${page_num}</a></li>
                                    </c:if>
                                    <c:if test="${page_num != bugMsgs.pageNum}">
                                        <li><a href="${pageContext.request.contextPath}/bug/findByPage.do?pn=${page_num}">${page_num}</a></li>
                                    </c:if>
                                </c:forEach>

                                <!--下一页-->
                                <li>
                                    <c:if test="${bugMsgs.hasNextPage}">
                                        <a href="${pageContext.request.contextPath}/bug/findByPage.do?pn=${bugMsgs.pageNum+1}"
                                           aria-label="Next">
                                            <span aria-hidden="true">»</span>
                                        </a>
                                    </c:if>
                                </li>

                                <li><a href="${pageContext.request.contextPath}/bug/findByPage.do?pn=${bugMsgs.pages}">尾页</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>

            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->

        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_body -->
</div><!-- /.container -->

<%@ include file="periodAdd.jsp"%>
<%@ include file="periodUpdate.jsp"%>


<script>

    <!-- ==========================员工删除操作=================================== -->
    $(".emp_delete_btn").click(function () {
        var curPage = ${periods.pageNum};
        var delEmpId = $(this).parent().parent().find("td:eq(0)").text();
        var delEmpName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认删除【" + delEmpName+ "】的信息吗？")){
            $.ajax({
                url:"/hrms/emp/deleteEmp/"+delEmpId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href="/hrms/emp/getEmpList?pageNo="+curPage;
                    }else {
                        alert(result.extendInfo.emp_del_error);
                    }
                }
            });
        }
    });


</script>
</body>
</html>
