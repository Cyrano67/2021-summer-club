app.controller("all-orders_controller",function($scope,$controller,$http){

    //继承
    $controller("base_controller",{$scope:$scope});

    $scope.initialIaorders=function(){
        $scope.findCartsByPhone();
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
        // $http.get("/Orderinfo/find_inactive_orders?uid="+window.sessionStorage.getItem("uid")).success(function(ordersInfos){
        //     $scope.tempTest=ordersInfos.length;
        //     let inactive_orders = new Array();
        //     for (let i = 0; i < ordersInfos.length; i++) {
        //         // let oid=ordersInfos[i].oid;
        //         let inactive_order = {"OrderNum":ordersInfos[i].orderNo,"TotalPrice":ordersInfos[i].payment};
        //         $http.get("/Orderinfo/find_cinfos?oid="+ordersInfos[i].oid).success(function(cinfos){
        //             inactive_order.Products=cinfos;
        //             inactive_order.ProductsNum=new Array(cinfos.length);
        //         });
        //         $http.get("/Orderinfo/find_clinks?oid="+ordersInfos[i].oid).success(function(clinks){
        //             inactive_order.Links=clinks;
        //         });
        //         inactive_orders.push(inactive_order);
        //     }
        //     $scope.inactive_orders = inactive_orders;
        // });
    }

})