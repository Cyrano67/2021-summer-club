//通过模块对象创建一个控制器对象
app.controller("vspace-product-details-controller",function($scope,$controller,$http){
    //使用如下方式继承base_controller
    $controller("base_controller",{$scope:$scope});

    //创建方法用于商品详情页面初始化
    $scope.initialProductDetails=function(){
        //调用父控制器的init()方法初始化
        $scope.init();
        //在页面加载的时候查询当前商品的详细信息并展示出来
        $scope.findGoodsById(window.sessionStorage.getItem("detailsGoodsId"));
    }

});