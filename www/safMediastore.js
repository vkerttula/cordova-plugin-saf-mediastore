/*global cordova, module*/

var actions=[
	'selectFolder',
	'selectFile',
	'openFolder',
	'openFile',
	'readFile',
	'writeFile',
	'saveFile'
];

function callPromise(name){
	return function(params){
		return new Promise(function(resolve,reject){
			cordova.exec(resolve,reject,'SafMediastore',this,params);
		});
	}.bind(name);
}

var exports={};

for(var i=0;i<actions.length;++i){
	exports[actions[i]]=callPromise(actions[i]);
}

module.exports=exports;