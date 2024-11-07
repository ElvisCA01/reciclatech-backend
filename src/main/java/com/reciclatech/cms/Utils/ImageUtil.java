package com.reciclatech.cms.Utils;

import java.util.Base64;

public class ImageUtil {
    public static String getImgData(byte[] byteData) {
        if (byteData == null || byteData.length == 0) {
            return null;
        }
        return Base64.getEncoder().encodeToString(byteData);
    }
}