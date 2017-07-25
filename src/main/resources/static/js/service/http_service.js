/**
 * 
 */
'use strict';
 
angular.module('myApp').factory('httpService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/api/usermood/';
 
    var factory = {
    	fetchAllUserMoodsOfTheDay: fetchAllUserMoodsOfTheDay,
        saveUserMood: saveUserMood
    };
 
    return factory;
    
    function fetchAllUserMoodsOfTheDay() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching user moods');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function saveUserMood(mood) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, mood)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while saving user mood.');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);