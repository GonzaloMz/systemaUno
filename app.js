
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , bodyParser = require('body-parser')
  , errorhandler = require('errorhandler');

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

// Routes

app.route('/').get(routes.index);

app.listen(app.get('port'), function(){
  console.log("Express server listening on port %d in %s mode", app.get('port'), app.settings.env);
});
