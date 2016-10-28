package br.com.marioneto.productcatalog.core.util;

import android.os.Build;
import android.text.Html;

/**
 * Created by mario_1a on 27/10/16.
 */

public class StringFormatUtils {
    public static String parseHtml(String originalString) {
        String returnString = "";

        if (Build.VERSION.SDK_INT >= 24) {
            returnString = Html.fromHtml(originalString, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            returnString = Html.fromHtml(originalString).toString();
        }

        return returnString;
    }
}
