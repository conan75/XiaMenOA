<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异常管理页面</title>
</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
</style>

<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="./commom/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>

        <!-- 部门表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="#">异常管理</a></li>
                        <li class="active">异常信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <form action="/bug/search.do" method="post" id="searchForm">
                    <table>
                        <tr>
                            <th>
                                <label for="period_condition" class="control-label">阶段名称:</label>
                            </th>
                            <th>
                                <input type="hidden" id="hiden_period" value="${bugSearch.periodCondition}">
                                <select id="period_condition" class="form-control" name="periodCondition">
                                </select>
                            </th>
                            <th>
                                <label for="Exception_condition" class="control-label">异常描述:</label>
                            </th>
                            <th>
                                <input type="text" id="Exception_condition" class="form-control"
                                       name="exceptionCondition" value="${bugSearch.exceptionCondition}">
                            </th>
                            <th colspan="2">
                                <input type="submit" value="查询" class="form-control">
                                <%--<a href="javascript:void(0);" role="button" onclick="onsubmit();" class="btn btn-primary">查询</a>--%>
                            </th>
                        </tr>
                    </table>
                </form>
                <hr>
                <table class="table table-bordered table-hover" id="dept_table">
                    <thead>
                    <tr>
                        <th>阶段名称</th>
                        <th>异常描述</th>
                        <th>异常原因</th>
                        <th>处理方式</th>
                        <th>异常截图</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${bugMsgs.list}" var="msg">
                            <tr ondblclick="textShow('${msg.exceptionMsg.messageId}')">
                                <td width="10%">${msg.period.periodName}</td>
                                <td width="20%" class="line-limit-length">${msg.exceptionMsg.exceptionDesc}</td>
                                <td width="25%" class="line-limit-length">${msg.exceptionMsg.exceptionReason}</td>
                                <td width="25%" class="line-limit-length">${msg.exceptionMsg.resolveWay}</td>
                                <td width="8%" align="center">
                                    <c:if test="${not empty msg.exceptionMsg.relatePic}">
                                        <img class="pimg" src="${msg.exceptionMsg.relatePic}" width="30px" height="30px" >
                                    </c:if>
                                </td>
                                <td width="12%">
                                    <a href="#" role="button" class="btn btn-primary bugMsg_edit_btn" data-toggle="modal" value="${msg.exceptionMsg.messageId}" data-target=".bugMsg-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger bugMsg_delete_btn" value="${msg.exceptionMsg.messageId}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
                    <div id="innerdiv" style="position:absolute;"><img id="bigimg" style="border:5px solid #fff;" src="" /></div></div>



            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${bugMsgs.pageNum} 页.总共 ${bugMsgs.pages} 页.一共 ${bugMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">

                            <!--当查询字段为空值,查询所有的bug信息-->
                            <c:if test="${(empty bugSearch.periodCondition||bugSearch.periodCondition==-1) && empty bugSearch.exceptionCondition}">
                                <li><a href="/bug/findByPage.do">首页</a></li>
                            </c:if>
                            <!--当查询字段不为空值,查询指定条件的bug信息-->
                            <c:if test="${(not empty bugSearch.periodCondition&&bugSearch.periodCondition!=-1) || not empty bugSearch.exceptionCondition}">
                                <li><a href="javascript:void(0)" onclick="searchMsg(1)">首页</a></li>
                            </c:if>

                            <!--上一页-->
                            <li>
                                <c:if test="${bugMsgs.hasPreviousPage}">

                                    <!--当查询字段为空值,查询所有的bug信息-->
                                    <c:if test="${(empty bugSearch.periodCondition||bugSearch.periodCondition==-1) && empty bugSearch.exceptionCondition}">
                                        <a href="/bug/findByPage.do?pn=${bugMsgs.pageNum-1}" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                    </c:if>
                                    <!--当查询字段不为空值,查询指定条件的bug信息-->
                                    <c:if test="${(not empty bugSearch.periodCondition&&bugSearch.periodCondition!=-1) || not empty bugSearch.exceptionCondition}">
                                        <a href="javascript:void(0)" onclick="searchMsg('${bugMsgs.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                    </c:if>

                                </c:if>
                            </li>

                            <!--当查询字段为空值,查询所有的bug信息-->
                            <c:if test="${(empty bugSearch.periodCondition||bugSearch.periodCondition==-1) && empty bugSearch.exceptionCondition}">
                                <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                                <c:forEach items="${bugMsgs.navigatepageNums}" var="page_num">
                                    <c:if test="${page_num == bugMsgs.pageNum}">
                                        <li class="active"><a href="#">${page_num}</a></li>
                                    </c:if>
                                    <c:if test="${page_num != bugMsgs.pageNum}">
                                        <li><a href="/bug/findByPage.do?pn=${page_num}">${page_num}</a></li>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                            <!--当查询字段不为空值,查询指定条件的bug信息-->
                            <c:if test="${(not empty bugSearch.periodCondition&&bugSearch.periodCondition!=-1) || not empty bugSearch.exceptionCondition}">
                                <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                                <c:forEach items="${bugMsgs.navigatepageNums}" var="page_num">
                                    <c:if test="${page_num == bugMsgs.pageNum}">
                                        <li class="active"><a href="#">${page_num}</a></li>
                                    </c:if>
                                    <c:if test="${page_num != bugMsgs.pageNum}">
                                        <li><a href="javascript:void(0)" onclick="searchMsg('${page_num}')">${page_num}</a></li>
                                    </c:if>
                                </c:forEach>
                            </c:if>



                            <!--下一页-->
                            <li>
                                <c:if test="${bugMsgs.hasNextPage}">

                                    <!--当查询字段为空值,查询所有的bug信息-->
                                    <c:if test="${(empty bugSearch.periodCondition||bugSearch.periodCondition==-1) && empty bugSearch.exceptionCondition}">
                                        <a href="/bug/findByPage.do?pn=${bugMsgs.pageNum+1}"
                                           aria-label="Next">
                                            <span aria-hidden="true">»</span>
                                        </a>
                                    </c:if>
                                    <!--当查询字段不为空值,查询指定条件的bug信息-->
                                    <c:if test="${(not empty bugSearch.periodCondition&&bugSearch.periodCondition!=-1) || not empty bugSearch.exceptionCondition}">
                                        <a href="javascript:void(0)" onclick="searchMsg('${bugMsgs.pageNum+1}')"
                                           aria-label="Next">
                                            <span aria-hidden="true">»</span>
                                        </a>
                                    </c:if>

                                </c:if>
                            </li>

                            <!--当查询字段为空值,查询所有的bug信息-->
                            <c:if test="${(empty bugSearch.periodCondition||bugSearch.periodCondition==-1) && empty bugSearch.exceptionCondition}">
                                <li><a href="/bug/findByPage.do?pn=${bugMsgs.pages}">尾页</a></li>
                            </c:if>
                            <!--当查询字段不为空值,查询指定条件的bug信息-->
                            <c:if test="${(not empty bugSearch.periodCondition&&bugSearch.periodCondition!=-1) || not empty bugSearch.exceptionCondition}">
                                <li><a href="javascript:void(0)" onclick="searchMsg('${bugMsgs.pages}')">尾页</a></li>
                            </c:if>

                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
    </div><!-- /.hrms_dept_body -->

    <%@ include file="bugMsgAdd.jsp"%>
    <%--<%@ include file="periodAdd.jsp"%>--%>
    <%@ include file="bugMsgUpdate.jsp"%>


    <!-- 尾部-->
    <%@ include file="./commom/foot.jsp"%>

</div><!-- /.hrms_dept_container -->

<script type="text/javascript">


    var hiden_period=$("#hiden_period").val();
    $("#period_condition").empty();
    $("#period_condition").append("<option value='-1'>-请选择-</option>")
    $.ajax({
        url: "/period/findList.do",
        type: "GET",
        async: false,
        success: function (result) {
            if(hiden_period==null){
                $.each(result, function (i, n) {
                    $("#period_condition").append("<option value='" + n.periodId + "'>" + n.periodName + "</option>")
                })
            }else{
                $.each(result, function (i, n) {
                    if(n.periodId==hiden_period) {
                        $("#period_condition").append("<option selected value='" + n.periodId + "'>" + n.periodName + "</option>")
                    }else{
                        $("#period_condition").append("<option value='"+n.periodId+"'>"+n.periodName+"</option>")
                    }
                })
            }

        }
    });

    /**
     * 条件查询
     */

    function searchMsg(pn) {
        $("#searchForm").attr("action","/bug/search.do?pn="+pn);
        $("#searchForm").submit();
    }

    /**
     * 双击单元行进行数据回显
     */
    function textShow(bid) {
        $.ajax({
            url: "/bug/findOne.do?bid=" + bid,
            async:false,
            type: "GET",
            success: function (result) {
                if (result.exceptionMsg != null) {
                    var bugMsgData = result.exceptionMsg;
                    var periodData = result.period;
                    //回显
                    if (result.period) {
                        //当存在阶段信息时进行回显,否则不进行阶段回显
                        $("#periodName_detail").val(periodData.periodName);
                    }
                    $("#exceptionDesc_detail").val(bugMsgData.exceptionDesc);
                    $("#exceptionReason_detail").val(bugMsgData.exceptionReason);
                    $("#resolveWay_detail").val(bugMsgData.resolveWay);
                } else {
                    alert("数据出错!");
                }
            }
        });
        $('.bugMsg-detail-modal').modal('show')
    }
    $(function(){
        $(".pimg").click(function(){
            var _this = $(this);//将当前的pimg元素作为_this传入函数
            imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
        });
    });
    function imgShow(outerdiv, innerdiv, bigimg, _this){
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性

        /*获取当前点击图片的真实大小，并显示弹出层及大图*/
        $("<img/>").attr("src", src).load(function(){
            var windowW = $(window).width();//获取当前窗口宽度
            var windowH = $(window).height();//获取当前窗口高度
            var realWidth = this.width;//获取图片真实宽度
            var realHeight = this.height;//获取图片真实高度
            var imgWidth, imgHeight;
            var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

            if(realHeight>windowH*scale) {//判断图片高度
                imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
                imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
                if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW*scale;//再对宽度进行缩放
                }
            } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
                imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
                imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
            } else {//如果图片真实高度和宽度都符合要求，高宽不变
                imgWidth = realWidth;
                imgHeight = realHeight;
            }
            $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放

            var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
            var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
            $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性
            $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
        });

        $(outerdiv).click(function(){//再次点击淡出消失弹出层
            $(this).fadeOut("fast");
        });
    }

    <!-- ==========================部门删除操作=================================== -->
    $(".bugMsg_delete_btn").click(function () {
        var bugMsgtId = $(this).attr("value");
        var curPageNo = ${bugMsgs.pageNum};
        if (confirm("确认删除该信息吗？")){
            $.ajax({
                url:"/bug/del.do?bid="+bugMsgtId,
                type:"GET",
                success:function (result) {
                    if (result){
                        alert("删除成功！");
                        window.location.href = "/bug/findByPage.do?pn="+curPageNo;
                    }else {
                        alert("请稍后再试!");
                    }
                }
            });
        }
    });
</script>
</body>
</html>
