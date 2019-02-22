<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>行政管理页面</title>
    <script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <link rel="stylesheet" href="../plugins/select2/select2.css" />
    <link rel="stylesheet" href="../plugins/select2/select2-bootstrap.css" />
    <script src="../plugins/select2/select2.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="../plugins/angularjs/angular.min.js"/>
    <script type="text/javascript" src="../js/base_pagination.js"></script>
    <script type="text/javascript" src="../js/angular-select2.js">  </script>
    <script type="text/javascript" src="../js/service/assetService.js"></script>
    <script type="text/javascript" src="../js/controller/baseController.js"></script>
    <script type="text/javascript" src="../js/controller/assetController.js"></script>

    <!-- 分页组件开始 -->
    <script src="../plugins/angularjs/pagination.js"></script>
    <link rel="stylesheet" href="../plugins/angularjs/pagination.css">
    <!-- 分页组件结束 -->
    <style>

        .line-limit-length {
            max-width: 220px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        #assetDiv-first{
            float: right;
            margin-right: 50px;
        }
        #assetBut-first{
            height: 50px;
        }
        .clear{
            clear:both;
        }

    </style>
</head>
<body ng-app="XiaMenOA" ng-controller="assetController">
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>

    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左 侧 栏 -->

        <%@ include file="./commom/leftsidebar.jsp"%>

        <!-- 中间员工表格信息展示内容 -->
        <div class="emp_info col-sm-10">

            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div>
                    <ol class="breadcrumb">
                        <li><a href="#">行政管理</a></li>
                        <li class="active">资产管理</li>
                    </ol>
                    <hr>
                    <div id="assetDiv-first" style="display : none">
                        <button id="assetBut-Type_Asset" class="btn btn-primary asset_type_btn" data-toggle="modal" data-target=".asset-type-modal">初始化资产类别</button>
                        <button id="assetBut-fixed_Asset" class="btn btn-primary asset_fixed_btn" data-toggle="modal" data-target=".asset-fixed-modal">导入固定资产</button>
                        <button id="assetBut-LowValue" class="btn btn-primary asset_lowValue_btn" data-toggle="modal" data-target=".asset-lowValue-modal">导入低值资产</button>
                    </div>
                    <div class="clear"></div>
                    <div>
                        <form action="/asset/search.do" method="post" id="asset-searchForm">
                            <table>
                                <tr>
                                    <th>
                                        <label for="asset_code" class="control-label">资产编号:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="asset_code" class="form-control"
                                               ng-model="searchEntity.assetCode" placeholder="如：XM-CP-002">
                                    </th>
                                    <th>
                                        <label for="asset_name" class="control-label">资产名称:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="asset_name" class="form-control"
                                               ng-model="searchEntity.assetName" placeholder="如:显示器">
                                    </th>
                                    <th>
                                        <label for="useDepartment" class="control-label">使用部门:</label>
                                    </th>
                                    <th>
                                        <select id="useDepartment" class="form-control" ng-model="searchEntity.useDepartment">
                                            <option value="-1">--请选择--</option>
                                            <option value="厦门校区人事行政部" >厦门校区人事行政部</option>
                                            <option value="厦门校区校办">厦门校区校办</option>
                                            <option value="厦门校区财务部">厦门校区财务部</option>
                                            <option value="厦门校区咨询部">厦门校区咨询部</option>
                                            <option value="厦门校区学工部">厦门校区学工部</option>
                                            <option value="厦门校区就业服务部JavaEE组">厦门校区就业服务部JavaEE组</option>
                                            <option value="厦门校区就业服务部">厦门校区就业服务部</option>
                                            <option value="厦门校区教研部JavaEE组">厦门校区教研部JavaEE组</option>
                                        </select>
                                    </th>

                                    <th>
                                        <label for="usePerson" class="control-label">使用人:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="usePerson" class="form-control"
                                               ng-model="searchEntity.usePerson">
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label for="typeName" class="control-label">一级资产类型:</label>
                                    </th>
                                    <th>
                                        <select id="typeName" class="form-control" ng-model="searchEntity.typeName">
                                            <option value="-1">--请选择--</option>
                                            <option value="固定资产">固定资产</option>
                                            <option value="低值资产">低值资产</option>
                                        </select>
                                    </th>
                                    <th>
                                        <label class="control-label">购置时间:</label>
                                    </th>
                                    <th>
                                            <input type="date" id="startDate" class="form-control" ng-model="searchEntity.startDate">
                                    </th>
                                    <th align="center">
                                            至
                                    </th>
                                    <th>
                                            <input type="date" id="endDate" class="form-control" ng-model="searchEntity.endDate">
                                    </th>
                                    <th>
                                        <label for="modelNum" class="control-label">规格型号:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="modelNum" class="form-control" ng-model="searchEntity.modelNum" placeholder="如：i3-710 8G 250G">
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label for="useStatus" class="control-label">使用状态:</label>
                                    </th>
                                    <th>
                                        <select id="useStatus" class="form-control" ng-model="searchEntity.useStatus">
                                            <option value="-1">--请选择--</option>
                                            <option value="0">未使用</option>
                                            <option value="1">已使用</option>
                                        </select>
                                    </th>
                                    <th>
                                        <input type="button" value="查询" ng-click="searchPage(paginationConf.currentPage, paginationConf.itemsPerPage)" class="btn btn-primary form-control">
                                    </th>
                                    <th colspan="4">

                                    </th>
                                    <th style="padding-left: 100px">
                                        <table>
                                            <tr>
                                                <th> <a href="#" role="button" class="btn btn-primary assetMsg_add_btn" data-toggle="modal" ng-click="assetEdit={}" data-target=".assetMsg-add-modal">添加资产</a></th>
                                                <th><input id="asset_change" type="button" value="初始化" class="btn btn-primary form-control" ng-click="showImport()"></th>
                                            </tr>
                                        </table>
                                    </th>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
                <hr>
                <!-- Table进行资产信息的展示 -->
                <table class="table table-bordered table-hover" id="emp_table">
                    <thead>
                        <th>资产编号</th>
                        <th>流水号</th>
                        <th>一级类别名称</th>
                        <th>二级类别名称</th>
                        <th>资产名称</th>
                        <th>规格型号</th>
                        <th>计量单位</th>
                        <th>数量</th>
                        <th>单价</th>
                        <th>金额</th>
                        <th>购置日期</th>
                        <th>使用部门</th>
                        <th>使用人</th>
                        <th>使用状态</th>
                        <th>备注</th>
                        <th>存放地点</th>
                        <th>操作</th>
                    </thead>
                    <tbody>
                            <tr ng-repeat="entity in list">
                                <td>{{entity.asset.assetCode}}</td>
                                <td>{{entity.asset.serialNum}}</td>
                                <td class="line-limit-length">{{entity.assetType.typeName}}</td>
                                <td class="line-limit-length">{{entity.asset.typeName}}</td>
                                <td>{{entity.asset.assetName}}</td>
                                <td>{{entity.asset.modelNum}}</td>
                                <td>{{entity.asset.unit}}</td>
                                <td>{{entity.asset.purchaseNumber}}</td>
                                <td>{{entity.asset.price}}</td>
                                <td>{{entity.asset.totalMoney}}</td>
                                <td class="line-limit-length">{{entity.asset.purchaseDate|date:'yyyy年MM月dd日'}}</td>
                                <td>{{entity.asset.useDepartment}}</td>
                                <td>{{entity.asset.usePerson}}</td>
                                <td>
                                    {{entity.asset.useStatus==0?"未使用":"已使用"}}
                                </td>
                                <td>{{entity.asset.remarks}}</td>
                                <td>{{entity.asset.depositPlace}}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary asset_edit_btn" ng-click="asset_Edit(entity.asset.id)" data-toggle="modal" data-target=".assetMsg-add-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-primary asset_delete_btn"  ng-click="asset_Delete(entity.asset.id,entity.asset.usableFlag)">{{entity.asset.usableFlag==0?"停用":"启用"}}</a>
                                </td>
                            </tr>
                    </tbody>
                </table>
            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <tm-pagination conf="paginationConf"></tm-pagination>
        </div><!-- /.dept_info -->

        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_body -->


</div><!-- /.container -->
<%@ include file="assetAdd.jsp"%>



<script>

    <!-- ==========================资产删除操作=================================== -->
    function asset_delete(id,num) {
        var curPageNo = ${assets.pageNum};
        var flag;
        if(num==0){
            flag=confirm("确定停用该记录吗?")
        }else{
            flag=confirm("确定启用该记录吗?")
        }
        if (flag){
            $.ajax({
                url:"/asset/del.do?bid="+id,
                type:"GET",
                success:function (result) {
                    if (result!=-1){

                        if(result==0){
                            alert("启用成功!");
                        }else{
                            alert("停用成功!")
                        }
                        window.location.href = "/asset/findByPage.do?pn="+curPageNo;
                    }else {
                        alert("请确保异常信息列表中不包含该阶段信息!");
                    }
                }
            });
        }
    };


</script>
</body>
</html>
