app.controller("all-orders_controller",function($scope,$controller,$http){

    //继承
    $controller("base_controller",{$scope:$scope});

    $scope.initialIaorders=function(){
        $scope.findCartsByPhone();
        //以下两种方式，注释与未注释的二选一，与all-orders.html相匹配也是注释与未注释的二选一
        $http.get("/Orderinfo/get_order_nums?uid="+window.sessionStorage.getItem("uid")).success(function(order_nums){
            $scope.order_nums = order_nums;
            $scope.tempTest1=$scope.order_nums.length;
            // $scope.tempTest1=$scope.order_nums[0];
        });
        $http.get("/Orderinfo/get_total_price?uid="+window.sessionStorage.getItem("uid")).success(function(total_prices){
            $scope.total_prices = total_prices;
            $scope.tempTest2=$scope.total_prices.length;
        });
        $http.get("/Orderinfo/find_inactive_orders?uid="+window.sessionStorage.getItem("uid")).success(function(inactive_orders){
            $scope.inactive_orders = inactive_orders;
            $scope.tempTest3=$scope.inactive_orders.length;
        });
        // $http.get("/Orderinfo/find_inactive_ordersinfos?uid="+window.sessionStorage.getItem("uid")).success(function(inactive_orderinfos){
        //     $scope.tempTest=inactive_orderinfos.length;
        //     $scope.inactive_orderinfos = inactive_orderinfos;
        // });
    }

})