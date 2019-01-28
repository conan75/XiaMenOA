<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Add Page</title>

    <style>
        .mycalss{
            width: 49%;
        }
    </style>
</head>
<body>
<div class="modal fade course-importModel-modal" tabindex="-1" role="dialog" aria-labelledby="course-importModel-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加模板</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_courseModel_form" id="add_courseModel_form" enctype = 'multipart/form-data'>
                    <div class="form-group">
                        <label for="add_courseModelImport" class="col-sm-2 control-label">导入文件</label>
                        <div class="col-sm-8">
                            <input type="file" name="excelFile" class="form-control" id="add_courseModelImport">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary courseModel_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade course-add-modal" tabindex="-1" role="dialog" aria-labelledby="course-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增课表</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_course_form" id="add_course_form">
                    <div class="form-group">
                        <label for="periodName_add" class="col-sm-2 control-label">阶段名称</label>
                        <div class="col-sm-8" id="periodName_add">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_courseDate" class="col-sm-2 control-label">基础班开班日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="courseDate" class="form-control" id="add_courseDate">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary courseModel_save_btn">保存</button>

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">

    $(".course_add_btn").click(function () {
        $("#periodName_add").empty();
        $.ajax({
            url: "/period/findList.do",
            type: "GET",
            async: false,
            success: function (result) {
                var strs=[];
                $.each(result, function (i, n) {
                    strs.push(n.periodId);
                    $("#periodName_add").append("<input type='text'  value='"+n.periodName+"' disabled>")
                    $("#periodName_add").append("&nbsp;&nbsp;<input type='text'>")
                })
            }
        });
    });

    <!-------------------------------------导入模板操作-------------------------------------->

    $(".courseModel_save_btn").click(function () {

        var path = $("#add_courseModelImport").val();

        if(path.length==0){
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

        var form=new FormData(document.getElementById("add_courseModel_form"));//拿到表单对象
        $.ajax({
            url:"/course/modelImport.do",
            type : "POST",//提交方式
            cache: false,    //上传文件不需缓存
            data:form,
            processData:false,//需设置为false，因为data值是FormData对象，不需要对数据做处理
            contentType:false,//需设置为false，因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
            success: function (result) {
                if (result) {
                    alert("模板导入成功！");
                    window.location.href = "/course/findByPage.do";
                } else {
                    alert("模板导入失败!");
                }
            }
        });
    });



</script>
</body>
</html>
