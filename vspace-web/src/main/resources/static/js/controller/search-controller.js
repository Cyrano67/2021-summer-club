app.controller("search_controller",function($scope,$http){
    $scope.searchString="-";
    $scope.initSearch = function (){
        $scope.searchString="Tee";
        window.sessionStorage.setItem("searchString","Tee");
    }
    $scope.setSearchString = function (){
        var searchString=document.getElementById('searchString').value;
        window.sessionStorage.setItem("searchString",searchString);
        $scope.searchString=searchString;
        window.location.href="shop.html";
    }
    $scope.setSpecialSearchString = function (spString){
        window.sessionStorage.setItem("searchString",spString);
        $scope.searchString=spString;
        window.location.href="shop.html";
    }
    $scope.setAdditionalSearchString = function (adString){
        var ori_searchString=$scope.searchString;
        var searchString=adString+' '+ori_searchString;
        window.sessionStorage.setItem("searchString",searchString);
        $scope.searchString=searchString;
        window.location.href="shop.html";
        var searchString=ori_searchString;
        window.sessionStorage.setItem("searchString",searchString);
        $scope.searchString=searchString;
    }
})