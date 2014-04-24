
var SVGRasterizer = function() {};
var exec = require('cordova/exec');
SVGRasterizer.prototype.rasterize = function(path, width, height, successCallback, failureCallback) {
    return exec(successCallback, failureCallback, 'SVGRasterizer', 'rasterize', [path, width, height]);
};

window.plugins = window.plugins || {};
window.plugins.SVGRasterizer = window.plugins.SVGRasterizer || new SVGRasterizer();


if (typeof module != 'undefined' && module.exports) {
		module.exports = SVGRasterizer;
}