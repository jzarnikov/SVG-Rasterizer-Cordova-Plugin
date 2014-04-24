package at.irian.cordova.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SVGRasterizationPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if ("rasterize".equals(action)) {
            try {
                int width = (int) Math.ceil(args.getDouble(1));
                int height = (int) Math.ceil(args.getDouble(2));
                callbackContext.success(convertSvgToDataUri(args.getString(0), width, height));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                callbackContext.error(e.getMessage());
                return false;
            }
        }
        return false;
    }

    private String convertSvgToDataUri(String path, int width, int height) throws SVGParseException, IOException {
        InputStream svgData = cordova.getActivity().getBaseContext().getAssets().open(path);
        return "data:image/png;base64," + convertSvgToBase64EncodedPng(svgData, width, height);
    }

    private String convertSvgToBase64EncodedPng(InputStream svgData, int width, int height) throws SVGParseException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        writeSvgAsPng(svgData, width, height, outputStream);
        byte[] data = outputStream.toByteArray();
        return Base64.encodeToString(data, Base64.DEFAULT);
    }

    private void writeSvgAsPng(InputStream svgData, int width, int height, OutputStream output) throws SVGParseException {
        SVG svg = SVG.getFromInputStream(svgData);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        svg.renderToCanvas(canvas);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
    }
}
