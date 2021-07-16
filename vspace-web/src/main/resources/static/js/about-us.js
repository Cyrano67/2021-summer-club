//通过模块对象创建一个控制器对象
app.controller("vspace-about-us-controller",function($scope,$controller,$http){
    //使用如下方式继承base_controller
    $controller("base_controller",{$scope:$scope});

});