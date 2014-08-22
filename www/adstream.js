var argscheck = require('cordova/argscheck'),
    utils = require('cordova/utils'),
    exec = require('cordova/exec');

var AdStream = function(src, successCallback, errorCallback, statusCallback) {
    this.id = utils.createUUID();
    this.src = src;
    this.successCallback = successCallback;
    this.errorCallback = errorCallback;
    this.statusCallback = statusCallback;
    this._duration = -1;
    this._position = -1;
    exec(null, this.errorCallback, "AdStream", "create", []);
};

/**
 * Start or resume playing audio file.
 */
AdStream.prototype.muestraAdd = function() {
    exec(null, null, "AdStream", "muestra", []);
};

module.exports = AdStream;

