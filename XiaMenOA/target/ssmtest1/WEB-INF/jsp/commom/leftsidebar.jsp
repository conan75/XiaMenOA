<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
    <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">课程阶段</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_emp">
                <li role="presentation"><a href="#" class="period_info">阶段列表</a></li>
                <li role="presentation"><a href="#" role="button" class="period_add_btn" data-toggle="modal" data-target=".period-add-modal">添加阶段</a></li>
                <%--<li role="presentation"><a href="#" class="emp_clearall_btn">阶段修改</a></li>--%>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">异常管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation"><a href="#" class="bugMsg_info">异常信息</a></li>
                <li role="presentation"><a href="#" class="bugMsg_add_btn" data-toggle="modal" data-target=".bugMsg-add-modal">添加异常</a></li>
                <%--<li role="presentation"><a href="#" class="bugMsg_clearall_btn">待开发</a></li>--%>
            </ul>
        </li>
    </ul>
    <%--<%@ include file="../periodAdd.jsp"%>--%>
    <%--<%@ include file="../bugMsgAdd.jsp"%>--%>
</div><!-- /.panel-group，#hrms_sidebar_left -->

<script type="text/javascript">
    //跳转到阶段列表页面
    $(".period_info").click(function () {
        $(this).attr("href", "/period/findByPage.do");
    });
    //跳转到Bug集信息页面
    $(".bugMsg_info").click(function () {
        $(this).attr("href", "/bug/findByPage.do");
    });
    //员工清零这个功能暂未实现
    $(".emp_clearall_btn").click(function () {
        alert("对不起，您暂无权限进行操作！请先获取权限");
    });
    //部门清零这个功能暂未实现
    $(".bugMsg_clearall_btn").click(function () {
        alert("对不起，您暂无权限进行操作！请先获取权限");
    });
</script>
</body>
</html>
