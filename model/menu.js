var mongoose = require('mongoose')
  , Schema = mongoose.Schema;
  
 var optionsSchema = new Schema({
		name: {type:String, required:true}
		, options: [{type:String, required:true}]
	 });
	 
module.exports=mongoose.model('Option', optionsSchema);
