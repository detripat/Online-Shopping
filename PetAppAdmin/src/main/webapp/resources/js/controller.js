'use strict';

storeApp
		.controller(
				'storeController',
				function($scope, $routeParams, $http, $resource) {

					var UserObject = [];

					$scope.productManageAdd = function(prodName, prodDesc,
							prodPrice, prodQuant, category) {
						console.log("Adding product");

						$http
								.get(
										'http://localhost:8080/PetAppAdmin/productAddAdmin'
												+ '/' + prodName + '/'
												+ prodDesc + '/' + prodPrice
												+ '/' + prodQuant + '/'
												+ category)
								.success(
										function(data) {
											console
													.log("inside productManageAdd success :"
															+ JSON
																	.stringify(data));
											$scope.productManageAll();
											$scope.prodName = '';
											$scope.prodDesc = '';
											$scope.prodPrice = '';
											$scope.prodQuant = '';

										}).error(function(data) {
									alert("inside Error " + data);
								});

					};

					$scope.productManageAll = function() {
						var productObject = [];
						console.log("in admin product");
						$http
								.get(
										'http://localhost:8080/PetAppAdmin/productMasterAdmin')
								.success(
										function(data, status, headers, config) {
											console.log("inside success"
													+ JSON.stringify(data));

											var temp = JSON.stringify(data);
											for (var i = 0; i < data.length; i++) {
												var sku = data[i].productId;
												var name = data[i].productName;
												var desc = data[i].productDescription;
												var price = data[i].productPrice;
												var category = data[i].productCatagory;
												var catagoryId = category.catagoryId;
												var catagoryName = category.catagoryName;
												var quantity = data[i].productQuantity;
												productObject[i] = new product(
														sku, name, desc, price,
														catagoryName,
														catagoryId, quantity);
											}

										})
								.error(
										function(data, status, headers, config) {
											alert("inside Error " + data
													+ " Header : " + headers
													+ "Status : " + status
													+ "config : " + config);

										});

						this.products = productObject;

					};

					$scope.editProduct = function(product) {
						alert("Inside Edit User : " + product.sku + "---"
								+ product.name + "---" + product.price);

						$http.get(
								'http://localhost:8080/PetAppAdmin/productEditAdmin'
										+ '/' + product).success(
								function(data) {
									console.log("inside editProduct success"
											+ JSON.stringify(data));
									$scope.productManageAll();
								}).error(function(data) {
							alert("inside Error " + data);
						});

						$scope.prodName = product.name
						$scope.prodDesc = product.description
						$scope.prodPrice = product.price
						$scope.prodQuant = product.quantity
						$scope.category = product.catagoryName
					};

					$scope.deleteProduct = function(productId) {

						alert("Inside delete User : " + productId);

						$http.get(
								'http://localhost:8080/PetAppAdmin/productDeleteAdmin'
										+ '/' + productId).success(
								function(data) {
									console.log("inside deleteProduct success"
											+ JSON.stringify(data));
									$scope.productManageAll();
								}).error(function(data) {
							alert("inside Error " + data);
						});

					};

					$scope.getAllCategory = function() {

						var categoryObject = [];
						$http
								.get(
										'http://localhost:8080/PetAppAdmin/allCategoryAdmin')
								.success(
										function(data) {
											console
													.log("inside getAllCategory success"
															+ JSON
																	.stringify(data));
											$scope.categorys = data;

											// var temp = JSON.stringify(data);
											// for (var i = 0; i < data.length;
											// i++) {
											// var catId = data[i].catagoryId;
											// var catName=data[i].catagoryName;
											//			
											// categoryObject[i] = new
											// category(catId,catName);
											// }
										}).error(function(data) {
									alert("inside Error " + data);
								});

					};

					$scope.addCategory = function(catagoryName) {
						console.log("Adding category " + catagoryName);

						$http.get(
								'http://localhost:8080/PetAppAdmin/addcategory'
										+ '/' + catagoryName).success(
								function(data) {
									console.log("inside addCategory success :"
											+ JSON.stringify(data));

									$scope.categoryName = '';

								}).error(function(data) {
							alert("inside Error " + data);
						});

					};

					$scope.loginUser = function(uname, password) {

						// var UserObject=[];
						if (uname == undefined || password == undefined) {
							alert("Please enter all the fields");
						} else {
							$http
									.get(
											'http://localhost:8080/PetAppAdmin/userLogin'
													+ '/' + uname + '/'
													+ password)
									.success(
											function(data) {

												if (data.firstName == null) {
													alert("Invalid User, Please try once again or Register");
													$scope.uname = "";
													$scope.password = "";

												} else {
													console
															.log("response "
																	+ JSON
																			.stringify(data));
													$("#userNameId")
															.val(
																	"Welcome "
																			+ data.firstName);
													$('#userNameId').show();
													console.log("sssssss")
													UserObject[0] = new adminDetails(
															data.userId,
															data.firstName,
															data.middleName,
															data.lastName,
															data.addressLine1,
															data.addressLine2,
															data.city,
															data.state);
													
													console
															.log("inside UserObject "
																	+ UserObject);
													$scope.adminDetails = UserObject;
													document.getElementById(
															"userLoginDialog")
															.close();
												}
											})
						}

					};

					$scope.registerNewUser = function(firstname, lastname,
							middlename, address, username, password) {
						var flag = true;
						if (firstname == undefined || lastname == undefined
								|| username == undefined
								|| middlename == undefined
								|| address == undefined
								|| password == undefined) {

							alert("Please enter all the fields");
							flag = false;

						}
						if (firstname != undefined && lastname != undefined
								&& middlename == undefined
								&& address == undefined
								&& username == undefined
								&& password != undefined) {

							alert("Please enter the Email Id in proper format");
							flag = false;

						}

						if (flag == true) {
							console.log("inside reg ");
							$http
									.get(
											'http://localhost:8080/PetAppAdmin/addNewUser'
													+ '/' + firstname + '/'
													+ lastname + '/'
													+ middlename + '/'
													+ address + '/' + username
													+ '/' + password)
									.success(
											function(data) {
												document.getElementById(
														"userRegisterDialog")
														.close();
												alert("Registered Successfully")
												console
														.log(" please save UserDetails  "
																+ JSON
																		.stringify(data));

											});
						}
					};

					$scope.userDetails = function() {
						var userAdmin = [];
						console.log("inside user");
						$http
								.get(
										'http://localhost:8080/PetAppAdmin/userAdmin')
								.success(
										function(data, status, headers, config) {
											console.log("inside success"
													+ JSON.stringify(data));

											var temp = JSON.stringify(data);
											for (var i = 0; i < data.length; i++) {
												var sku = data[i].userId;
												var name = data[i].userName;
												var pass = data[i].password;
												var firstName = data[i].firstName;
												var middlename = data[i].middleName;
												var lname = data[i].lastName;
												var addressLine1 = data[i].addressLine1;
												var addressLine2 = data[i].addressLine2;

												var city = data[i].city;
												var state = data[i].state;
												var usertype = data[i].userType;
												var email = data[i].email;

												userAdmin[i] = new user(sku,
														name, pass, firstName,
														middlename, lname,
														addressLine1,
														addressLine2, city,
														state, usertype, email);
											}

										})
								.error(
										function(data, status, headers, config) {
											alert("inside Error " + data
													+ " Header : " + headers
													+ "Status : " + status
													+ "config : " + config);

										});

						this.users = userAdmin;

					};
					/*	*/

				});

function product(sku, name, description, price, catagoryName, catagoryId,
		quantity) {
	this.sku = sku;
	this.name = name;
	this.description = description;
	this.price = price;

	this.catagoryName = catagoryName;
	this.catagoryId = catagoryId;
	this.quantity = quantity;
}

function category(catId, CatName) {
	this.catId = catId;
	this.CatName = CatName;
}

function adminDetails(userId, firstName, middleName, lastName, addressLine1,
		addressLine2, city, state) {

	this.userId = userId;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.city = city;
	this.state = state;

}

function user(sku, name, pass, firstName, middlename, lname, addressLine1,
		addressLine2, city, state, userType, emial) {
	this.sku = sku;
	this.name = name;
	this.pass = pass;
	this.firstName = firstName;

	this.middlename = middlename;
	this.lname = lname;

	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.city = city;

	this.state = state;
	this.userType = userType;
	this.emial = emial;

}
