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

    <!-------------------------------------员工新增操作-------------------------------------->
    //=======0 点击 员工新增按钮，发送AJAX请求查询部门列表信息，弹出模态框，
    // 将查询得到的部门列表信息显示在对应模态框中部门信息处。=============================

    // //=========1 当鼠标从姓名输入框移开的时候，判断姓名输入框内的姓名是否重复 ============
    // $("#add_inputName").change(function () {
    //     var empName = $("#add_inputName").val();
    //     $.ajax({
    //         url:"/hrms/emp/checkEmpExists",
    //         type:"GET",
    //         data:"empName="+empName,
    //         success:function (result) {
    //             if (result.code == 100){
    //                 $("#add_inputName").parent().parent().removeClass("has-error");
    //                 $("#add_inputName").parent().parent().addClass("has-success");
    //                 $("#helpBlock_add_inputName").text("用户名可用！");
    //                 $(".emp_save_btn").attr("btn_name_exists", "success");
    //             }else {
    //                 $("#add_inputName").parent().parent().removeClass("has-success");
    //                 $("#add_inputName").parent().parent().addClass("has-error");
    //                 $("#helpBlock_add_inputName").text(result.extendInfo.name_reg_error);
    //                 $(".emp_save_btn").attr("btn_name_exists", "error");
    //             }
    //         }
    //     });
    // });

    //3 保存

    var curPageNo = ${periods.pageNum};
    $(".period_save_btn").click(function () {

        //1 获取到第3步：$(".emp_save_btn").attr("btn_name_exists", "success");中btn_name_exists的值
        // btn_name_exists = error，就是姓名重复
        // if($(".emp_save_btn").attr("btn_name_exists") == "error"){
        //     return false;
        // }

        //================2 对输入的姓名和邮箱格式进行验证===============
        // var inputName = $("#add_inputName").val();
        // var inputEmail = $("#add_inputEmail").val();
        // //验证格式。姓名：2-5位中文或6-16位英文和数字组合；
        // var regName = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        // var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        // if (!regName.test(inputName)){
        //     alert("测试：输入姓名格式不正确！");
        //     //输入框变红
        //     $("#add_inputName").parent().parent().addClass("has-error");
        //     //输入框下面显示红色提示信息
        //     $("#helpBlock_add_inputName").text("输入姓名为2-5位中文或6-16位英文和数字组合");
        //     return false;
        // }else {
        //     //移除格式
        //     $("#add_inputName").parent().parent().removeClass("has-error");
        //     $("#add_inputName").parent().parent().addClass("has-success");
        //     $("#helpBlock_add_inputName").hide();
        // }
        // if (!regEmail.test(inputEmail)){
        //     //输入框变红
        //     $("#add_inputEmail").parent().parent().addClass("has-error");
        //     //输入框下面显示红色提示信息
        //     $("#helpBlock_add_inputEmail").text("输入邮箱格式不正确！");
        //     return false;
        // }else {
        //     //移除格式
        //     $("#add_inputEmail").parent().parent().removeClass("has-error");
        //     $("#add_inputName").parent().parent().addClass("has-success");
        //     $("#helpBlock_add_inputEmail").hide();
        // }


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
