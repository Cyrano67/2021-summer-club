//通过模块对象创建一个控制器对象
app.controller("vspace-my-account-controller",function($scope,$controller,$http){
    //使用如下方式继承base_controller
    $controller("base_controller",{$scope:$scope});
    //创建一个方法在页面加载的时候调用
    $scope.initialMyAccount=function(){
        //调用父控制器方法
        $scope.init();
        //调用方法查询当前用户基本信息
        $scope.findBasicByPhone();
        // //调用方法查询当前用户的收货地址信息
        // $scope.findReceiveAddrByPhone();
        if (window.sessionStorage.getItem("show-order") == "yes") {
            //调用方法查询当前用户的订单信息
            $scope.findOrdersByPhone();
            $scope.show_order = "active";
            $scope.show_account = "";
            //重置为no
            window.sessionStorage.setItem("show-order","no");
        }else{
            $scope.show_order = "";
            $scope.show_account = "active";
        }
    }

    //创建一个对象用于存放基本信息
    $scope.basic = {};
    //创建方法用于加载加载当前登录用户的基本信息
    $scope.findBasicByPhone=function(){
        //验证是否登录
        if (!$scope.checkLogin()) {
            //跳转到登录页面
            window.location.href="login-register.html";
            return;
        }
        $http.get("/user/findByPhone?phone=" + $scope.myAccount).success(function(result){
            result.birthday = $scope.dateTransfer(result.birthday);
            result.regDate = $scope.dateTransfer(result.regDate);
            result.lastLoginDate = $scope.dateTransfer(result.lastLoginDate);
            $scope.basic = result;
            //console.log(result);
        });
    }
    //创建一个方法将日期对象转换成指定的日期格式
    $scope.dateTransfer=function(param){
        let date = new Date(param);
        let year = date.getFullYear();
        let month = date.getMonth() < 10 ? '0' + date.getMonth() : date.getMonth();
        let day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
        let hour = date.getHours() < 10 ? '0' + date.getHours() : date.getHours();
        let min = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes();
        let sec = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds();
        let dateStr = year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec;
        //console.log(dateStr);
        return dateStr;
    }

    //创建对象用于存放修改密码时候的信息
    $scope.user = {"phone":"","password":"","newPwd":"","confirmPwd":""};
    //创建方法用于修改密码
    $scope.updatePassword=function(){
        //验证是否登录
        if (!$scope.checkLogin()) {
            //跳转到登录页面
            window.location.href="login-register.html";
            return;
        }
        //获取页面中的用户信息并进行校验
        let regPwd = /^[0-9a-zA-Z_]{6,12}$/;
        if (!regPwd.test($scope.user.password)) {
            alert("请输入当前密码!");
            return;
        }
        //校验新密码
        if (!regPwd.test($scope.user.newPwd)) {
            alert("请输入新密码(6~12位字母数字下划线)!");
            return;
        }
        //校验确认密码
        if ($scope.user.newPwd != $scope.user.confirmPwd) {
            alert("新密码和确认密码不一致!");
            return;
        }

        //发送ajax请求
        $http.post("/user/updatePassword",$scope.user).success(function(result){
            if (result == "true") {
                alert("修改密码成功!");
            }else{
                alert("原始密码有误,修改失败!");
            }
        });
    }
    //创建一个集合用于存放查询到的订单集合
    $scope.orders = [];
    //创建方法用于查询当前用户的订单信息
    $scope.findOrdersByPhone=function(){
        //验证是否登录
        if (!$scope.checkLogin()) {
            //跳转到登录页面
            window.location.href="login-register.html";
            return;
        }
        let phone = window.sessionStorage.getItem("phone");
        $http.get("/user/findOrdersByPhone?phone=" + phone).success(function(results){
            //转换图标路径对应的json格式的字符串转换成json对象
            for (let i = 0; i < results.length; i++) {
                results[i].relateOne.imageUrl = JSON.parse(results[i].relateOne.imageUrl);
            }
            $scope.order_results = results;
            console.log($scope.order_results);
        });
    }

    //创建方法用于当前用户删除指定的订单(本质: 根据订单编号将order表中的is_delete字段的值改为0)
    $scope.deleteOrderById=function(orderId){
        $http.get("/user/deleteOrderById?orderId=" + orderId).success(function(result){
            //删除成功之后刷新我的订单信息
            $scope.findOrdersByPhone();
        });
    }

    //创建一个对象用于存放省份: addrs对象在addrs.js文件中创建,包含了中国所有的省份市区县组成的json数据
    $scope.chinaProvs = addrs;
    //省份切换
    $scope.changeProvince = function () {
        var province = $scope.addr.prov;
        if (!angular.equals("", province)) {
            $scope.chinaCities = $scope.chinaProvs.find(item => item.name === province).city;
            console.log($scope.chinaCities);
        } else {
            $scope.chinaCities = null;
            $scope.chinaAreas = null;
        }
    }
    //城市切换
    $scope.changeCity = function () {
        var city = $scope.addr.city;
        if (!angular.equals("", city)) {
            $scope.chinaAreas = $scope.chinaCities.find(item=>item.name===city).area;
        } else {
            $scope.chinaAreas = null;
        }
    }

    //创建方法用于查询当前用户的所有收货地址信息
    $scope.findReceiveAddrByPhone=function(){
        //验证是否登录
        if (!$scope.checkLogin()) {
            //跳转到登录页面
            window.location.href="login-register.html";
            return;
        }
        let phone = window.sessionStorage.getItem("phone");
        $http.get("/user/findReceiveAddrByPhone?phone=" + phone).success(function(addrs){
            $scope.addrs = addrs;
        });
    }

    //创建方法根据收货地址编号查询收货地址信息
    $scope.findReceiveAddrById=function(addrId){
        $http.get("/user/findReceiveAddrById?addrId=" + addrId).success(function(addr){
            $scope.addr = addr;
            //调用方法重新绑定下拉选项
            $scope.changeProvince();
            $scope.changeCity();
        });
    }

    //创建方法用于根据地址编号删除收货地址信息
    $scope.deleteReceiveAddrById=function(addrId){
        $http.get("/user/deleteReceiveAddrById?addrId=" + addrId).success(function(result){
            if (result == "true") {
                //重新绑定当前用户的地址信息
                $scope.findReceiveAddrByPhone();
            }
        });
    }

    //创建方法: 修改和增加收货地址
    $scope.save_updateReceiveAddr=function(){
        //验证是否登录
        if (!$scope.checkLogin()) {
            //跳转到登录页面
            window.location.href="login-register.html";
            return;
        }
        //根据地址编号判断是新增还是修改
        if ($scope.addr.addrId != null) {
            $http.post("/user/updateReceiveAddr",$scope.addr).success(function(result){
                //进行了修改操作之后需要将addr实体数据设置为null
                $scope.addr = {};
                if (result == "true") {
                    //重新绑定当前用户的地址信息
                    $scope.findReceiveAddrByPhone();
                }
            });
        }else{
            let phone = window.sessionStorage.getItem("phone");
            //绑定新增收货地址所属的用户
            $scope.addr.ownUserPhone = phone;
            //默认情况下新增地址不是默认售后地址
            $scope.addr.isDefault = false;
            $http.post("/user/insertReceiveAddr",$scope.addr).success(function(result){
                if (result == "true") {
                    $scope.findReceiveAddrByPhone();
                }
            });
        }
    }

    //创建方法用于设置默认地址
    $scope.setDefautlAddr=function(addrId){
        let phone = window.sessionStorage.getItem("phone");
        //创建一个对象用于设置默认地址的请求参数
        let addr = {"ownUserPhone":phone,"addrId":addrId};
        $http.post("/user/setDefautlAddr",addr).success(function(result){
            //重新绑定当前用户的地址信息
            $scope.findReceiveAddrByPhone();
        });
    }

    //创建方法用于上传头像
    $scope.upload=function(){
        //验证是否登录
        if (!$scope.checkLogin()) {
            //跳转到登录页面
            window.location.href="login-register.html";
            return;
        }
        var form = new FormData();
        //获取表单中的文件域
        var file = document.getElementById("uploadFile").files[0];
        form.append('uploadFile', file);
        let phone = window.sessionStorage.getItem("phone");
        //将当前用户手机号码封装到表单数据中
        form.append('phone', phone);
        $http({
            method: 'POST',
            url: '/pic/upload',
            data: form,
            headers: {'Content-Type': undefined},
            //注意此处如果将Content-Type设置成"multipart/form-data"会出现异常,如果不设置angular默认又是application/json
            //设置'Content-Type': undefined，浏览器自动把Content-Type 设置为 multipart/form-data
            transformRequest: angular.identity //该参数是将表单数据序列化操作
        }).success(function (url) {
            //将相应回来的url设置到头像img上
            $scope.basic.headImages = url;
        }).error(function (data) {
            console.log('upload fail');
        })
    }

    //创建方法用于发送退货退款请求
    $scope.refund=function(order){
        //查看参数数据是否正常
        console.log(order);
        //发送退货退款申请
        $http.post("/user/refund",order).success(function(refundResult){
            console.log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            console.log(refundResult);
            console.log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            $scope.findOrdersByPhone();
        });
    }
});