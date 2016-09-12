var product = {};

product.createProduct = function (req, res, next){
	res.render('newProduct');
	}
	
product.saveProduct = function (req, res, next){
	console.log(req.body);
	res.send('ok');
}

module.exports = product;
