//控制器对象

app.controller("richman-details-show-ctrl",function($scope,$controller,$http){
    //继承base_controller
    $controller("base_controller",{$scope:$scope});

    // for test,自己设置sessionStorage
    // sessionStorage.setItem("product_id",1);

    // 从session中得到需要打开的商品ID
    $scope.cid=sessionStorage.getItem("product_id");
    $scope.product_num = 1;

    $scope.changeNum=function(){
        $scope.product_num = document.getElementById('product_num').value;
        console.log($scope.product_num);
    }

    $scope.initDetails = function (){
        $scope.init();
        //在页面加载的时候查询相关产品
        $scope.loadRelateList();
    }
    // 直接发送post请求，初始化自己
    $http.post('/details/info',$scope.cid).success(function(response){
        $scope.cname=response.cname;
        $scope.price=response.price;
        $scope.discription=response.discription;
        $scope.picAddr=response.picAddr;
        $scope.merchant= response.merchant;
        $scope.size= response.size;
    });

    //Condition封装
    $scope.conditionRelate={"pageNo":"","pageSize":"","minPrice":"","maxPrice":"","sortType":"","searchString":""};

    $scope.loadRelateList = function () {
        $scope.conditionRelate.pageNo = 1;
        $scope.conditionRelate.pageSize = 4;
        $scope.conditionRelate.minPrice = 0;
        $scope.conditionRelate.maxPrice = 10000;
        $scope.conditionRelate.sortType = "0";
        $scope.conditionRelate.searchString = window.sessionStorage.getItem("searchString");
        $http.post("/shop/searchPages", $scope.conditionRelate).success(function (pageResult) {
            $scope.relateList = pageResult.dataList;
        });
    }
    $scope.findPic =function (uid){
        $http.post("/clothes/findByUid",uid).success(function (result){
            return result.picAddr;
        });
    }
});