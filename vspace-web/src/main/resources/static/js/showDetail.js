//控制器对象

app.controller("richman-details-show-ctrl",function($scope,$controller,$http){
    //继承base_controller
    $controller("base_controller",{$scope:$scope});
    var host = location.host;

    // for test,自己设置sessionStorage
    // sessionStorage.setItem("product_id",1);

    // 从session中得到需要打开的商品ID
    $scope.cid=sessionStorage.getItem("product_id");

    $scope.initDetails = function (){
        $scope.init();
    }
    // 直接发送post请求，初始化自己
    $http.post('/details/info',$scope.cid).success(function(response){
//        $scope.acess="oks";

        $scope.cname=response.cname;
        $scope.price=response.price;
        $scope.discription=response.discription;
        $scope.picAddr=response.picAddr;
        $scope.merchant= response.merchant;
        $scope.size= response.size;
    });

});