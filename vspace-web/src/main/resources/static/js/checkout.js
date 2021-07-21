//通过模块对象创建一个控制器对象
app.controller("vspace-checkout-controller",function($scope,$controller,$http) {

    $scope.address = {"sid":0, "receiverName":"", "receiverPhone":"","receiverProvince":"", "receiverCity":"","receiverStreet":"","receiverAddress":"",
        "Postcode":""};
    var parse = Date.parse(2018,11,3,12,28);
    $scope.order = {"oid":123,"orderNo":0,"payment":450,"paymentType":0,"postage":15,"status":0,"shippingId":0,"paymentTime":parse,
        "sendTime":parse,"endTime":parse,"closeTime":parse,	"createTime":parse,"updateTime":parse,"cinfo":"","clink":"","uid":0
    };

    //$scope.uid = window.sessionStorage.getItem("uid");
    $scope.userId = 3;
    $scope.initialCheckOut=function(){
        $scope.get_Cart();
    }

    $scope.totalcost = 0;
    $scope.get_Cart = function(){
        //$http.get("/GetCartData?userId=" + $scope.userId).success(function(response){
        $http.post("/checkout/GetCartData?userId=" + $scope.userId).success(function(response){
            // alert("uid1");
            $scope.order_list = response;
            for (let i = 0; i < response.length; i++) {
                $scope.totalcost += response[i].entity.quantity * response[i].relateOne.price;
            }
        });
       // alert("successful load");
    }

    $scope.order.payment =  $scope.totalcost;
    window.sessionStorage.removeItem("cart");
    $scope.order_address = {"entity":$scope.address,"relateOne":$scope.order};

    $scope.placeOrder=function(){
        $http.post("/checkout/AddOrderInfoShippingInfo",$scope.order_address).success(function(response){
           if(response.entity < 0){
               alert("Address Error");
           }
           else if(response.relateOne < 0){
               alert("Order Error");
           }
           else{
               alert("Successful PlaceOrder")
           }
        });
    }


});
