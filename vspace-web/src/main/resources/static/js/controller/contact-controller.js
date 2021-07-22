app.controller("contact_controller",function($scope,$controller,$http){

    //继承
    $controller("base_controller",{$scope:$scope})

    $scope.contactInit = function (){
        $scope.init();
    }
    $scope.getSubmit=function(){
        window.alert("Submit successfully!")

    }
})