/**
 * 
 */
'use strict';
 
var myApp = angular.module('myApp',['ngRoute', 'angular.filter']);
myApp.config(function($routeProvider) {
	$routeProvider
	.when("/home", {
		templateUrl:"/views/homepage.html",
		controller:"appController"
	})
	.when("/dashboard", {
		templateUrl:"/views/dashboard.html",
		controller:"dashboardController"
	})
	.otherwise({
		redirectTo:"/home"
	});
});