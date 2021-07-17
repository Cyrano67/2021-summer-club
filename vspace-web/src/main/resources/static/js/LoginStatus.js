	var app = angular.module('loginstatus', []);
	var myAccount;
	app.controller('lgstCtrl', function($scope) {
		$scope.test = function() {
			var isLogin = window.sessionStorage.getItem("autologin");
			var uname = window.sessionStorage.getItem("uname");
			console.log(isLogin);
			console.log(uname);
	    }
	    $scope.Login = function() {
	        if ($scope.checkLogin()) 
	        	return "";
	        else
	        	return "SIGN IN OR REGISTER"
	    }
	    $scope.Hello = function() {
	        if ($scope.checkLogin()) 
	        	return "Hello";
	        else
	        	return ""
	    }
	    $scope.User = function() {
	        if ($scope.checkLogin()) 
	        	return window.sessionStorage.getItem("uname");
	        else
	        	return ""
	    }
	    $scope.Logout = function() {
	        if ($scope.checkLogin()) 
	        	return "LOG OUT";
	        else
	        	return ""
	    }
	    $scope.checkLogin=function(){

	        var isLogin = window.sessionStorage.getItem("autologin");
	        if (isLogin == "true") {
	            $scope.myAccount = window.sessionStorage.getItem("uname");
	            return true;
	        }
	        return false;
	    }
	    
	});
	