//创建一个基础控制器,用于存放各个控制器中共有的代码
app.controller("base_controller",function($scope,$controller,$http){

    //使用如下方式继承loginStatus_controller
    $controller("lgstCtrl",{$scope:$scope});

    //继承search-controller控制器
    $controller("search_controller",{$scope:$scope});

    // 打开详情页面
    $scope.jumpDetail=function(product_id){
        window.sessionStorage.setItem("product_id",product_id);
        window.location.href="/detail";
    }

    $scope.autoLogin=function(){
        //将"我的账户"更新为登录成功的用户
        $http.post(('/login/autologin.do')).success(function(response){
            //查看返回结果信息
        	console.log(response);
            console.log(response);
//            如果登录成功则跳转到首页
            if(response.resultTag == false){
               
            }else{
//            	console.log(response);
                //登录成功之后将用户手机号码保存到本地
                window.sessionStorage.setItem("autologin","true");
                window.sessionStorage.setItem("uname",response.msg);
                window.sessionStorage.setItem("uid",parseInt(response.alterMsg));
                //登录成功之后重新加载页面
//                $scope.findCartsByPhone();
                window.location = $location.url();
            }
        });
        return true;
    }
    
    $scope.myAccount = "我的账户";

    //创建一个方法在页面加载的时候调用
    $scope.init=function(){
        //调用验证登录的方法,设置myAccount变量的数据
        if ($scope.checkLogin2()) {
            //在初始化的时候,如果登录成功者进行当前用户购物车的信息查询
            $scope.findCartsByPhone();
        }
        else{
        	$scope.autoLogin();
        }
    }

    //单独创建方法用于验证是否登录

    //单独创建方法用于初始化信息
    $scope.checkLogin=function(){
        //将"我的账户"更新为登录成功的用户
        let isLogin = window.sessionStorage.getItem("isLogin");
        if (isLogin == "true") {
            $scope.myAccount = window.sessionStorage.getItem("phone");
            return true;
        }
        return false;
    }

    //创建方法: 在购物车页面加载的时候调用,用于查询当前用户的所用购物车信息
    $scope.findCartsByPhone=function (){
        //验证是否登录
//        if (!$scope.checkLogin()) {
//            //跳转到登录页面
//            window.location.href="login.html";
//            return;
//        }
//        $http.get("/cart/find_of_user?uid=" + window.sessionStorage.getItem("uid")).success(function(results){
//            //循环转换imageUrl为json
//            for (let i = 0; i < results.length; i++) {
//                results[i].relateOne.picAddr = JSON.parse(results[i].relateOne.picAddr);
//            }
//            $scope.results = results;
//            console.log(results);
//            //计算总价
////            $scope.calculateSumPrice($scope.results);
//        });

        console.log(window.sessionStorage.getItem("uid"));
        console.log(window.sessionStorage.getItem("uname"));
        console.log("进入查找");//,window.sessionStorage.getItem("uid")
        let uidd=window.sessionStorage.getItem("uid");
        var userr={"uid":uidd,"uname":"12","password":"1","email":"1","phone":"1","role":0};
        $http.post("/cart/find_by_user?uid="+window.sessionStorage.getItem("uid")).success(function(results){
            //循环转换imageUrl为json
            // for (let i = 0; i < results.length; i++) {
            //     results[i].relateOne.picAddr = "http://116.63.130.162:49155/group1/M00/00/00/rBIBBGDxLBSAQeQmAABtjLq27Oc832.jpg";
            // }
            $scope.results = results;
            $scope.calculateSumPrice($scope.results);
        });
    }
    //创建方法用于计算购物车总价
    $scope.calculateSumPrice=function(results){
        var totalPrice = 0;
        for (let i = 0; i < results.length; i++) {
            console.log(results[i].relateOne.cid);
            console.log(results[i].relateOne.price);
            console.log(results[i].relateOne.cname);
            totalPrice += results[i].entity.quantity * results[i].relateOne.price;
        }
        $scope.goodsTotalPrice = parseFloat(totalPrice.toFixed(2));//保留两位小数
        //随机生成一个运费
        //$scope.freight = parseFloat(Math.round(Math.random() * (15 - 5 + 1) + 5).toFixed(2));
        $scope.freight = 0.00;//此案例默认包邮,邮费设置为0
        $scope.totalPrice = ($scope.goodsTotalPrice + $scope.freight).toFixed(2);
    }
    //由于多个页面中都会存在根据编号查询商品信息的情况,此处将
    //创建方法: 根据编号查询商品信息
    $scope.findGoodsById=function(goodsId){
        $http.get("/clothes/findByUid?goodsId=" + goodsId).success(function(goods){
            goods.imageUrl = JSON.parse(goods.imageUrl);
            console.log(goods);
            $scope.quickViewGoods = goods;
        });
    }

    //点击"商品图片"的时候将当前商品的编号存储到会话storage中
    $scope.storageGoodsIdToLocal=function(goodsId){
        window.sessionStorage.setItem("detailsGoodsId",goodsId);
        //跳转到详情页
        window.location.href="product-details.html";
    }

    //点击"加入购物车"时候调用的方法
    //创建方法: 添加购物车
    $scope.insertCart=function(){
        //验证是否登录
        // if (!$scope.checkLogin()) {
        //     //跳转到登录页面
        //     window.location.href="login-register.html";
        //     return;
        // }
        //创建一个json对象用于存放购物车数据
        //var cart = {"uid":window.sessionStorage.getItem("uid"),"goodsId":goodsId,"ammount":"1"};
        var cid=window.sessionStorage.getItem("product_id");
        var uid=window.sessionStorage.getItem("uid");
        console.log(cid);
        console.log(uid);
        // window.sessionStorage.setItem("flag_test",10);
        // $scope.results.temp=window.sessionStorage.getItem("flag_test");
        var cart1={"cid":cid,"uid":uid,"caid":0,"quantity":0};
        var caid_test=cid*1000+uid;
        console.log("此时的caid");
        console.log(caid_test);
        var uid=window.sessionStorage.getItem("uid");
        var flag="";
        var t_num=0;
        var cartt={"caid":caid_test,"cid":cid,"uid":uid,"quantity":$scope.product_num};
        $http.post("/cart/insertCart",cartt).success(function(flag){
            //跳转到购物车页面
            console.log("插入成功");
            window.location.href="cart.html";
        });
    }

    //创建方法用于查询所有的一级商品类型
    $scope.findAllFirstLevelCategory=function (){
        $http.get("/index/findAllFirstLevelCategory").success(function(result){
            console.log(result);
            $scope.categories = result;
        });
    }

    //创建方法: 用于删除购物车信息
    $scope.deleteCart=function(caid){
        console.log(caid);
        $http.post("/cart/deleteById?caid=" + caid).success(function(result){
            //删除成功之后,重新查询
            $scope.findCartsByPhone();
        });
    }
});