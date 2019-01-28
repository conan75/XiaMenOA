<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>课表管理页面</title>
    <style>
        #periodDiv-first{
            float: right;
            margin-right: 50px;
        }
        #periodBut-first{
            height: 50px;
        }
        .clear{
            clear:both;
        }

    </style>
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
                <div>
                    <ol class="breadcrumb">
                        <li><a href="#">课程表管理</a></li>
                        <li class="active">课程表信息</li>
                    </ol>
                    <hr>
                    <div id="periodDiv-first">
                        <button id="courseBut-add" class="btn btn-primary course_add_btn" data-toggle="modal" data-target=".course-add-modal">添加课程表信息</button>
                        <button id="courseBut-importModel" class="btn btn-primary course_importModel_btn" data-toggle="modal" data-target=".course-importModel-modal">导入课程表模板</button>
                    </div>
                    <div class="clear"></div>
                </div>
                <hr>
                <!-- Table进行课表信息的展示 -->
                <%--<table class="table table-bordered table-hover" id="emp_table">
                    <thead>
                        <th>阶段编号</th>
                        <th>阶段名称</th>
                        <th>是否可用</th>
                        <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${periods.list}" var="period" varStatus="status">
                            <tr>
                                <td>${period.periodId}</td>
                                <td>${period.periodName}</td>
                                <td>${period.usableFlag==0?"可用":"不可用"}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary period_edit_btn" value="${period.periodId}" data-toggle="modal" data-target=".period-update-modal">编辑</a>
                                    <c:if test="${period.usableFlag==0}">
                                        <a href="#" role="button" class="btn btn-danger period_delete_btn"  onclick="period_delete('${period.periodId}','${period.usableFlag}')">停用</a>
                                    </c:if>
                                    <c:if test="${period.usableFlag!=0}">
                                        <a href="#" role="button" class="btn btn-primary period_delete_btn" onclick="period_delete('${period.periodId}','${period.usableFlag}')">启用</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>--%>
            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <%--<div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${periods.pageNum} 页.总共 ${periods.pages} 页.一共 ${periods.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">

                            <li><a href="/period/findByPage.do">首页</a></li>

                            <!--上一页-->
                            <li>
                                <c:if test="${periods.hasPreviousPage}">
                                    <a href="/period/findByPage.do?pn=${periods.pageNum-1}" aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </c:if>
                            </li>

                            <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                            <c:forEach items="${periods.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == periods.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != periods.pageNum}">
                                    <li><a href="/period/findByPage.do?pn=${page_num}">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${periods.hasNextPage}">
                                    <a href="/period/findByPage.do?pn=${periods.pageNum+1}"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>

                            <li><a href="/period/findByPage.do?pn=${periods.pages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>--%>
        </div><!-- /.emp_info -->


        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_body -->


</div><!-- /.container -->
<%--<%@ include file="bugMsgAdd.jsp"%>--%>
<%@ include file="courseAdd.jsp"%>
<%--<%@ include file="courseUpdate.jsp"%>--%>


<script>

    <!-- ==========================课表删除操作=================================== -->
    function period_delete(periodId,num) {
        var curPageNo = ${periods.pageNum};
        var flag;
        if(num==0){
            flag=confirm("确定停用该记录吗?")
        }else{
            flag=confirm("确定启用该记录吗?")
        }
        if (flag){
            $.ajax({
                url:"/period/del.do?bid="+periodId,
                type:"GET",
                success:function (result) {
                    if (result!=-1){

                        if(result==0){
                            alert("启用成功!");
                        }else{
                            alert("停用成功!")
                        }
                        window.location.href = "/period/findByPage.do?pn="+curPageNo;
                    }else {
                        alert("请确保异常信息列表中不包含该阶段信息!");
                    }
                }
            });
        }
    };


</script>
</body>
</html>
