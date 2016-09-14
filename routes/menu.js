var Menu = require('../model/menu');

var menu={};

menu.addOption = function(req,res,next){
	menuName=req.params.menu;
	newOption=req.params.option;
	Menu.findOne({name:menuName},function(err, doc){
		doc.options.unshift(newOption);
		doc.save();
		req.app.locals[doc.name]=doc.options;
		res.send('ok');
	});
}

module.exports=menu;
