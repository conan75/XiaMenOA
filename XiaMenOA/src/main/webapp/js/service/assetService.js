//服务层
app=angular.module("XiaMenOA",["pagination"]).service('assetService',function($http){

	//分页 
	this.findPage=function(page,rows){
		return $http.get('../asset/findByPage.do?page='+page+'&rows='+rows);
	}
    //搜索
    this.search=function(page,rows,searchPage){
        return $http.post('../asset/search.do?page='+page+"&rows="+rows, searchPage);
    }
    //查找单个资产信息
    this.assetEdit=function (id) {
        return $http.get('../asset/findOne.do?id='+id);
    }

    //删除单个资产信息
    this.asset_Delete=function (id,useableFlag) {
        return $http.get('../asset/del.do?id='+id+"&useableFlag="+useableFlag);
    }
});
