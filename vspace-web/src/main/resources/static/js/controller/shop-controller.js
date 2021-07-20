app.controller("shop-controller",function ($scope,$controller,$http){

    //使用如下方式继承loginStatus_controller
    $controller("lgstCtrl",{$scope:$scope});

    //继承search-controller控制器
    $controller("search_controller",{$scope:$scope});

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
        //设置最大最小值
        $scope.minPrice="0"
        $scope.maxPrice="10000"

        //设置排序方式
        $scope.sortSelect="0"

        //判断searchString是否设置过
        var searchString=window.sessionStorage.getItem("searchString");
        //没有设置过则默认
        if(searchString===null || searchString===""){
            $scope.searchString="男士";
        }
        //设置过则设置
        else{
            $scope.searchString=searchString;
        }
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

    $scope.filterChange = function (){
        let numPair = document.getElementById('amount').value.match(/\d+/g);
        $scope.minPrice = numPair[0];
        $scope.maxPrice = numPair[1];
        $scope.reloadList();
    }

    $scope.sortSelectChange = function (){
        let sortSelectString = $("#sortSelect").find("option:selected").attr("value");
        if(sortSelectString==="low to high"){
            $scope.sortSelect="0"
        }
        else{
            $scope.sortSelect="1"
        }
        $scope.reloadList();
    }




});
