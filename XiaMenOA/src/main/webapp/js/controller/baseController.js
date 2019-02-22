app.controller("baseController",function ($scope) {
    $scope.reloadList=function(){
        //切换页码
        $scope.searchPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    $scope.paginationConf = {
        currentPage: 1,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function() {
            $scope.reloadList();//重新加载
        }
    }

})