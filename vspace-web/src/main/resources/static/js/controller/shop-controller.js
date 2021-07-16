app.controller("shop-controller",function ($scope,$controller,$http){

    //使用如下方式继承base_controller
    // $controller("base_controller",{$scope:$scope});

    //初始化Shop页面使用的初始化方法
    $scope.initShop = function (){
        $scope.paginationConf = {
            currentPage: 1, // 页码加载的时候显示的第几页的数据
            totalItems: 10, // 总页数的默认初始值(后续通过查询结果进行更新)
            itemsPerPage: 10, //默认状态下每页显示条数
            perPageOptions: [5,10,15,20,25],//每页显示条数的可选值
            onChange: function(){
                //当触发onChange事件的时候重新加载一次页面数据
                // $scope.reloadList();
            }
        }
    }



});