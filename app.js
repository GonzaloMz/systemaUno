
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , bodyParser = require('body-parser')
  , errorhandler = require('errorhandler')
  , index= require('./routes/index')
  , mongoose = require('mongoose')
  , menu = require('./model/menu');

mongoose.connect('mongodb://127.0.0.1:27017/test');

var app = module.exports = express();

// Configuration

app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(bodyParser.urlencoded());

app.use(bodyParser.json());
//app.use(express.methodOverride());
app.use(express.static(__dirname + '/public'));
app.set('port', process.env.PORT || 3000);

var env = process.env.NODE_ENV || 'development';
if ('development' == env){
	app.use(errorhandler({ dumpExceptions: true, showStack: true }));
}

if('production' == env){
	app.use(errorhandler());
};

menu.find({}, function(err, docs){
		for( i in docs){
			app.locals[docs[i].name] = docs[i].options;
		}
	});

// Routes
app.use('/',index);

app.listen(app.get('port'), function(){
  console.log("Express server listening on port %d in %s mode", app.get('port'), app.settings.env);
});
