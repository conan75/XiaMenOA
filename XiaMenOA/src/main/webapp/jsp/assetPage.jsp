<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>课表管理页面</title>
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
<body>
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
                                               name="assetCode" value="${assetSearch.assetCode}" placeholder="如：XM-CP-002">
                                    </th>
                                    <th>
                                        <label for="asset_name" class="control-label">资产名称:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="asset_name" class="form-control"
                                               name="assetName" value="${assetSearch.assetName}" placeholder="如:显示器">
                                    </th>
                                    <th>
                                        <label for="useDepartment" class="control-label">使用部门:</label>
                                    </th>
                                    <th>
                                        <select id="useDepartment" class="form-control" name="useDepartment">
                                            <option value="-1">--请选择--</option>
                                            <option value="人事行政部" <c:if test="${assetSearch.useDepartment=='人事行政部'}">selected</c:if>>人事行政部</option>
                                        </select>
                                    </th>

                                    <th>
                                        <label for="usePerson" class="control-label">使用人:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="usePerson" class="form-control"
                                               name="usePerson" value="${assetSearch.usePerson}">
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label for="typeName" class="control-label">一级资产类型:</label>
                                    </th>
                                    <th>
                                        <select id="typeName" class="form-control" name="typeName">
                                            <option value="-1">--请选择--</option>
                                            <option value="固定资产" <c:if test="${assetSearch.typeName=='固定资产'}">selected</c:if>>固定资产</option>
                                            <option value="低值资产" <c:if test="${assetSearch.typeName=='低值资产'}">selected</c:if>>低值资产</option>
                                        </select>
                                    </th>
                                    <th>
                                        <label class="control-label">购置时间:</label>
                                    </th>
                                    <th>
                                            <input type="date" id="startDate" class="form-control"
                                                   name="startDate" value="${assetSearch.startDate}">
                                    </th>
                                    <th align="center">
                                            至
                                    </th>
                                    <th>
                                            <input type="date" id="endDate" class="form-control"
                                                   name="startDate" value="${assetSearch.endDate}">
                                    </th>
                                    <th>
                                        <label for="modelNum" class="control-label">规格型号:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="modelNum" class="form-control"
                                               name="modelNum" value="${assetSearch.modelNum}" placeholder="如：i3-710 8G 250G">
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label for="useStatus" class="control-label">使用状态:</label>
                                    </th>
                                    <th>
                                        <select id="useStatus" class="form-control" name="useStatus">
                                            <option value="-1">--请选择--</option>
                                            <option value="0" <c:if test="${assetSearch.useStatus==0}">selected</c:if>>未使用</option>
                                            <option value="1" <c:if test="${assetSearch.useStatus==1}">selected</c:if>>已使用</option>
                                        </select>
                                    </th>
                                    <th>
                                        <input type="submit" value="查询" class="btn btn-primary form-control">
                                    </th>
                                    <th colspan="4">

                                    </th>
                                    <th style="padding-left: 100px">
                                        <input id="asset_change" type="button" value="初始化" class="btn btn-primary form-control" onclick="showImport()">
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
                        <c:forEach items="${assets.list}" var="assetMsg" varStatus="status">
                            <tr>
                                <td>${assetMsg.asset.assetCode}</td>
                                <td>${assetMsg.asset.serialNum}</td>
                                <td class="line-limit-length">${assetMsg.assetType.typeName}</td>
                                <td class="line-limit-length">${assetMsg.asset.typeName}</td>
                                <td>${assetMsg.asset.assetName}</td>
                                <td>${assetMsg.asset.modelNum}</td>
                                <td>${assetMsg.asset.unit}</td>
                                <td>${assetMsg.asset.purchaseNumber}</td>
                                <td>${assetMsg.asset.price}</td>
                                <td>${assetMsg.asset.totalMoney}</td>
                                <td class="line-limit-length"><fmt:formatDate value="${assetMsg.asset.purchaseDate}" pattern="yyyy年MM月dd日"/></td>
                                <td>${assetMsg.asset.useDepartment}</td>
                                <td>${assetMsg.asset.usePerson}</td>
                                <td>${assetMsg.asset.useStatus}</td>
                                <td>${assetMsg.asset.remarks}</td>
                                <td>${assetMsg.asset.depositPlace}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary asset_edit_btn" value="${assetMsg.asset.id}" data-toggle="modal" data-target=".asset-update-modal">编辑</a>
                                    <c:if test="${assetMsg.asset.usableFlag==0}">
                                        <a href="#" role="button" class="btn btn-danger asset_delete_btn"  onclick="asset_delete('${assetMsg.asset.id}','${assetMsg.asset.usableFlag}')">停用</a>
                                    </c:if>
                                    <c:if test="${assetMsg.asset.usableFlag!=0}">
                                        <a href="#" role="button" class="btn btn-primary asset_delete_btn" onclick="asset_delete('${assetMsg.asset.id}','${assetMsg.asset.usableFlag}')">启用</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <%--<div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${assets.pageNum} 页.总共 ${assets.pages} 页.一共 ${assets.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">

                            <li><a href="/asset/findByPage.do">首页</a></li>

                            <!--上一页-->
                            <li>
                                <c:if test="${assets.hasPreviousPage}">
                                    <a href="/asset/findByPage.do?pn=${assets.pageNum-1}" aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </c:if>
                            </li>

                            <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                            <c:forEach items="${assets.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == assets.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != assets.pageNum}">
                                    <li><a href="/asset/findByPage.do?pn=${page_num}">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${assets.hasNextPage}">
                                    <a href="/asset/findByPage.do?pn=${assets.pageNum+1}"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>

                            <li><a href="/asset/findByPage.do?pn=${assets.pages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>--%>
        </div><!-- /.emp_info -->


        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_body -->


</div><!-- /.container -->
<%--<%@ include file="bugMsgAdd.jsp"%>--%>
<%@ include file="assetAdd.jsp"%>
<%--<%@ include file="courseUpdate.jsp"%>--%>


<script>

    <!-- 展示初始化框 -->
    function showImport(){
        if($("#asset_change").val()=="初始化"){
            document.getElementById("assetDiv-first").style.display ="";
            $("#asset_change").val("隐藏");
        }else{
            document.getElementById("assetDiv-first").style.display ="none";
            $("#asset_change").val("初始化");
        }
    }

    <!-- ==========================课表删除操作=================================== -->
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
