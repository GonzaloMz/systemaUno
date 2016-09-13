var express = require('express');
var router = express.Router();
var product = require('./product.js');

console.log(product);
router.get('/',function(req, res, next){
  res.render('index', { title: 'Express' });
});

router.get('/createProduct', product.createProduct);

router.post('/createProduct', product.saveProduct);

router.get('/getProducts', product.getProducts)

module.exports = router;
