app.controller("home_controller",function($scope,$controller,$http){

    //继承
    $controller("base_controller",{$scope:$scope})

    $scope.ifLogin = window.sessionStorage.getItem("autologin")

    $scope.homeInit = function (){
        $scope.init();
    }
})