app.controller("shop-controller",function ($scope,$controller,$http){

    //使用如下方式继承loginStatus_controller
    // $controller("lgstCtrl",{$scope:$scope});

    //继承search-controller控制器
    // $controller("search_controller",{$scope:$scope});

    //继承base_controller
    $controller("base_controller",{$scope:$scope});

    //条件生成
    $scope.paginationConf = {
        currentPage: 1, // 页码加载的时候显示的第几页的数据
        totalItems: 9, // 总页数的默认初始值(后续通过查询结果进行更新)
        itemsPerPage: 4, //默认状态下每页显示条数
        perPageOptions: [4,5,6],//每页显示条数的可选值
        onChange: function(){
            //当触发onChange事件的时候重新加载一次页面数据
            $scope.reloadList();
        }
    }

    //Condition封装
    $scope.condition={"pageNo":"","pageSize":"","minPrice":"","maxPrice":"","sortType":"","searchString":""};

    $scope.findTop9FunIndicator=0;
    //初始化Shop页面使用的初始化方法
    $scope.initShop = function (){

        $scope.findCartsByPhone();
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
        $scope.condition.pageNo=$scope.paginationConf.currentPage;
        $scope.condition.pageSize=$scope.paginationConf.itemsPerPage;
        $scope.condition.minPrice=$scope.minPrice;
        $scope.condition.maxPrice=$scope.maxPrice;
        $scope.condition.sortType=$scope.sortSelect;
        $scope.condition.searchString=$scope.searchString;
        $http.post("/shop/searchPages",$scope.condition).success(function (pageResult){
            $scope.list=pageResult.dataList;
            $scope.paginationConf.totalItems=pageResult.totalItems;

        });



        // $scope.findTop9($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
        // $scope.paginationConf.totalItems=9;
    }

    $scope.shopInsertCart = function (cid){
        window.sessionStorage.setItem("product_id",cid);
        $scope.product_num=1;
        $scope.insertCart();
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
            $scope.sortSelect="1"
        }
        else{
            $scope.sortSelect="0"
        }
        $scope.reloadList();
    }


});
