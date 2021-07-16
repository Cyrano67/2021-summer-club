//通过模块对象创建一个控制器对象
var loginApp = angular.module('loginApp',[]);
loginApp.controller('loginCtrl',function ($scope, $http, $location) {
    //定义一个对象用于封装登录用户信息
    $scope.user = {"uid":0,"uname":"","password":"","email":"","phone":"","role":0};
    //定义一个对象用于封装注册用于信息
    $scope.regUser = {"phone":"","password":"","repPassword":"","agreeWithUs":false};
    /**
     * 创建一个方法用于登录
     */
    $scope.login_req=function(){
    	var host = location.host;
    	$scope.user.phone
        //在登录之前进行表单验证
        //发送请求
        $http.post(('http://' + host + '/login/login.do'),$scope.user).success(function(response){
            //查看返回结果信息
            //console.log(response);
            //如果登录成功则跳转到首页
            if(response == true){
                //登录成功之后将用户手机号码保存到本地
                window.sessionStorage.setItem("isLogin","true");
                window.sessionStorage.setItem("phone",$scope.user.phone);
                //登录成功之后加载当前用户的购物车数据条数
                $scope.findCartsByPhone();
                window.location = "index.html";
            }else{
                alert("账户或者密码有误!");
            }
        });
    }

    /**
     * 创建一个方法用于注册
     */
    $scope.register=function(){
        //表单验证
        //在登录之前进行表单验证
        let regPhone = /^1[0-9]{10}$/;
        if(!regPhone.test($scope.regUser.phone)){
            alert("请输入正确的手机号码！");
            return;
        }
        //验证码校验
        let regCheckCode = /^[0-9]{6}$/;
        if (!regCheckCode.test($scope.regUser.checkCode)) {
            alert("请输入有效验证码！");
            return;
        }
        //验证密码
        let regPassword = /^[0-9a-zA-Z_]{6,12}$/;
        if(!regPassword.test($scope.regUser.password)){
            alert("请输入密码(6~12位字母数字下划线)");
            return;
        }
        //再次输入密码
        if ($scope.regUser.password != $scope.regUser.repPassword) {
            alert("两次输入密码不一致！");
            return;
        }
        //验证用户是否同意了用户协议
        if (!$scope.regUser.agreeWithUs) {
            alert("请阅读并统一我们的协议！");
            return;
        }
        $http.post("/user/register",$scope.regUser).success(function(response){
            //查看返回结果信息
            //console.log(response);
            //如果登录成功则跳转到首页
            if(response == "true"){
                //注册成功之后直接将手机号和密码设置到登录模块,用户可以方便快捷的进行登录
                $scope.user.phone = $scope.regUser.phone;
                $scope.user.password = $scope.regUser.password;
                alert("恭喜您,注册成功！");
            }else{
                alert("注册失败！");
            }
        });
    }
});