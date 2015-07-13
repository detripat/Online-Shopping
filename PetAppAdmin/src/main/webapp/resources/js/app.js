'use strict';
var storeApp = angular.module('WebStoreAdmin', [ 'ngRoute', 'ngResource' ]);
storeApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/productDetails', {
		templateUrl : 'views/product.htm',
		controller : 'storeController'
	}).when('/categoryDetails', {
		templateUrl : 'views/category.htm',
		controller : 'storeController'
	}).when('/orderDetails', {
		templateUrl : 'views/order.htm',
		controller : 'storeController'
	}).when('/userDetails', {
		templateUrl : 'views/user.htm',
		controller : 'storeController'
	}).otherwise({
		redirectTo : '/productDetails'
	});
} ]);
