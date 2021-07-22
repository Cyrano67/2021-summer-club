//通过模块对象创建一个控制器对象
app.controller("vspace-checkout-controller",function($scope,$controller,$http) {

    //继承base_controller
    $controller("base_controller",{$scope:$scope});

    $scope.address = {"sid":0, "receiverName":"", "receiverPhone":"15523304127","receiverProvince":"cq", "receiverCity":"cq","receiverStreet":"Shapingba","receiverAddress":"CQU",
        "Postcode":"400032"};
    var parse = Date.parse(2018,11,3,12,28);
    $scope.order = {"oid":123,"orderNo":0,"payment":450,"paymentType":0,"postage":15,"status":0,"shippingId":0,"paymentTime":parse,
        "sendTime":parse,"endTime":parse,"closeTime":parse,	"createTime":parse,"updateTime":parse,"cinfo":"","clink":"","uid":0
    };

    $scope.uid = window.sessionStorage.getItem("uid");
    
    $scope.initialCheckOut=function(){
        $scope.findCartsByPhone();
        $scope.get_Cart();
        $scope.userId = $scope.uid;
        console.log($scope.uid);
    }

    $scope.get_Cart = function(){
        $scope.totalcost = 0;
        //$http.get("/GetCartData?userId=" + $scope.userId).success(function(response){
        $http.get("/checkout/GetCartData?uid=" + $scope.uid).success(function(response){
            // alert("uid1");
            $scope.order_list = response;
            for (let i = 0; i < response.length; i++) {
            	$scope.order.cinfo =  $scope.order.cinfo + response[i].relateOne.cname +";";
                $scope.order.clink = $scope.order.clink + response[i].relateOne.cid + ";";
                $scope.totalcost += response[i].entity.quantity * response[i].relateOne.price;
            }
            $scope.order.payment =  $scope.totalcost;
            $scope.order.uid = $scope.uid;
        });
       // alert("successful load");
    }


    window.sessionStorage.removeItem("cart");
    console.log($scope.order);

    $scope.order_address = {"entity":$scope.address,"relateOne":$scope.order};

    $scope.placeOrder=function(){
        $http.post("/checkout/AddOrderInfoShippingInfo",$scope.order_address).success(function(response){
			//设置"my-account.html页面"直接显示"我的订单"模块
			//在支付成功之后同步通知的页面设置成"my-account.html页面"
			window.sessionStorage.setItem("show-order","yes");
			//关闭当前页面,新开一个支付页面,支付成功之后跳转到用户订单页面
			//设置支付结果跳转显示页面
			let div = document.createElement('div');
			div.innerHTML = response.relateOne; // html code
			console.log(div.innerHTML);
			document.body.appendChild(div);
			//punchout_form该名称通过后台支付响应得到的payresult进行观察获取
			document.forms.punchout_form.setAttribute('target','_blank');//新开浏览器窗口
			document.forms.punchout_form.submit();
			window.opener = null;
			window.open("about:blank","_self");   
			window.close();
           if(response.entrelateOneity != null){
        	   alert("Successful PlaceOrder");
           }

        });
    }


});
