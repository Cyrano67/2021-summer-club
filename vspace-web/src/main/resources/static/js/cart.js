//通过模块对象创建一个控制器对象
app.controller("vspace-cart-controller",function($scope,$controller,$http){
    //使用如下方式继承base_controller
    $controller("base_controller",{$scope:$scope});
    //创建一个方法在页面加载的时候调用
    $scope.initialCart=function(){
        //调用父控制器中的init()方法
        $scope.init();
        //页面加载的时候查询当前用户的所有购物车信息
        $scope.findCartsByPhone();
        //查询当前用户的默认收货地址
        $scope.findDefaultReceiveAddr();
    }

    //创建方法: 用于更新购物车
    $scope.updateCart=function(cartId,ammount){
        var cart = {"cartId":cartId,"ammount":ammount};
        $http.post("/cart/updateCart",cart).success(function(result){
            console.log("update success!");
        });
    }

    //点击"+"
    $scope.add=function(index,cartId){
        $scope.results[index].entity.ammount ++;
        //计算总价
        $scope.calculateSumPrice($scope.results);
        //同步到数据库
        $scope.updateCart(cartId,$scope.results[index].entity.ammount);
    }

    //点击"-"
    $scope.minus=function(index,cartId){
        $scope.results[index].entity.ammount --;
        if ($scope.results[index].entity.ammount < 1) {
            $scope.results[index].entity.ammount = 1
        }
        //计算总价
        $scope.calculateSumPrice($scope.results);
        //同步到数据库
        $scope.updateCart(cartId,$scope.results[index].entity.ammount);
    }

    //创建方法查询当前用户的默认收货地址
    $scope.findDefaultReceiveAddr=function (){
        //验证是否登录
        if (!$scope.checkLogin()) {
            //跳转到登录页面
            window.location.href="login-register.html";
            return;
        }
        $http.get("/cart/defaultAddr?phone=" + window.sessionStorage.getItem("phone")).success(function(addr){
            console.log(addr);
            $scope.defaultAddr = addr;
        });
    }

    //创建方法用于结算购物车生成订单
    $scope.checkout=function (){
        if ($scope.results.length < 1) {
            alert("当前没有任何购物信息!");
            return;
        }
        //创建一个json集合用于存放订单数据信息并发送给后台服务
        let orders = new Array();
        for (let i = 0; i < $scope.results.length; i++) {
            //创建一个json对象
            let order = {"phone":window.sessionStorage.getItem("phone")};
            order.goodsId = $scope.results[i].relateOne.goodsId;
            order.ammount = $scope.results[i].entity.ammount;
            order.sumPrice = $scope.results[i].entity.ammount * $scope.results[i].relateOne.price * $scope.results[i].relateOne.discount;
            //总价保留两位小数
            order.sumPrice = order.sumPrice.toFixed(2);
            order.orderStatus = 0;
            order.receiveAddrId = $scope.defaultAddr.addrId;
            order.deleteTag = true;
            //将订单json对象添加到数组中
            orders.push(order);
        }
        //发送ajax请求
        $http.post("/order/checkout?goodsTotalPrice=" + $scope.goodsTotalPrice + "&freight=" + $scope.freight,orders).success(function(payResult){
            //订单生成成功之后: 将购物车数据清除
            let cartIdList = new Array();
            for (let i = 0; i < $scope.results.length; i++) {
                cartIdList.push($scope.results[i].entity.cartId);
            }
            //调用批量删除方法
            $scope.deleteBatchCart(cartIdList);
            console.log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            console.log(payResult);

            //设置"my-account.html页面"直接显示"我的订单"模块,在支付成功之后同步通知的页面设置成"my-account.html页面"
            window.sessionStorage.setItem("show-order","yes");
            //关闭当前页面,新开一个支付页面,支付成功之后跳转到用户订单页面
            window.close();
            //设置支付结果跳转显示页面
            let div = document.createElement('div');
            div.innerHTML = payResult; // html code
            document.body.appendChild(div);
            //punchout_form该名称通过后台支付响应得到的payResult进行观察获取
            document.forms.punchout_form.setAttribute('target', '_blank');//新开浏览器窗口
            document.forms.punchout_form.submit();
        });
    }

    //创建方法用于批量删除购物车
    $scope.deleteBatchCart=function (cartIdList){
        $http.post("/cart/deleteBatch",cartIdList).success(function(tag){
            console.log(cartIdList);
            //在会话中保存一个变量表示: 从此处跳转到我的账户页面时候默认显示订单模块
            window.sessionStorage.setItem("show-order","yes");
            //跳转到我的账户页面
            window.location.href = "my-account.html";
        });
    }
});