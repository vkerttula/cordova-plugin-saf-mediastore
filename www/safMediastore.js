/*global cordova, module*/

let actions=[
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
		return new Promise((
			resolve,
			reject
		)=>cordova.exec(
			resolve,
			reject,
			'SafMediastore',
			this.name,
			params
		));
	}.bind({name});
}

let exports={};

for(let i=0;i<actions.length;++i){
	exports[actions[i]]=callPromise(actions[i]);
}

module.exports=exports;