package Util;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {

    private static final String MENU_FILENAME = "src/main/resources/Menu.json";
    /**
     * Create an JSONArray from a json file
     * @return JSONArray object
     */
    private static JSONArray findArray(){

        JSONArray arr = null;
        try {

            BufferedReader br = new BufferedReader(new FileReader(MENU_FILENAME));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            arr = new JSONArray(everything);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }

    /**
     *
     * @param itemName
     * @return
     */
    public static JSONObject findItem(String itemName){
        JSONObject obj = null;
        JSONArray arr = JSONReader.findArray();
        for(int i = 0; i < arr.length(); i++) {

            obj = arr.getJSONObject(i);
            String name = obj.getString("name");

            if(name.equals(itemName)) {
                return obj;
            }
        }

        return obj;
    }

    public static JSONObject findKey(JSONObject obj, String key){

        return obj.getJSONObject(key);
    }
}
