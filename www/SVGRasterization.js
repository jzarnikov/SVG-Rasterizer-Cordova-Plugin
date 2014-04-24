
var SVGRasterization = function() {};
var exec = require('cordova/exec');
SVGRasterization.prototype.rasterize = function(path, width, height, successCallback, failureCallback) {
    return exec(successCallback, failureCallback, 'SVGRasterization', 'rasterize', [path, width, height]);
};

window.plugins = window.plugins || {};
window.plugins.SVGRasterization = window.plugins.SVGRasterization || new SVGRasterization();


if (typeof module != 'undefined' && module.exports) {
		module.exports = SVGRasterization;
}