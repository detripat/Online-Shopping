'use strict';
var storeApp = angular.module('PetStoreApp', [ 'ngRoute', 'ngResource']);
storeApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/store', {
		templateUrl : 'views/productStore.htm',
		controller : 'storeController'
	}).when('/products/:productSku', {
		templateUrl : 'views/product.htm',
		controller : 'storeController'
	}).when('/cart', {
		templateUrl : 'views/shoppingCart.htm',
		controller : 'storeController'
	}).when('/checkout', {
		templateUrl : 'views/orderCheckout.htm',
		controller : 'storeController'
		
	/*}).when('/admin', {
		templateUrl : 'views/admin.htm',
		controller : 'storeController'*/
			
			
			
			
	}).otherwise({
		redirectTo : '/store'
	});
} ]);

// create a data service that provides a store and a shopping cart that
// will be shared by all views (instead of creating fresh ones for each view).
storeApp.factory("DataService", [ '$http', '$resource',
		function($http, $resource) {

			// create store
			var myStore = new store($http);

			// create shopping cart
			var myCart = new shoppingCart("PetStoreApp");

			// return data object with store and cart
			return {
				store : myStore,
				cart : myCart
			};
		} ]);
