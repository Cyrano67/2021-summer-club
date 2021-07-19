//通过模块对象创建一个控制器对象
var loginApp = angular.module('loginApp',[]);
loginApp.controller('loginCtrl',function ($scope, $http, $location) {
    //定义一个对象用于封装登录用户信息
    $scope.user = {"uid":0,"uname":"","password":"","email":"","phone":"","role":0};
    //定义一个对象用于封装注册用于信息
    $scope.regUser = {"uid":0,"uname":"richman9527","password":"","email":"","phone":"","role":0};
    /**
     * 创建一个方法用于登录
     */
    $scope.login_req=function(){
    	var host = location.host;
//    	$scope.user.phone
        //在登录之前进行表单验证
        //发送请求
        $http.post(('/login/login.do'),$scope.user).success(function(response){
            //查看返回结果信息
        	console.log(response);
            console.log(response);
//            如果登录成功则跳转到首页
            if(response.resultTag == false){
            	alert("登录信息错误！");
               
            }else{
//            	console.log(response);
                //登录成功之后将用户手机号码保存到本地
                window.sessionStorage.setItem("autologin","true");
                window.sessionStorage.setItem("uname",response.msg);
                //登录成功之后加载当前用户的购物车数据条数
//                $scope.findCartsByPhone();
                window.location = "index.html";
            }
        });
    }
 
    /**
     * 创建一个方法用于注册
     */
    $scope.register=function(){
        //表单验证
        //在登录之前进行表单验证
//        let regPhone = /^1[0-9]{10}$/;
//        if(!regPhone.test($scope.regUser.phone)){
//            alert("请输入正确的手机号码！");
//            return;
//        }
    	$scope.regUser.uid = $scope.regUser.phone
        $http.post(('/login/signin.do'),$scope.regUser).success(function(response){
            //查看返回结果信息
            //console.log(response);
            //如果登录成功则跳转到首页
            if(response.resultTag == false){
                //注册成功之后直接将手机号和密码设置到登录模块,用户可以方便快捷的进行登录
            	alert("注册失败！");
            }else{
                window.sessionStorage.setItem("autologin","true");
                window.sessionStorage.setItem("uname",response.msg);
                window.location = "index.html";
            }
        });
    }
});