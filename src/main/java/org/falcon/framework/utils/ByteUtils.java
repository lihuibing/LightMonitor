package org.falcon.framework.utils;

/**
 * Created by lihuibing on 2017/6/19.
 */
public class ByteUtils {
    public static String bytesToString(byte[] bytes) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++)
        {
            String s = Integer.toHexString(bytes[i] & 0xff);
            if (s.length() < 2)
                sBuffer.append('0');
            sBuffer.append(s + " ");
        }
        return sBuffer.toString().toUpperCase();
    }
}
