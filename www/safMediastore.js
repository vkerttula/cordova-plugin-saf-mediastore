/*global cordova, module*/

module.exports = (function () {
  function callPromise(name) {
    return function (...params) {
      return new Promise((resolve, reject) =>
        cordova.exec(resolve, reject, 'SafMediastore', this.name, params)
      );
    }.bind({ name });
  }

  let exports = {};

  [
    'selectFolder',
    'selectFile',
    'openFolder',
    'openFile',
    'readFile',
    'writeFile',
    'overwriteFile',
    'saveFile',
    'deleteFile',
    'getFileName',
    'getUri',
    'existsFile',
    'getDataForOpenFile',
    'touchFile',
    'readFolder',
    'arePermissionsGranted'
  ].forEach((action) => (exports[action] = callPromise(action)));

  return exports;
})();
