/*THIS PRODUCT STORE JS GIVES PRODUCT DETAILS */
function store($http) {
	var productObject = [];
	$http({
		method : 'GET',
		url : 'productMaster'
	}).success(
			function(data, status, headers, config) {
				/*console.log(" success" + data);*/
				var temp = JSON.stringify(data);
				for (var i = 0; i < data.length; i++) {
					var sku = data[i].productId;
					var name = data[i].productName;
					var desc = data[i].productDescription;
					var price = data[i].productPrice;
					var category = data[i].productCatagory;
					var catagoryId = category.catagoryId;
					var catagoryName = category.catagoryName;
					productObject[i] = new product(sku, name, desc, price,catagoryName,
							catagoryId);

				}
			}).error(
			function(data, status, headers, config) {
				alert("inside Error " + data + " Header : " + headers
						+ "Status : " + status + "config : " + config);

			});

	this.products = productObject;

}
store.prototype.getProduct = function(sku) {
	for (var i = 0; i < this.products.length; i++) {
		if (this.products[i].sku == sku)
			return this.products[i];
	}
	return null;
}


