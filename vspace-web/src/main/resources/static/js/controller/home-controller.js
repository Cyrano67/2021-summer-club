app.controller("home_controller",function($scope,$controller,$http){

    //继承
    $controller("base_controller",{$scope:$scope})

    $scope.ifLogin = window.sessionStorage.getItem("autologin")

    $scope.homeInit = function (){
        $scope.init();
    }
    
    $scope.logOut = function (){
    	window.sessionStorage.removeItem("autologin");
    	window.sessionStorage.removeItem("uname");
    	window.sessionStorage.removeItem("uid");
    	$http.get(('/login/logout.do')).success(function(response){
    		window.location = "index.html";
    	});
    	}
    	
    	
})