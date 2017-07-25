/**
 * 
 */
'use strict';
 
angular.module('myApp').controller('dashboardController', ['$scope', 'httpService', '$location', function($scope, httpService, $location) {
	$scope.backToHome=function(){
		$location.path('/home');
	};
	$scope.getCount = function (i) {
	    var iCount = iCount || 0;
	    for (var j = 0; j < $scope.userMoods.length; j++) {
	        if ($scope.userMoods[j].mood == i) {
	            iCount++;
	        }
	    }
	    return iCount;
	}
	
	$scope.getAllUserMoodsOfTheDay=function(){
		httpService.fetchAllUserMoodsOfTheDay().then(onSuccess, onError);
	 };
	 
	 var onError = function errorCallback(reason) {
		alert("Error while retrieving user moods...");
	 };
	
	 var onSuccess = function successCallback(data) {
		 $scope.userMoods = data;
	 };
	 
	 $scope.getAllUserMoodsOfTheDay();
}]);
