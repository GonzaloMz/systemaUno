var mongoose = require('mongoose')
  , Schema = mongoose.Schema;

var productSchema = new Schema(
	{
		code: {type:String, required:true, unique:true}
		, description: {type:String, required:true}
		, type: {type:String, required:true}
		, factory: {type:String, required:true}
		, available: [
			{
				size: {type:String, required:true}
				, color: {type:String, required:true}
			}
		]
	}
);

module.exports=mongoose.model('Product', productSchema);
