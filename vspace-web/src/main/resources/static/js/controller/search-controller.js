app.controller("search_controller",function($scope,$http){
    $scope.searchString="-";
    $scope.setSearchString = function (){
        var searchString=document.getElementById('searchString').value;
        window.sessionStorage.setItem("searchString",searchString);
        $scope.searchString=searchString;
        window.location.href="shop.html";
    }
})