//定义一个可信html过滤器
app.filter('trustHtml',['$sce',function($sce){
    return function(data){
        return $sce.trustAsHtml(data);
    }
}]);
app.controller("vspace-goods-controller",function($scope,$controller,$http){
    //使用如下方式继承base_controller
    $controller("base_controller",{$scope:$scope});

    //商品页面加载的时候调用的方法
    $scope.initialGoods=function (){
        //调用父控制器的方法
        $scope.init();
        //调用查询所有一级类型的方法: 注意控制器之间彼此隔离
        $scope.findAllFirstLevelCategory();
        //设置最低价格为0
        $scope.minPrice = 0;
        //设置最高价格为10000
        $scope.maxPrice = 10000;
        //默认查询1号大类型的商品进行分页显示
        $scope.findPage();

    }

    //创建方法: 根据一级类型编号查询二级类型集合
    $scope.findCategories=function(firstLevelCategoryId){
        $http.get("/goods/findCategories?categoryId=" + firstLevelCategoryId).success(function(resultList){
            $scope.resultList = resultList;
            console.log($scope.resultList);
        });
    }

    //创建方法用于设置搜索商品的类型(在点击类型列表的时候实现)
    $scope.setSearchCategory=function (categoryId){
        //设置当前类别的编号
        $scope.condition.categoryId=categoryId;
        //设置搜索关键字为"*"
        $scope.condition.searchString = "*";
        //如果更换了分类类型,则重新查询,所以此处将存放商品的集合信息设置为空数组
        $scope.goodsList = new Array();
        //设置完成之后调用一次分页条件查询
        $scope.findPage();
    }

    //设置最小价格
    $scope.setMinPrice=function (price){
        //设置最小值
        $scope.condition.minPrice = price;
        //设置完价格之后重新进行查询
        $scope.goodsList = new Array();
        //设置完成之后调用一次分页条件查询
        $scope.findPage();
    }

    //设置最大价格
    $scope.setMaxPrice=function (price){
        //设置最大值
        $scope.condition.maxPrice = price;
        //设置完价格之后重新进行查询
        $scope.goodsList = new Array();
        //设置完成之后调用一次分页条件查询
        $scope.findPage();
    }
    //创建一个对象用于封装分页参数信息
    $scope.condition = {
        "pageNo":"1",
        "pageSize":"12",
        "categoryId":"1",
        "minPrice":"0",
        "maxPrice":"1000",
        "searchString":"*"
    };
    //创建一个数组用于存放分页查询到的商品数据(为了可以正确使用数组对象的concat()方法)
    $scope.goodsList = new Array();
    //分页
    $scope.findPage=function(){
        console.log($scope.condition);
        //发送ajax请求按条件分页查询数据
        $http.post('/goods/findPageByCondition',$scope.condition).success(
            function(pageResult){
                for (let i = 0; i < pageResult.dataList.length; i++) {
                    pageResult.dataList[i].imageUrl = JSON.parse(pageResult.dataList[i].imageUrl);
                }
                //追加一页数据
                $scope.goodsList= $scope.goodsList.concat(pageResult.dataList);
                console.log($scope.goodsList);
                $scope.pages=pageResult.pages;//更新总记录数
            }
        );
    }

    //滚动触底调用的方法
    $scope.scrollPage=function (){
        //判断当前页码是否已经达到最大值
        if ($scope.condition.pageNo < $scope.pages) {
            //每次滚动触底的时候页码++
            $scope.condition.pageNo++;
            //调用分页查询方法
            $scope.findPage();
        }
    }

    //创建方法用于关键字搜索
    $scope.searchPage=function(){
        //点击搜索按钮之后将查询结果设置为空
        $scope.goodsList = new Array();
        //将类型编号设置为0
        $scope.condition.categoryId = 0;
        //设置查询关键字
        if ($scope.goods_keywords == null || $scope.goods_keywords == "") {
            $scope.condition.searchString = "*";
        }else{
            $scope.condition.searchString = $scope.goods_keywords;
        }
        $scope.findPage();
    }

});