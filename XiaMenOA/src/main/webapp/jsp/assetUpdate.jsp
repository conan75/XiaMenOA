<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Update Page</title>
</head>
<body>
<div class="modal fade assetMsg-update-modal" tabindex="-1" role="dialog" aria-labelledby="assetMsg-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">资产编辑</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal asset-update-form" id="asset-update-form">
                    <div class="form-group">
                        <label for="assetCode_update" class="col-sm-2 control-label">资产编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="assetCode" class="form-control" id="assetCode_update" value="${assetEdit.assetCode}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="serialNum_update" class="col-sm-2 control-label">流水号</label>
                        <div class="col-sm-8">
                            <input type="text" name="serialNum" class="form-control" id="serialNum_update">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="typeFirstName_update" class="col-sm-2 control-label">一级资产类别</label>
                        <div class="col-sm-8">
                            <select id="typeFirstName_update" class="form-control" onchange="findSecondType()">
                                <option value="-1">-请选择-</option>
                                <option value="固定资产">固定资产</option>
                                <option value="低值资产">低值资产</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" id="typeSecondName_update_div" style="display: none">
                        <input hidden id="secondList">
                        <input hidden id="typeName_update" name="typeName">
                        <label for="typeSecondName_update" class="col-sm-2 control-label">二级资产类别</label>
                        <div class="col-sm-8">
                            <select id="typeSecondName_update" class="form-control" name="typeId" onchange="findThirdType()"></select>
                        </div>
                    </div>

                    <div class="form-group" id="typeThirdName_update_div" style="display: none">
                        <label for="typeThirdName_update" class="col-sm-2 control-label">三级资产类别</label>
                        <div class="col-sm-8">
                            <select id="typeThirdName_update" class="form-control" name="assetName"></select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="modelNum_update" class="col-sm-2 control-label">规格型号</label>
                        <div class="col-sm-8">
                            <input type="text" name="modelNum" class="form-control" id="modelNum_update">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="purchaseDate_update" class="col-sm-2 control-label">购置日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="purchaseDate" class="form-control" id="purchaseDate_update">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="remarks_update" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-8">
                            <input type="text" name="remarks" class="form-control" id="remarks_update">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="useDepartment_update" class="col-sm-2 control-label">使用部门</label>
                        <div class="col-sm-4">
                            <select id="useDepartment_update" class="form-control" name="useDepartment">
                                <option value="厦门校区人事行政部" >厦门校区人事行政部</option>
                                <option value="厦门校区校办" >厦门校区校办</option>
                                <option value="厦门校区财务部" >厦门校区财务部</option>
                                <option value="厦门校区咨询部" >厦门校区咨询部</option>
                                <option value="厦门校区学工部" >厦门校区学工部</option>
                                <option value="厦门校区就业服务部JavaEE组" >厦门校区就业服务部JavaEE组</option>
                                <option value="厦门校区就业服务部" >厦门校区就业服务部</option>
                                <option value="厦门校区教研部JavaEE组">厦门校区教研部JavaEE组</option>
                            </select>
                        </div>
                        <label for="usePerson_update" class="col-sm-2 control-label">使用人</label>
                        <div class="col-sm-4">
                            <input type="text" name="usePerson" class="form-control" id="usePerson_update">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="useStatus_update" class="col-sm-2 control-label">使用状态</label>
                        <div class="col-sm-4">
                            <select id="useStatus_update" class="form-control" name="useStatus">
                                <option value="0" >未使用</option>
                                <option value="1" >已使用</option>
                            </select>
                        </div>
                        <label for="depositPlace_update" class="col-sm-2 control-label">存放地点</label>
                        <div class="col-sm-4">
                            <input type="text" name="depositPlace" class="form-control" id="depositPlace_update">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="unit_update" class="col-sm-2 control-label">计量单位</label>
                        <div class="col-sm-2">
                            <input type="text" name="unit" class="form-control" id="unit_update">
                        </div>
                        <label for="purchaseNumber_update" class="col-sm-2 control-label">数量</label>
                        <div class="col-sm-2">
                            <input type="text" name="purchaseNumber" class="form-control" id="purchaseNumber_update">
                        </div>
                        <label for="price_update" class="col-sm-2 control-label">单价</label>
                        <div class="col-sm-2">
                            <input type="text" name="price" class="form-control" id="price_update">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary asset_update_btn">保存</button>
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
