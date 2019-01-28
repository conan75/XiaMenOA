<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>异常管理页面</title>
</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
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
                <!-- Table -->
                <table class="table table-bordered table-hover" id="dept_table">
                    <thead>
                        <th>阶段名称</th>
                        <th>异常描述</th>
                        <th>异常原因</th>
                        <th>处理方式</th>
                        <th>异常截图</th>
                        <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${bugMsgs.list}" var="msg">
                            <tr>
                                <td>${msg.period.periodName}</td>
                                <td>${msg.exceptionMsg.exceptionDesc}</td>
                                <td>${msg.exceptionMsg.exceptionReason}</td>
                                <td>${msg.exceptionMsg.resolveWay}</td>
                                <td>
                                    <c:if test="${not empty msg.exceptionMsg.relatePic}">
                                        <img class="pimg" src="${msg.exceptionMsg.relatePic}" width="30px" height="30px" >
                                    </c:if>
                                </td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary bugMsg_edit_btn" data-toggle="modal" value="${msg.exceptionMsg.messageId}" data-target=".bugMsg-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger bugMsg_delete_btn" value="${msg.exceptionMsg.messageId}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
                    <div id="innerdiv" style="position:absolute;"><img id="bigimg" style="border:5px solid #fff;" src="" /></div></div>

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

                                <li><a href="${pageContext.request.contextPath}/bug/findByPage.do">首页</a></li>

                                <!--上一页-->
                                <li>
                                    <c:if test="${bugMsgs.hasPreviousPage}">
                                        <a href="${pageContext.request.contextPath}/bug/findByPage.do?pn=${bugMsgs.pageNum-1}" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                    </c:if>
                                </li>

                                <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                                <c:forEach items="${bugMsgs.navigatepageNums}" var="page_num">
                                    <c:if test="${page_num == bugMsgs.pageNum}">
                                        <li class="active"><a href="#">${page_num}</a></li>
                                    </c:if>
                                    <c:if test="${page_num != bugMsgs.pageNum}">
                                        <li><a href="${pageContext.request.contextPath}/bug/findByPage.do?pn=${page_num}">${page_num}</a></li>
                                    </c:if>
                                </c:forEach>

                                <!--下一页-->
                                <li>
                                    <c:if test="${bugMsgs.hasNextPage}">
                                        <a href="${pageContext.request.contextPath}/bug/findByPage.do?pn=${bugMsgs.pageNum+1}"
                                           aria-label="Next">
                                            <span aria-hidden="true">»</span>
                                        </a>
                                    </c:if>
                                </li>

                                <li><a href="${pageContext.request.contextPath}/bug/findByPage.do?pn=${bugMsgs.pages}">尾页</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>

            </div><!-- /.panel panel-success -->
        </div><!-- /.dept_info -->
    </div><!-- /.hrms_dept_body -->

    <%@ include file="bugMsgAdd.jsp"%>
    <%@ include file="bugMsgUpdate.jsp"%>

    <!-- 尾部-->
    <%@ include file="./commom/foot.jsp"%>

</div><!-- /.hrms_dept_container -->

<script type="text/javascript">
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
