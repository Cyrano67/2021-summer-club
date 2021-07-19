app.controller("shop-controller",function ($scope,$controller,$http){

    //使用如下方式继承loginStatus_controller
    $controller("lgstCtrl",{$scope:$scope});

    $scope.paginationConf = {
        currentPage: 1, // 页码加载的时候显示的第几页的数据
        totalItems: 9, // 总页数的默认初始值(后续通过查询结果进行更新)
        itemsPerPage: 2, //默认状态下每页显示条数
        perPageOptions: [2,3,4],//每页显示条数的可选值
        onChange: function(){
            //当触发onChange事件的时候重新加载一次页面数据
            $scope.reloadList();
        }
    }
    $scope.findTop9FunIndicator=0;
    //初始化Shop页面使用的初始化方法
    $scope.initShop = function (){
        $scope.reloadList();
    }

    $scope.reloadList = function (){
        $scope.findTop9($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
        $scope.paginationConf.totalItems=9;
    }

    $scope.findTop9 = function (pageNo,pageSize){
        $http.post("/clothes/FindTop9").success(
            function (clothesList){

                let returnList=[];
                let listLength = clothesList.length

                for( let  i = (pageNo-1)* pageSize; i<pageNo*pageSize;i++){
                    returnList.push(clothesList[i]);
                }
                $scope.list = returnList;
                $scope.findTop9FunIndicator = $scope.list.length;
            }
        );
    }



});