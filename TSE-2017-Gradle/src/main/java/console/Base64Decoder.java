package console;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Decoder {

    public static String decode(String base64) throws IllegalArgumentException {
        String decodedString = null;

        try {
            byte[] decoded = Base64.getDecoder().decode(base64.getBytes());
            decodedString = new String(decoded, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            System.err.println("Unable to decode the given Base64 string because it does not support UTF-8.");
            e.printStackTrace();
        }


        return decodedString;
    }
}
