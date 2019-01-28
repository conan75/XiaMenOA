<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Add Page</title>
</head>
<body>
<div class="modal fade period-add-modal" tabindex="-1" role="dialog" aria-labelledby="period-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加阶段</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_period_form" id="myForm" enctype = 'multipart/form-data'>
                    <div class="form-group">
                        <label for="add_inputName" class="col-sm-2 control-label">阶段名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="periodName" class="form-control" id="add_inputName" placeholder="如：数据库">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_inputUsableFlag" class="col-sm-2 control-label">是否可用</label>
                        <div class="col-sm-8">
                            <select id="add_inputUsableFlag" class="form-control" name="usableFlag">
                                <option value="0">可用</option>
                                <option value="1">不可用</option>
                            </select>

                        </div>
                    </div>
                    <hr/>
                    <div class="form-group">
                        <label for="add_fileImport" class="col-sm-2 control-label">导入文件</label>
                        <div class="col-sm-8">
                                <input type="file" name="excelFile" class="form-control" id="add_fileImport">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary period_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">

    <!-------------------------------------阶段新增操作-------------------------------------->

    var curPageNo = ${periods.pageNum};
    $(".period_save_btn").click(function () {

        var path = $("#add_fileImport").val();
        var add_inputName = $.trim($("#add_inputName").val());

        if(path.length==0&&add_inputName.length==0){
            alert("新增失败!")
            return false;
        }

        //选择错误图片格式时进行拦截
        var extStart = path.lastIndexOf('.'),
            ext = path.substring(extStart, path.length).toUpperCase();
        if(path.length!=0){
            if (ext !== '.XLS' && ext !== '.XLSX') {
                alert("请选择正确格式的文件!");
                return false;
            }
        }

        var form=new FormData(document.getElementById("myForm"));//拿到表单对象
        $.ajax({
            url:"/period/addPeriod.do",
            type : "POST",//提交方式
            cache: false,    //上传文件不需缓存
            data:form,
            processData:false,//需设置为false，因为data值是FormData对象，不需要对数据做处理
            contentType:false,//需设置为false，因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
            success: function (result) {
                if (result) {
                    alert("新增成功！");
                    window.location.href = "/period/findByPage.do?pn=" + curPageNo;
                } else {
                    alert("新增失败!");
                }
            }
        });
    });



</script>
</body>
</html>
