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

<div class="modal fade asset-type-modal" tabindex="-1" role="dialog" aria-labelledby="asset-type-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">初始化资产类别</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal asset-type-form" id="asset-type-form" enctype = 'multipart/form-data'>
                    <div class="form-group">
                        <label for="asset-typeImport" class="col-sm-2 control-label">导入文件</label>
                        <div class="col-sm-8">
                            <input type="file" name="excelFile" class="form-control" id="asset-typeImport">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary assetType_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade asset-fixed-modal" tabindex="-1" role="dialog" aria-labelledby="asset-fixed-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">导入固定资产</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal asset-fixed_form" id="asset-fixed_form" enctype = 'multipart/form-data'>
                    <div class="form-group">
                        <label for="asset-fixedImport" class="col-sm-2 control-label">导入文件</label>
                        <div class="col-sm-8">
                            <input type="file" name="excelFile" class="form-control" id="asset-fixedImport">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary fixedAsset_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade asset-lowValue-modal" tabindex="-1" role="dialog" aria-labelledby="asset-lowValue-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">导入低值资产</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal asset-low_form" id="asset-low_form" enctype = 'multipart/form-data'>
                    <div class="form-group">
                        <label for="asset-lowImport" class="col-sm-2 control-label">导入文件</label>
                        <div class="col-sm-8">
                            <input type="file" name="excelFile" class="form-control" id="asset-lowImport">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary lowAsset_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<script type="text/javascript">

    $(".assetType_save_btn").click(function () {

        var path = $("#asset-typeImport").val();

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

        var form=new FormData(document.getElementById("asset-type-form"));//拿到表单对象
        $.ajax({
            url:"/asset/assetTypeImport.do",
            type : "POST",//提交方式
            cache: false,    //上传文件不需缓存
            data:form,
            processData:false,//需设置为false，因为data值是FormData对象，不需要对数据做处理
            contentType:false,//需设置为false，因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
            success: function (result) {
                if (result) {
                    alert("资产类别初始化成功！");
                } else {
                    alert("资产类别初始化失败!");
                }
            }
        });
    });

        $(".fixedAsset_save_btn").click(function () {

            var path = $("#asset-fixedImport").val();

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

            var form=new FormData(document.getElementById("asset-fixed_form"));//拿到表单对象
            $.ajax({
                url:"/asset/fixedAssetImport.do",
                type : "POST",//提交方式
                cache: false,    //上传文件不需缓存
                data:form,
                processData:false,//需设置为false，因为data值是FormData对象，不需要对数据做处理
                contentType:false,//需设置为false，因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
                success: function (result) {
                    if (result) {
                        alert("模板导入成功！");
                        window.location.href = "/asset/findByPage.do";
                    } else {
                        alert("模板导入失败!");
                    }
                }
            });
        });

    <!-------------------------------------导入低值资产操作-------------------------------------->

    $(".lowAsset_save_btn").click(function () {

        var path = $("#asset-lowImport").val();

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

        var form=new FormData(document.getElementById("asset-low_form"));//拿到表单对象
        $.ajax({
            url:"/asset/lowAssetImport.do",
            type : "POST",//提交方式
            cache: false,    //上传文件不需缓存
            data:form,
            processData:false,//需设置为false，因为data值是FormData对象，不需要对数据做处理
            contentType:false,//需设置为false，因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
            success: function (result) {
                if (result) {
                    alert("模板导入成功！");
                    window.location.href = "/asset/findByPage.do";
                } else {
                    alert("模板导入失败!");
                }
            }
        });
    });






</script>
</body>
</html>
