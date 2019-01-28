<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
    <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">课程管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_emp">
                <li role="presentation"><a href="#" class="course_info">课程表管理</a></li>
                <li role="presentation"><a href="#" class="period_info">课程阶段管理</a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">辅导管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation"><a href="#" class="bugMsg_info">异常信息管理</a></li>
                <%--<li role="presentation"><a href="#" class="bugMsg_add_btn" data-toggle="modal" data-target=".bugMsg-add-modal">添加异常</a></li>--%>
                <%--<li role="presentation"><a href="#" class="bugMsg_clearall_btn">待开发</a></li>--%>
            </ul>
        </li>
    </ul>
    <input type="hidden" id="loginUser" value="<sec:authentication property="principal.username"/>" >
</div><!-- /.panel-group，#hrms_sidebar_left -->

<script type="text/javascript">
    //跳转到课程阶段列表页面
    $(".period_info").click(function () {

        if($("#loginUser").val()!="zhangsan"){
            alert("权限不足")
        }else{
            $(this).attr("href", "/period/findByPage.do");
        }
    });
    //跳转到课程表列表页面
    $(".course_info").click(function () {
        $(this).attr("href", "/course/findByPage.do");
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
