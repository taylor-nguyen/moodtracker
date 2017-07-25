/**
 * 
 */
'use strict';
 
angular.module('myApp').controller('appController', ['$scope', 'httpService', '$location', function($scope, httpService, $location) {
    
    $scope.submit=function(){
		var mood=$scope.selectedMood;
		var message=$scope.message;
		var details={
			"mood":mood,
			"message":message,
		};
		
		httpService.saveUserMood(details).then(onSuccessSubmitted, onErrorSubmitted);
	 };
	 
	 var onErrorSubmitted = function(reason) {
		alert("Error while saving...");
	 };
	
	 var onSuccessSubmitted = function(data) {
		alert("Thank you, your rating has been submitted.");
		$location.path('/dashboard');
	 };
}]);