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

<div class="modal fade assetMsg-add-modal" tabindex="-1" role="dialog" aria-labelledby="assetMsg-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">资产编辑</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal asset-add-form" id="asset-add-form">
                    <div class="form-group">
                        <label for="assetCode_add" class="col-sm-2 control-label">资产编号</label>
                        <div class="col-sm-8">
                            <input type="hidden" name="id" value="{{assetEdit.asset.id}}">
                            <input type="text" name="assetCode" class="form-control" id="assetCode_add" value="{{assetEdit.asset.assetCode}}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="serialNum_add" class="col-sm-2 control-label">流水号</label>
                        <div class="col-sm-8">
                            <input type="text" name="serialNum" class="form-control" id="serialNum_add" value="{{assetEdit.asset.serialNum}}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="typeFirstName_add" class="col-sm-2 control-label">一级资产类别</label>
                        <div class="col-sm-8">
                            <select id="typeFirstName_add" class="form-control" onchange="findSecondType()" ng-model="assetEdit.assetType.typeName">
                                <option value="-1">-请选择-</option>
                                <option value="固定资产">固定资产</option>
                                <option value="低值资产">低值资产</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" id="typeSecondName_add_div" style="display: none">
                        <input hidden id="secondList">
                        <input hidden id="typeName_add" name="typeName">
                        <label for="typeSecondName_add" class="col-sm-2 control-label" >二级资产类别</label>
                        <div class="col-sm-8">
                            <select id="typeSecondName_add" class="form-control" name="typeId" onchange="findThirdType()"></select>
                        </div>
                    </div>

                    <div class="form-group" id="typeThirdName_add_div" style="display: none">
                        <label for="typeThirdName_add" class="col-sm-2 control-label">三级资产类别</label>
                        <div class="col-sm-8">
                            <select id="typeThirdName_add" class="form-control" name="assetName"></select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="modelNum_add" class="col-sm-2 control-label">规格型号</label>
                        <div class="col-sm-8">
                            <input type="text" name="modelNum" class="form-control" id="modelNum_add" value="{{assetEdit.asset.modelNum}}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="purchaseDate_add" class="col-sm-2 control-label">购置日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="purchaseDate" class="form-control" id="purchaseDate_add" value="{{assetEdit.asset.purchaseDate|date:'yyyy-MM-dd'}}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="remarks_add" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-8">
                            <input type="text" name="remarks" class="form-control" id="remarks_add" value="{{assetEdit.asset.remarks}}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="useDepartment_add" class="col-sm-2 control-label">使用部门</label>
                        <div class="col-sm-4">
                            <select id="useDepartment_add" class="form-control" name="useDepartment" ng-model="assetEdit.asset.useDepartment">
                                <option value="厦门校区人事行政部">厦门校区人事行政部</option>
                                <option value="厦门校区校办">厦门校区校办</option>
                                <option value="厦门校区财务部">厦门校区财务部</option>
                                <option value="厦门校区咨询部">厦门校区咨询部</option>
                                <option value="厦门校区学工部">厦门校区学工部</option>
                                <option value="厦门校区就业服务部JavaEE组">厦门校区就业服务部JavaEE组</option>
                                <option value="厦门校区就业服务部">厦门校区就业服务部</option>
                                <option value="厦门校区教研部JavaEE组">厦门校区教研部JavaEE组</option>
                            </select>
                        </div>
                        <label for="usePerson_add" class="col-sm-2 control-label">使用人</label>
                        <div class="col-sm-4">
                            <input type="text" name="usePerson" class="form-control" id="usePerson_add" value="{{assetEdit.asset.usePerson}}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="useStatus_add" class="col-sm-2 control-label">使用状态</label>
                        <div class="col-sm-4">
                            <select id="useStatus_add" class="form-control" name="useStatus" ng-model="assetEdit.asset.useStatus">
                                <option value="0" >未使用</option>
                                <option value="1" >已使用</option>
                            </select>
                        </div>
                        <label for="depositPlace_add" class="col-sm-2 control-label">存放地点</label>
                        <div class="col-sm-4">
                            <input type="text" name="depositPlace" class="form-control" id="depositPlace_add" value="{{assetEdit.asset.depositPlace}}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="unit_add" class="col-sm-2 control-label">计量单位</label>
                        <div class="col-sm-2">
                            <input type="text" name="unit" class="form-control" id="unit_add" value="{{assetEdit.asset.unit}}">
                        </div>
                        <label for="purchaseNumber_add" class="col-sm-2 control-label">数量</label>
                        <div class="col-sm-2">
                            <input type="text" name="purchaseNumber" class="form-control" id="purchaseNumber_add" value="{{assetEdit.asset.purchaseNumber}}">
                        </div>
                        <label for="price_add" class="col-sm-2 control-label">单价</label>
                        <div class="col-sm-2">
                            <input type="text" name="price" class="form-control" id="price_add" value="{{assetEdit.asset.price}}">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary asset_add_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<script type="text/javascript">
    /**
     *清空上次添加的记录
     */
    $(".assetMsg_add_btn").click(function () {

        $("#typeFirstName_add").empty();
        $("#typeFirstName_add").append('<option value="-1">-请选择-</option><option value="固定资产">固定资产</option><option value="低值资产">低值资产</option>');
        $("#typeSecondName_add").empty();
        document.getElementById("typeSecondName_add_div").style.display ="none";
        $("#typeThirdName_add").empty();
        document.getElementById("typeThirdName_add_div").style.display ="none";
    })

    /**
     * 查找资产二级列表
     */
    function findSecondType() {
        var typeName = $("#typeFirstName_add option:selected").val();
        $("#typeSecondName_add").empty();
        if(typeName==-1){
            document.getElementById("typeSecondName_add_div").style.display ="none";
            $("#typeThirdName_add").empty();
            document.getElementById("typeThirdName_add_div").style.display ="none";
            return;
        }
        $.ajax({
            url: "/asset/findSecondType.do",
            async:false,
            type: "POST",
            data:{"typeName":typeName},
            success: function (result) {
                if (result!= null) {
                    $("#typeSecondName_add").append('<option value="-1">-请选择-</option>');
                    document.getElementById("typeSecondName_add_div").style.display ="";
                    $("#secondList").val(JSON.stringify(result));
                    $.each(result,function(i,n){
                        $("#typeSecondName_add").append('<option value="'+n.typeId+'">'+n.typeName+'</option>');
                    })
                } else {
                    alert("数据出错!");
                }
            }
        });
    }

    /**
     * 查找资产三级列表
     */
    function findThirdType() {
        var secondList = $("#secondList").val();
        var secondTypeName = $("#typeSecondName_add option:selected").val();
        $("#typeThirdName_add").empty();
        if(secondTypeName==-1){
            document.getElementById("typeThirdName_add_div").style.display ="none";
            return;
        }
        $("#typeName_add").val($("#typeSecondName_add option:selected").text());
        $("#typeThirdName_add").empty();
        $.ajax({
            url: "/asset/findThirdType.do",
            async:false,
            type: "POST",
            data:{"secondList":secondList,"secondTypeName":secondTypeName},
            success: function (result) {
                if (result!= null) {
                    document.getElementById("typeThirdName_add_div").style.display ="";
                    $("#typeThirdName_add").append('<option value="-1">-请选择-</option>');
                    $.each(result,function(i,n){
                        $("#typeThirdName_add").append('<option value="'+n.typeName+'">'+n.typeName+'</option>');
                    })
                } else {
                    alert("数据出错!");
                }
            }
        });
    }

    /**
     * 新增资产
     */
    $(".asset_add_btn").click(function () {
        var form=new FormData(document.getElementById("asset-add-form"));//拿到表单对象
        $.ajax({
            url:"/asset/assetAdd.do",
            type : "POST",//提交方式
            cache: false,    //上传文件不需缓存
            data:form,
            processData:false,//需设置为false，因为data值是FormData对象，不需要对数据做处理
            contentType:false,//需设置为false，因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
            success: function (result) {
                if (result) {
                    alert("保存成功！");
                    $('.assetMsg-add-modal').modal('hide')
                    $scope.reloadList();
                } else {
                    alert("新增失败!");
                }
            }
        });
    });

    /**
     * 初始化资产类型
     */
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

    /**
     * 初始化固定资产
     */
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

    /**
     * 初始化低值资产
     */
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
