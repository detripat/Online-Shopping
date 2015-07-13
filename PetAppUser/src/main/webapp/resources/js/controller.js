'use strict';


storeApp.controller('storeController',  function ($scope, $routeParams, DataService, $http,$resource) {

	// get store and cart from service
	$scope.store = DataService.store;

	$scope.cart = DataService.cart;

	// use routing to pick the selected product
	if ($routeParams.productSku != null) {
		$scope.product = $scope.store.getProduct($routeParams.productSku);
	}

	var UserObject = [];

	// This method is for user login
	$scope.loginUser = function(uname, password) {
		if (uname == undefined || password == undefined) {
			alert("Please enter all the fields");
		} else {
			 $http.get('http://localhost:8080/PetAppUser/userLogin'+'/'+ uname +'/'+ password).
		     success(function(data) {
		         if (data.firstName == null) {
						alert("Invalid User, Please try once again or Register");
						$scope.uname = "";
						$scope.password = "";

					} else {
						console.log("response "
								+ JSON.stringify(data));
						$("#userNameId").val(
								"Welcome " + data.firstName);
						$('#userNameId').show();
						UserObject[0] = new userDetails(
								data.userId, data.firstName,
								data.middleName, data.lastName,
								data.addressLine1,
								data.addressLine2, data.city,
								data.state);
						console.log("inside UserObject "
								+ UserObject);
						$scope.cart.userDetails = UserObject;
						document.getElementById("userLoginDialog").close();
					}
		    });
		}

	};

	// This method is for user registration
	$scope.registerNewUser = function(firstname,lastname,middlename,address,username,password) {
		var flag = true;
		if (firstname == undefined
				|| lastname == undefined || username == undefined || middlename == undefined || address == undefined
				|| password == undefined) {

			alert("Please enter all the fields");
			flag = false;

		}
		if (firstname != undefined 
				&& lastname != undefined 
				&& middlename == undefined 
				&& address == undefined 
				&&  username == undefined
				&& password != undefined ) {

			alert("Please enter the Email Id in proper format");
			flag = false;

		}
		

		if (flag == true) {
			console.log("inside reg ");
			$http.get('http://localhost:8080/PetAppUser/addNewUser' + '/' + firstname + '/' + lastname +  '/'+ middlename + '/'+ address + '/'
					+ username + '/' + password).success(function(data) {
				document.getElementById("userRegisterDialog").close();
				alert("Registered Successfully")
				console.log(" please save UserDetails  " + JSON.stringify(data));

			});
		}
	};

	// This method is for random string generation for transaction ID
	$scope.randomString = function() {
		var randomObject = [];
		var orderID = " ";
		var transactionID = " ";
		var charset = "abcdefghijklmnopqrstuvwxyz0123456789";
		for (var i = 0; i < 7; i++) {
			orderID += charset.charAt(Math
					.floor(Math.random() * charset.length));
		}
		for (var i = 0; i < 7; i++) {
			transactionID += charset.charAt(Math.floor(Math.random()
					* charset.length));
		}
		// return text;
		randomObject[0] = new randomGenerator(orderID, transactionID);
		$scope.cart.randomGenerator = randomObject;

	}

	// This method is for Place order

	$scope.placeOrder = function(userId, transactionID, totalPrice, status,
			cartItems) {
		//transactionID="abcdefghijklmnopqrstuvwxyz0123456789";
		alert(userId +"  "+transactionID)
		alert("Your Ordr is Sucess");
		console.log("response placeOrder :" + JSON.stringify(cartItems));
		$http(
				{
					method : 'GET',
					url : 'paymentCheckOut' + '/' + userId + '/'
							+ transactionID + '/' + totalPrice + '/' + status
							+ '/' + JSON.stringify(cartItems),
				}).success(function(data) {
			console.log("response " + JSON.stringify(data));
		}).error(function(data, status, headers, config) {
			alert("Inside Error" + data);
		});

	};

});
