 //控制层 
app.controller('assetController' ,function($scope,$controller,assetService){
	
	$controller('baseController',{$scope:$scope});//继承
	
	//分页
	$scope.findPage=function(page,rows){			
		assetService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	
	$scope.searchEntity={};//定义搜索对象
	//搜索
	$scope.searchPage=function(page,rows){
		assetService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    <!-- 展示初始化框 -->
    $scope.showImport=function(){
        if($("#asset_change").val()=="初始化"){
            document.getElementById("assetDiv-first").style.display ="";
            $("#asset_change").val("隐藏");
        }else{
            document.getElementById("assetDiv-first").style.display ="none";
            $("#asset_change").val("初始化");
        }
    }

    $scope.assetEdit={};
    <!-- 查找指定id的资产信息进行编辑 -->
	$scope.asset_Edit=function (id) {
        $scope.assetEdit={};
        assetService.assetEdit(id).success(
        	function (response) {
                $scope.assetEdit=response;
                $('.assetMsg-add-modal').modal('show');
            }
		);
    }

    $scope.asset_Delete=function(id,useableFlag){
        assetService.asset_Delete(id,useableFlag).success(
        	function (response) {
        		alert("操作成功!")
                $scope.reloadList();
            }
		);
	}

});	
