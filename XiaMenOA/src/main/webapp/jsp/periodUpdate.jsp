<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Update Page</title>
</head>
<body>
<div class="modal fade period-update-modal" tabindex="-1" role="dialog" aria-labelledby="period-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">阶段更改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_period_form">
                    <div class="form-group">
                        <label  for="update_periodName" class="col-sm-2 control-label">阶段名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="periodName" class="form-control" id="update_periodName">
                            <input type="hidden" name="periodId" class="form-control" id="update_periodId">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary period_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<script type="text/javascript">
    <!-- ==========================员工修改操作=================================== -->
    var curPageNo = ${periods.pageNum};

    $(".period_edit_btn").click(function () {

        edit_deptId = $(this).attr("value");
        // alert("id" + edit_deptId);
        //查询对应deptId的部门信息
        $.ajax({
            url: "/period/findOne.do?pid=" + edit_deptId,
            async: false,
            type: "GET",
            success: function (result) {
                if (result!= null) {
                    $("#update_periodName").val(result.periodName);
                    $("#update_periodId").val(result.periodId);
                } else {
                    alert("数据出错!");
                }
            }
        });
    });

        $(".period_update_btn").click(function () {
            $.ajax({
                url: "/period/savePeriod.do",
                type: "POST",
                data: $(".update_period_form").serialize(),
                success: function (result) {
                    if (result) {
                        alert("更新成功！");
                        window.location.href = "/period/findByPage.do?pn=" + curPageNo;
                    } else {
                        alert("更新失败!");
                    }
                }

            });
        });
</script>
</body>
</html>
