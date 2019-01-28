<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bug信息更改页面</title>
</head>
<body>
<div class="modal fade bugMsg-update-modal" tabindex="-1" role="dialog" aria-labelledby="bugMsg-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Bug信息更改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_bugMsg_form">
                    <div class="form-group">
                        <label for="periodName" class="col-sm-2 control-label">阶段名称</label>
                        <div class="col-sm-8">
                            <select id="periodName" class="form-control" name="periodId">
                                <option>-请选择-</option>
                            </select>

                            <%--<input type="text"  class="form-control" id="periodName">--%>
                            <%--<input type="hidden" name="periodId" id="periodId">--%>
                            <input type="hidden" name="messageId" id="messageId">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exceptionDesc" class="col-sm-2 control-label">异常描述</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" name="exceptionDesc" id="exceptionDesc"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exceptionReason" class="col-sm-2 control-label">异常原因</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" name="exceptionReason" id="exceptionReason"></textarea>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="relatePic_upd" class="col-sm-2 control-label">异常截图</label>
                        <div class="col-sm-8">
                            <input type="file" />
                            <input type="button" onclick="uploadFile_upd()" value="上传"/>
                            <input type="hidden" name="relatePic" id="relatePic_upd">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="resolveWay" class="col-sm-2 control-label">处理方式</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" name="resolveWay" id="resolveWay"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary bugMsg_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">
    function uploadFile_upd() {
        var formData=new FormData();
        formData.append("file",file.files[0]);
        $.ajax({
            type:'POST',
            url:"/upload.do",
            data: formData,
            contentType:false,
            processData:false,
            success: function (result) {
                if(result.success){//如果上传成功，取出url
                    alert("上传成功！");
                    $("#relatePic").val(result.message);
                }else{
                    alert(result.message);
                }
            }
        });
    }
    <!-- ==========================bug信息修改操作=================================== -->
    //1 点击编辑按钮，发送AJAX请求查询对应id的部门信息，进行回显；
    //2 进行修改，点击更新按钮发送AJAX请求，将更改后的信息保存到数据库中；
    //3 跳转到当前更改页；
    var edit_deptId = 0;
    var curPageNo = ${bugMsgs.pageNum};
    var periodData;

    $(".bugMsg_edit_btn").click(function () {
        $("#periodName").empty();

        edit_deptId = $(this).attr("value");
        // alert("id" + edit_deptId);
        //查询对应deptId的部门信息
        $.ajax({
            url: "/bug/findOne.do?bid=" + edit_deptId,
            async:false,
            type: "GET",
            success: function (result) {
                if (result.exceptionMsg != null) {
                    var bugMsgData = result.exceptionMsg;
                    periodData = result.period;
                    //回显
                    // $("#periodName").val(periodData.periodName);
                    // $("#periodId").val(periodData.periodId);
                    $("#messageId").val(bugMsgData.messageId);
                    $("#exceptionDesc").val(bugMsgData.exceptionDesc);
                    $("#exceptionReason").val(bugMsgData.exceptionReason);
                    $("#resolveWay").val(bugMsgData.resolveWay);
                } else {
                    alert("数据出错!");
                }
            }
        });



        $.ajax({
            url: "/period/findList.do",
            type: "GET",
            async:false,
            success:function (result) {
                $.each(result,function (i,n) {
                    if(periodData.periodName==n.periodName){
                        $("#periodName").append("<option selected value='"+n.periodId+"'>"+n.periodName+"</option>")
                    }else{
                        $("#periodName").append("<option value='"+n.periodId+"'>"+n.periodName+"</option>")
                    }

                })
            }
        });
    });

    $(".bugMsg_update_btn").click(function () {
        $.ajax({
            url: "/bug/savebugMsg.do",
            type: "POST",
            data: $(".update_bugMsg_form").serialize(),
            success: function (result) {
                if (result) {
                    alert("更新成功！");
                    window.location.href = "/bug/findByPage.do?pn=" + curPageNo;
                } else {
                    alert("更新失败!");
                }
            }

        });
    });


</script>
</body>
</html>
