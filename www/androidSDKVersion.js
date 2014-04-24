
var AndroidSDKVersion = function() {};
var exec = require('cordova/exec');
AndroidSDKVersion.prototype.getCodename = function(successCallback, failureCallback) {
    return exec(successCallback, failureCallback, 'AndroidSDKVersion', 'codename', []);
};
AndroidSDKVersion.prototype.getIncremental = function(successCallback, failureCallback) {
    return exec(successCallback, failureCallback, 'AndroidSDKVersion', 'incremental', []);
};
AndroidSDKVersion.prototype.getRelease = function(successCallback, failureCallback) {
    return exec(successCallback, failureCallback, 'AndroidSDKVersion', 'release', []);
};
AndroidSDKVersion.prototype.getSdk = function(successCallback, failureCallback) {
    return exec(successCallback, failureCallback, 'AndroidSDKVersion', 'sdk', []);
};

window.plugins = window.plugins || {};
window.plugins.androidSDKVersion = window.plugins.androidSDKVersion || new AndroidSDKVersion();


if (typeof module != 'undefined' && module.exports) {
		module.exports = AndroidSDKVersion;
}