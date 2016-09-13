var Product = require('../model/product');

var product = {};

product.createProduct = function (req, res, next){
	res.render('newProduct');
	}
	
product.saveProduct = function (req, res, next){
	newProduct = new Product(req.body);
	newProduct.save(function(err, doc){
			if (err)
				res.send(err);
			res.send(doc);		
		});
}

product.getProducts = function (req, res, next){
	Product.find({}, function(err, docs){
		if (err)
				res.send(err);
		res.render('showProducts', {products:docs});
	});
}

module.exports = product;
