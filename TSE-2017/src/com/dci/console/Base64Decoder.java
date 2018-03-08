package com.dci.console;

import java.util.Base64;

public class Base64Decoder {

    public static String decode(String base64) {
        String decodedString = null;

        try {
            byte[] decoded = Base64.getDecoder().decode(base64.getBytes());
            decodedString = new String(decoded, "UTF-8");
        }
        catch (Exception e) {
            System.err.println("Unable to decode the given Base64 string.");
            e.printStackTrace();
        }


        return decodedString;
    }
}
