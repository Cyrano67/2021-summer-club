//通过模块对象创建一个控制器对象
app.controller("vspace-index-controller",function($scope,$controller,$http){
    //使用如下方式继承base_controller
    $controller("base_controller",{$scope:$scope});
    //创建一个方法在页面加载的时候调用
    $scope.initialIndex=function(){
        //调用base_controller的init()方法
        $scope.init();
        //在页面初始化的时候调用查询top4一级商品类型的方法
        $scope.findTop4Category();
        //查询所有的一级类型
        $scope.findAllFirstLevelCategory();
        //查询1号类型的销量前8的商品
        $scope.findTop8GoodsByCategoryId(1);
        //查询全网销量前3的商品
        $scope.findTop3Goods();
    }

    //创建方法查询top4一级商品类型
    $scope.findTop4Category=function(){
        $http.get("/index/findTop4Category").success(function(result){
            //将查询返回的结果设置给指定的模型对象
            // result.categoryImg = JSON.parse(result.categoryImg);
            console.log(result);
            $scope.categoryList = result;
        });
    }

    $scope.findTop8GoodsByCategoryId=function (categoryId){
        $http.get("/index/findTop8GoodsByCategoryId?categoryId=" + categoryId).success(function(goodsList){
            for (let i = 0; i < goodsList.length; i++) {
                goodsList[i].imageUrl = JSON.parse(goodsList[i].imageUrl);
            }
            console.log(goodsList);
            $scope.goods = goodsList;
        });
    }

    //查询全网销量前三的商品
    $scope.findTop3Goods=function(){
        $http.get("/index/findTop3Goods").success(function(results){
            for (let i = 0; i < results.length; i++) {
                results[i].entity.imageUrl = JSON.parse(results[i].entity.imageUrl);
            }
            console.log(results);
            $scope.top3Goods = results;
        });
    }
});