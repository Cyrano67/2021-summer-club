app.controller("about_controller",function($scope,$controller,$http){

    //继承
    $controller("base_controller",{$scope:$scope})

    $scope.aboutInit = function (){
        $scope.init();
    }
})