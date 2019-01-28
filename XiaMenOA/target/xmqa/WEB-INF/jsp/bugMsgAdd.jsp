<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>异常管理页面</title>
    <style>
        .span_add{
            color: red;
        }
    </style>
</head>
<body>
<div class="modal fade bugMsg-add-modal" tabindex="-1" role="dialog" aria-labelledby="bugMsg-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">添加异常</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal bugMsg-add_form" enctype="multipart/form-data">

                    <div class="form-group">
                        <label for="periodName_add" class="col-sm-2 control-label">阶段名称</label>
                        <div class="col-sm-8">
                            <select id="periodName_add" class="form-control" name="periodId">
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="exceptionDesc_add" class="col-sm-2 control-label">异常描述</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" rows="3" name="exceptionDesc" id="exceptionDesc_add"></textarea>
                            <span id="span1_add" class="span_add"></span>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="exceptionReason_add" class="col-sm-2 control-label">异常原因</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" rows="10" name="exceptionReason" id="exceptionReason_add"></textarea>
                            <span id="span2_add" class="span_add"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="relatePic" class="col-sm-2 control-label">异常截图</label>
                        <div class="col-sm-8">
                            <input type="file" id="file" />
                            <input type="button" onclick="uploadFile()" value="上传"/>
                            <input type="hidden" name="relatePic" id="relatePic">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="resolveWay_add" class="col-sm-2 control-label">处理方式</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" rows="10" name="resolveWay" id="resolveWay_add"></textarea>
                            <span id="span3_add" class="span_add"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary bugMsg_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
    <!-- ==========================部门新增操作=================================== -->
    // 为简单操作，省去了输入名称的验证、错误信息提示等操作
    //1 点击部门新增按钮，弹出模态框；
    //2 输入新增部门信息，点击保存按钮，发送AJAX请求到后台进行保存；
    //3 保存成功跳转最后一页
    // $(".dept_add_btn").click(function () {
    //     $('.dept-add-modal').modal({
    //         backdrop:static,
    //         keyboard:true
    //     });
    //
    // });

    function uploadFile() {
        var path = $("#file").val();
        if (path.length == 0) {
            //未选择图片时进行拦截
            alert("请选择要上传的图片文件!");
            return false;
        } else {
            //选择错误图片格式时进行拦截
            var extStart = path.lastIndexOf('.'),
                ext = path.substring(extStart, path.length).toUpperCase();
            if (ext !== '.PNG' && ext !== '.JPG' && ext !== '.JPEG' && ext !== '.GIF') {
                alert("请选择正确格式的图片文件!");
                return false;
            }
        }
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


    var curPageNo = ${bugMsgs.pageNum};

    $(".bugMsg_save_btn").click(function () {
        $("#span1_add").empty();
        $("#span2_add").empty();
        $("#span3_add").empty();
        var exceptionDesc_add = $.trim($("#exceptionDesc_add").val());
        var exceptionReason_add =$.trim($("#exceptionReason_add").val());
        var resolveWay_add = $.trim($("#resolveWay_add").val());
        //验证

        if(exceptionDesc_add.length==0){
            $("#span1_add").append("异常输入不能为空!");
            return false;
        }else{
            $("#span1_add").empty();
        }
        if(exceptionReason_add.length==0){
            $("#span2_add").append("异常原因不能为空!");
            return false;
        }else{
            $("#span2_add").empty();
        }
        if(resolveWay_add.length==0){
            $("#span3_add").append("处理方式不能为空!");
            return false;
        }else{
            $("#span3_add").empty();
        }

        $.ajax({
            url: "/bug/savebugMsg.do",
            type: "POST",
            data: $(".bugMsg-add_form").serialize(),
            success: function (result) {
                if (result) {
                    alert("新增成功！");
                    // window.location.href = "/bug/findByPage.do?pn=" + curPageNo;
                    window.location.href = "/bug/findByPage.do";
                } else {
                    alert("新增失败!");
                }
            }

        });


    });


    $(".bugMsg_add_btn").click(function () {
        $("#periodName_add").empty();
        $.ajax({
            url: "/period/findList.do",
            type: "GET",
            async: false,
            success: function (result) {
                $.each(result, function (i, n) {
                    $("#periodName_add").append("<option value='" + n.periodId + "'>" + n.periodName + "</option>")
                })
            }
        });
    });


</script>
</body>
</html>
