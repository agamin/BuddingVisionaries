var express = require('express');
var cassandra = require('cassandra-driver');
var client = new cassandra.Client({contactPoints: ['192.168.1.106', '9160'], keyspace: 'restaurant'});
var router = express.Router();

/* GET users listing. */
router.get('/:restaurantId', function(req, res) {
  var restaurantId = req.params.restaurantId;
  var query = "select * from MENU where RESTAURANT_CODE = ?";
  client.execute (query, [restaurantId], function (err,result) {
  	if (err) {
  		console.log(err);
  	}
  	res.send(createMenuObject(result));
  });
  
});

function createMenuObject(result) {
	var menu = {};
	var rows = result.rows;

	for (var i=0; i< rows.length; i++) {
		menu[rows[i]['id']] = rows[i];
	}
	return menu;
}
module.exports = router;
