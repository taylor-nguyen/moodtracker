/**
 * 
 */
'use strict';
 
angular.module('myApp').controller('appController', ['$scope', 'httpService', '$location', '$cookies', function($scope, httpService, $location, $cookies) {
    
    $scope.submit=function(){
		var mood=$scope.selectedMood;
		var message=$scope.message;
		var details={
			"mood":mood,
			"message":message,
		};
		if($cookies.get('submitted')) {
			alert("Sorry, you have already submitted your response for the day, try again tomorrow!");
		} else {
			// set up a cookie so user can only submit once a day
			var expiryDate = new Date();
			expiryDate.setDate(expiryDate.getDate() + 1);
			expiryDate.setHours(0, 0, 0, 0);
			$cookies.put('submitted', 'true', {'expires' : expiryDate});
			
			httpService.saveUserMood(details).then(onSuccessSubmitted, onErrorSubmitted);
		}
	 };
	 
	 var onErrorSubmitted = function(reason) {
		alert("Error while saving...");
	 };
	
	 var onSuccessSubmitted = function(data) {
		alert("Thank you, your rating has been submitted.");
		$location.path('/dashboard');
	 };
}]);