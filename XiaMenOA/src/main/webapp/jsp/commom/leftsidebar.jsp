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
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#administration">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">行政管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="administration">
                <li role="presentation"><a href="#" class="asset_info">校区资产管理</a></li>
                <li role="presentation"><a href="#" class="material_info">耗材管理</a></li>
                <li role="presentation"><a href="#" class="purchase_info">采购管理</a></li>
                <li role="presentation"><a href="#" class="storage_info">库房管理</a></li>
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

    //跳转到校区资产管理页面
    $(".asset_info").click(function () {

        if($("#loginUser").val()!="zhangsan"){
            alert("权限不足")
        }else{
            $(this).attr("href", "/jsp/assetPage.jsp");
        }
    });

    //跳转到校区耗材管理页面
    $(".material_info").click(function () {

        if($("#loginUser").val()!="zhangsan"){
            alert("权限不足")
        }else{
            alert("努力开发中...")
            // $(this).attr("href", "/period/findByPage.do");
        }
    });

    //跳转到校区采购管理页面
    $(".purchase_info").click(function () {

        if($("#loginUser").val()!="zhangsan"){
            alert("权限不足")
        }else{
            alert("努力开发中...")
            // $(this).attr("href", "/period/findByPage.do");
        }
    });

    //跳转到校区库房管理页面
    $(".storage_info").click(function () {

        if($("#loginUser").val()!="zhangsan"){
            alert("权限不足")
        }else{
            alert("努力开发中...")
            // $(this).attr("href", "/period/findByPage.do");
        }
    });

</script>
</body>
</html>
